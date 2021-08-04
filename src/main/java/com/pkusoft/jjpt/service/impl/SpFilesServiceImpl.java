package com.pkusoft.jjpt.service.impl;

import com.pkusoft.jjpt.mapper.SpFilesMapper;
import com.pkusoft.jjpt.po.SpFiles;
import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.po.SpRecord;
import com.pkusoft.jjpt.po.ZzjbjFjxx;
import com.pkusoft.jjpt.req.SpFilesReqParam;
import com.pkusoft.jjpt.service.*;
import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.service.BdEquipmentService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pkubatis.common.constants.JjptConstantCode;
import sun.misc.BASE64Encoder;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class SpFilesServiceImpl implements SpFilesService {

    @Autowired
    private SpFilesMapper spFilesMapper;

    @Autowired
    private SpJjxxService spJjxxService;

    @Autowired
    private SpRecordService spRecordService;

    @Autowired
    private HadoopService hadoopService;

    @Value(value = "${dfs.hadoopUrl}")
    private String hadoopUrl;

    @Autowired
    private ZzjbjFjxxService zzjbjFjxxService;

    @Autowired
    private BdEquipmentService bdEquipmentService;

    public List<SpFiles> getSpFilesList(SpFilesReqParam spFiles, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(spFiles.getStart(),spFiles.getPageSize());
        Example example = new Example(SpFiles.class);
        example.setOrderByClause("CREATE_TIME desc");
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spFiles);

        return spFilesMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSpFilesCount(SpFilesReqParam spFiles,Map<String, String> map) {

        Example example = new Example(SpFiles.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spFiles);

        return spFilesMapper.selectCountByExample(example);
    }

    public List<SpFiles> getFileListByAobjidAndObjtype(SpFiles spFiles) {

        Example example = new Example(SpFiles.class);
        example.setOrderByClause("CREATE_TIME desc");
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if (StringUtils.hasText(spFiles.getAObjid())){
            criteria.andEqualTo("aObjid",spFiles.getAObjid());
        }
        if (StringUtils.hasText(spFiles.getObjtype())){
            String objtype = spFiles.getObjtype();
            String[] typeArr = objtype.split(",");
            if (typeArr.length>0){
                List<String> typeList = new ArrayList<>();
                for (String type:typeArr) {
                    typeList.add(type);
                }
                criteria.andIn("objtype",typeList);
            }
        }
        return spFilesMapper.selectByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, SpFilesReqParam spFiles){
        if (StringUtils.hasText(spFiles.getAObjid())){
            criteria.andEqualTo("aObjid",spFiles.getAObjid());
        }
        if (StringUtils.hasText(spFiles.getObjtype())){
            criteria.andEqualTo("objtype",spFiles.getObjtype());
        }
        if (StringUtils.hasText(spFiles.getTransId())){
            criteria.andEqualTo("transId",spFiles.getTransId());
        }
    }

    public int doSpFilesSave(SpFiles spFiles, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        spFiles.setObjid(objid);
		spFiles.setObjcode(objid);
        Date date = new Date();
        spFiles.setOrgCode(map.get("deptId"));
        spFiles.setOrgName(map.get("deptName"));
        spFiles.setCreateName(map.get("userName"));
        spFiles.setCreateId(map.get("userId"));
        spFiles.setCreateTime(date);
        spFiles.setModerName(map.get("userName"));
        spFiles.setModerId(map.get("userId"));
        spFiles.setModerTime(date);
        return spFilesMapper.insertSelective(spFiles);
    }

    public int spFilesSave(SpFiles spFiles, Map<String,String> map){
//        String objid = UUID.randomUUID().toString();
//        spFiles.setObjid(objid);
//        spFiles.setObjcode(objid);
        String ret = hadoopService.hadoopFileUpload(spFiles.getPapersPhoto());
        if (StringUtils.hasText(ret) && !"error".equals(ret) && !"exception".equals(ret)) {
            spFiles.setPapersPhoto(ret);
        }else {
            return -1;
        }
        Date date = new Date();
        if (JjptConstantCode.SP_FILE_TYPE_0001.equals(spFiles.getObjtype())||JjptConstantCode.SP_FILE_TYPE_0004.equals(spFiles.getObjtype())){
            SpJjxx spJjxx = spJjxxService.getSpJjxx(spFiles.getAObjid());
            if (spFiles.getAObjid() !=null && spJjxx!=null){
                spFiles.setOrgCode(spJjxx.getOrgCode());
                spFiles.setOrgName(spJjxx.getOrgName());
                spFiles.setGaOwnerDept1(spJjxx.getGaOwnerDept1());
                spFiles.setGaOwnerDept2(spJjxx.getGaOwnerDept2());
                spFiles.setGaOwnerDept3(spJjxx.getGaOwnerDept3());
                spFiles.setGaOwnerDept4(spJjxx.getGaOwnerDept4());
                spFiles.setGaOwnerDept5(spJjxx.getGaOwnerDept5());
            }else {
                return -2;
            }
        }else if (JjptConstantCode.SP_FILE_TYPE_0002.equals(spFiles.getObjtype())
                ||JjptConstantCode.SP_FILE_TYPE_0003.equals(spFiles.getObjtype())
                ||JjptConstantCode.SP_FILE_TYPE_0005.equals(spFiles.getObjtype())
                ||JjptConstantCode.SP_FILE_TYPE_0009.equals(spFiles.getObjtype())){
            SpRecord spRecord = spRecordService.getSpRecord(spFiles.getAObjid());
            if (spRecord!=null){
                spFiles.setOrgCode(spRecord.getOrgCode());
                spFiles.setOrgName(spRecord.getOrgName());
                spFiles.setGaOwnerDept1(spRecord.getGaOwnerDept1());
                spFiles.setGaOwnerDept2(spRecord.getGaOwnerDept2());
                spFiles.setGaOwnerDept3(spRecord.getGaOwnerDept3());
                spFiles.setGaOwnerDept4(spRecord.getGaOwnerDept4());
                spFiles.setGaOwnerDept5(spRecord.getGaOwnerDept5());
            }else {
                return -3;
            }
        }else {
            return -4;
        }
        if (JjptConstantCode.SP_FILE_TYPE_0004.equals(spFiles.getObjtype())||JjptConstantCode.SP_FILE_TYPE_0005.equals(spFiles.getObjtype())){
            // 上传材料和关联笔录都是以文件上传的形式上传的，检查材料类型等信息是否完整
            if (StringUtils.hasText(spFiles.getObjname())){
                String[] nameArr = spFiles.getObjname().split("\\.");
                if (nameArr.length>0){
                    int nameArrEnd = nameArr.length-1;
                    String filetype = nameArr[nameArrEnd];
                    if (!StringUtils.hasText(spFiles.getFiletype())){
                        spFiles.setFiletype(filetype);
                    }
                    // 如果上传文件中有图片，则以图片形式显示
                    if (JjptConstantCode.SP_FILE_TYPE_0004.equals(spFiles.getObjtype())){
                        if ("jpg".equals(filetype)||"JPG".equals(filetype)||"png".equals(filetype)||"PNG".equals(filetype)
                                ||"jpeg".equals(filetype)||"JPEG".equals(filetype)||"bmp".equals(filetype)||"BMP".equals(filetype)){
                            spFiles.setObjtype(JjptConstantCode.SP_FILE_TYPE_0001);
                        }
                    }
                }
            }
        }
        // 没有文件名的，统一进行命名
        if (!StringUtils.hasText(spFiles.getObjname())){
            String fixStr = "file";
            if (JjptConstantCode.SP_FILE_TYPE_0001.equals(spFiles.getObjtype())){
                fixStr = "pic.jpg";
            }else if (JjptConstantCode.SP_FILE_TYPE_0002.equals(spFiles.getObjtype())){
                fixStr = "finger.jpg";
            }else if (JjptConstantCode.SP_FILE_TYPE_0003.equals(spFiles.getObjtype())){
                fixStr = "sign.jpg";
            }else if (JjptConstantCode.SP_FILE_TYPE_0009.equals(spFiles.getObjtype())){
                fixStr = "record.pdf";
            }
            spFiles.setObjname(new SimpleDateFormat("yyyyMMddHHmmss").format(date)+"-"+fixStr);
        }
        int num = this.doSpFilesSave(spFiles,map);
        return num;
    }

    public int spFilesSaveYGJW(SpFiles spFiles){
        Date date = new Date();
//        String objid = UUID.randomUUID().toString();objid由客户端生成
        SpFiles spFiles_old = spFilesMapper.selectByPrimaryKey(spFiles.getObjid());
        spFiles.setObjcode(spFiles.getObjid());
        BdEquipment bdEquipment = bdEquipmentService.getBdEquipmentByEId(spFiles.getCreateId());//字段接口调用将eid放在CreateId中
        if (bdEquipment != null) {
            spFiles.setOrgCode(bdEquipment.getOrgCode());
            spFiles.setOrgName(bdEquipment.getOrgName());
            spFiles.setGaOwnerDept1(bdEquipment.getGaOwnerDept1());
            spFiles.setGaOwnerDept2(bdEquipment.getGaOwnerDept2());
            spFiles.setGaOwnerDept3(bdEquipment.getGaOwnerDept3());
            spFiles.setGaOwnerDept4(bdEquipment.getGaOwnerDept4());
            spFiles.setGaOwnerDept5(bdEquipment.getGaOwnerDept5());
        }
        spFiles.setCreateTime(date);
        spFiles.setModerTime(date);
        if(spFiles_old!=null){
            return spFilesMapper.updateByPrimaryKeySelective(spFiles);
        }else{
            return spFilesMapper.insertSelective(spFiles);
        }
    }

    public int spFilesUpdate(SpFiles spFiles, Map<String,String> map){
        int num = spFilesMapper.updateByPrimaryKeySelective(spFiles);
        return num;
    }

    public int saveSpFileByWechatFileData(SpJjxx spJjxx, Map<String, String> user){
        int num = 0;
        String bjid = spJjxx.getBjid();
        List<ZzjbjFjxx> zzjbjFjxxList = zzjbjFjxxService.getZzjbjFjxxByBjid(bjid);
        for (ZzjbjFjxx zzjbjFjxx:zzjbjFjxxList){
            byte[] filedata = zzjbjFjxx.getPtoto();
            if (filedata!=null){
                String filebase64 = new BASE64Encoder().encode(filedata);

                String filepath = hadoopService.hadoopFileUpload(filebase64);
                if ("error".equals(filepath)||"exception".equals(filepath)){
                    return -1;
                }else if (StringUtils.hasText(filepath)){
                    SpFiles spFiles = new SpFiles();
                    String fjlx = zzjbjFjxx.getFjlx();
                    if (JjptConstantCode.YBJ_FILE_TYPE_1.equals(fjlx)){
                        // 图片
                        spFiles.setObjtype(JjptConstantCode.SP_FILE_TYPE_0001);
                    }else {
                        // 材料
                        spFiles.setObjtype(JjptConstantCode.SP_FILE_TYPE_0004);
                    }
                    Date date = new Date();
                    String objid = UUID.randomUUID().toString();
                    spFiles.setObjid(objid);
                    spFiles.setAObjid(spJjxx.getObjid());
                    spFiles.setPapersPhoto(filepath);
                    spFiles.setObjname(zzjbjFjxx.getReserve1());
                    spFiles.setObjcode(objid);
                    spFiles.setCreateTime(date);
                    spFiles.setCreateName(user.get("userName"));
                    spFiles.setCreateId(user.get("userId"));
                    spFiles.setModerName(user.get("userName"));
                    spFiles.setModerId(user.get("userId"));
                    spFiles.setModerTime(date);
                    spFiles.setGaOwnerDept1(spJjxx.getGaOwnerDept1());
                    spFiles.setGaOwnerDept2(spJjxx.getGaOwnerDept2());
                    spFiles.setGaOwnerDept3(spJjxx.getGaOwnerDept3());
                    spFiles.setGaOwnerDept4(spJjxx.getGaOwnerDept4());
                    spFiles.setGaOwnerDept5(spJjxx.getGaOwnerDept5());
                    spFiles.setOrgCode(spJjxx.getOrgCode());
                    spFiles.setOrgName(spJjxx.getOrgName());
                    spFiles.setOwnerType("1");
                    num = num + spFilesMapper.insertSelective(spFiles);
                }
            }
        }
        return num;
    }

    public SpFiles getSpFiles(String objid){
        return spFilesMapper.selectByPrimaryKey(objid);
    }

    public int spFilesDelete(String objid){
        int num = 0;
        num = spFilesMapper.deleteByPrimaryKey(objid);
        return num;
    }

	@Override
	public List<SpFiles> selectPicByCase(String jjdObjid, String objtype) {
        Example example = new Example(SpFiles.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("OBJTYPE ASC,CREATE_TIME DESC");
        //The query conditions are edited here
        criteria.andEqualTo("aObjid", jjdObjid);
        criteria.andCondition("objtype in ("+objtype+")");
//        criteria.andEqualTo("objtype", objtype);
        List<SpFiles> list = spFilesMapper.selectByExample(example);
        return list;
	}

    public List<SpFiles> getFileListByTransIdAndObjtype(SpFiles spFiles) {

        Example example = new Example(SpFiles.class);
        example.setOrderByClause("CREATE_TIME desc");
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if (StringUtils.hasText(spFiles.getTransId())){
            criteria.andEqualTo("transId",spFiles.getTransId());
        }
        if (StringUtils.hasText(spFiles.getObjtype())){
            String objtype = spFiles.getObjtype();
            String[] typeArr = objtype.split(",");
            if (typeArr.length>0){
                List<String> typeList = new ArrayList<>();
                for (String type:typeArr) {
                    typeList.add(type);
                }
                criteria.andIn("objtype",typeList);
            }
        }
        return spFilesMapper.selectByExample(example);
    }

}
