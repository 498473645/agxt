package com.pkusoft.jjpt.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.pkusoft.jjpt.po.SpCallRecord;
import com.pkusoft.jjpt.po.SpCjrxx;
import com.pkusoft.jjpt.po.SpFkxx;
import com.pkusoft.jjpt.req.SpJjxxReqParam;
import com.pkusoft.jjpt.service.*;
import com.pkusoft.pzzx.po.BdHandlingArea;
import com.pkusoft.pzzx.service.BdHandlingAreaService;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.usercenter.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import pkubatis.common.constants.JjptConstantCode;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.mapper.SpJjxxMapper;

@Service
@Transactional
public class SpJjxxServiceImpl implements SpJjxxService {

    @Autowired
    private SpJjxxMapper spJjxxMapper;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    @Autowired
    private ZzjbjBjxxService zzjbjBjxxService;

    @Autowired
    private HadoopService hadoopService;

    @Autowired
    private BdHandlingAreaService bdHandlingAreaService;

    @Autowired
    private SpFilesService spFilesService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SpCjrxxService spCjrxxService;

    @Autowired
    private SpFkxxService spFkxxService;

    @Autowired
    private SpCallRecordService spCallRecordService;

    public List<SpJjxx> getSpJjxxList(SpJjxxReqParam spJjxx, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(spJjxx.getStart(),spJjxx.getPageSize());
        Example example = new Example(SpJjxx.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("BJSJ DESC");
        //The query conditions are edited here
        this.setCommonCondition(criteria,spJjxx,map);

        return spJjxxMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSpJjxxCount(SpJjxxReqParam spJjxx, Map<String, String> map) {

        Example example = new Example(SpJjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spJjxx,map);

        return spJjxxMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, SpJjxxReqParam spJjxx, Map<String, String> map){
        criteria.andEqualTo("orgCode",map.get("deptId"));
        //接警编号
        if (StringUtils.hasText(spJjxx.getJjdbh())){
            criteria.andLike("jjdbh", "%" + spJjxx.getJjdbh() + "%");
        }
        //报警时间
        if( StringUtils.hasText(spJjxx.getStartBjsj()) && StringUtils.hasText(spJjxx.getEndBjsj()) ){
            //开始截止时间
            criteria.andCondition("bjsj between to_date('"+spJjxx.getStartBjsj()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+spJjxx.getEndBjsj()+"','yyyy-MM-dd hh24:mi:ss')");
        }
        //处警时间
        if( StringUtils.hasText(spJjxx.getStartCjsj()) && StringUtils.hasText(spJjxx.getEndCjsj()) ){
            //开始截止时间
            criteria.andCondition("cjsj between to_date('"+spJjxx.getStartCjsj()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+spJjxx.getEndCjsj()+"','yyyy-MM-dd hh24:mi:ss')");
        }
        //报警人
        if (StringUtils.hasText(spJjxx.getBjrxm())){
            criteria.andLike("bjrxm", "%" + spJjxx.getBjrxm() + "%");
        }
        //报警电话
        if (StringUtils.hasText(spJjxx.getBjdh())){
            criteria.andLike("bjdh", "%" + spJjxx.getBjdh() + "%");
        }
        //报警类型
        if (StringUtils.hasText(spJjxx.getJqtypeid1())){
            criteria.andEqualTo("jqtypeid1",spJjxx.getJqtypeid1());
        }
        //报警类别
        if (StringUtils.hasText(spJjxx.getJqtypeid2())){
            criteria.andEqualTo("jqtypeid2",spJjxx.getJqtypeid2());
        }
        //报警细类
        if (StringUtils.hasText(spJjxx.getJqtypeid3())){
            criteria.andEqualTo("jqtypeid3",spJjxx.getJqtypeid3());
        }
        //社区
        if (StringUtils.hasText(spJjxx.getCommunityCode())){
            criteria.andEqualTo("communityCode",spJjxx.getCommunityCode());
        }
        //案发地址
        if (StringUtils.hasText(spJjxx.getAfdd())){
            criteria.andLike("afdd", "%" + spJjxx.getAfdd() + "%");
        }
        //处警状态
        if (StringUtils.hasText(spJjxx.getStatus())){
            criteria.andEqualTo("status",spJjxx.getStatus());
        }
    }

    public List<SpJjxx> selectRecentSpJjxxList(SpJjxxReqParam spJjxx,Map<String,String> user) {

        Example example = new Example(SpJjxx.class);
        example.setOrderByClause("BJSJ DESC");
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        criteria.andEqualTo("orgCode", user.get("deptId"));
        if (StringUtils.hasText(spJjxx.getStatus())){
            if (JjptConstantCode.CASESTATUS_1001.equals(spJjxx.getStatus())) {
                // 未处理的警情显示所有的
                criteria.andCondition("STATUS = '" + JjptConstantCode.CASESTATUS_1001 + "'");
            }else {
                // 已处理的警情显示24小时内的
                criteria.andCondition("CJSJ >= sysdate-1");
                criteria.andCondition("STATUS > '" + JjptConstantCode.CASESTATUS_1001 + "'");
            }
        }
        return spJjxxMapper.selectByExample(example);
    }

    public int selectRecentSpJjxxCount(SpJjxxReqParam spJjxx,Map<String,String> user) {

        Example example = new Example(SpJjxx.class);
        example.setOrderByClause("BJSJ DESC");
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        criteria.andEqualTo("orgCode", user.get("deptId"));
        criteria.andCondition("BJSJ >= sysdate-1");

        return spJjxxMapper.selectCountByExample(example);
    }

    public Map<String, Integer> getBigscreenSpJjxxCount(Map<String,String> user) {
        Map<String,Integer> map = new HashMap<>();
        // 已处理：统计处警时间为24小时内
        Example example1 = new Example(SpJjxx.class);
        Example.Criteria criteria1 = example1.createCriteria();
        criteria1.andEqualTo("orgCode", user.get("deptId"));
        criteria1.andCondition("CJSJ >= sysdate-1");
//        int yclAll = spJjxxMapper.selectCountByExample(example1);
        criteria1.andCondition("STATUS > '" + JjptConstantCode.CASESTATUS_1001 + "'");
        int ycl = spJjxxMapper.selectCountByExample(example1);

        // 未处理：统计所有未处理数据
        Example example2 = new Example(SpJjxx.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("orgCode", user.get("deptId"));
//        int wclAll = spJjxxMapper.selectCountByExample(example2);
        criteria2.andCondition("STATUS = '" + JjptConstantCode.CASESTATUS_1001 + "'");
        int wcl = spJjxxMapper.selectCountByExample(example2);

//        // 预报警已闭环
//        int ybj = zzjbjBjxxService.getZzjbjBjxxCountByHandleStatus("handled",user.get("deptId"));
//        // 预报警未闭环
//        int ybjTotal = zzjbjBjxxService.getZzjbjBjxxCountByHandleStatus("unhandled",user.get("deptId"));

        map.put("ycl",ycl);
        map.put("wcl",wcl);
//        map.put("ybj",ybj);
//        map.put("ybjTotal",ybjTotal);

        return map;
    }

    public int doSpJjxxSave(SpJjxx spJjxx, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        spJjxx.setObjid(objid);
        Date date = new Date();
        spJjxx.setOrgCode(map.get("deptId"));
        spJjxx.setOrgName(map.get("deptName"));
        spJjxx.setCreateName(map.get("userName"));
        spJjxx.setCreateId(map.get("userId"));
        spJjxx.setCreateTime(date);
        spJjxx.setModerName(map.get("userName"));
        spJjxx.setModerId(map.get("userId"));
        spJjxx.setModerTime(date);
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
        if (sysDataOwnerDept != null) {
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                spJjxx.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                spJjxx.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                spJjxx.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                spJjxx.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                spJjxx.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
            }
            spJjxx.setOwnerType("1");
        }
        return spJjxxMapper.insertSelective(spJjxx);
    }

    public int spJjxxSave(SpJjxx spJjxx, Map<String,String> map){
//        String objid = UUID.randomUUID().toString();
//        spJjxx.setObjid(objid);
        Date date = new Date();
//        spJjxx.setOrgCode(map.get("deptId"));
//        spJjxx.setOrgName(map.get("deptName"));
//        spJjxx.setCreateName(map.get("userName"));
//        spJjxx.setCreateId(map.get("userId"));
//        spJjxx.setCreateTime(date);
//        spJjxx.setModerName(map.get("userName"));
//        spJjxx.setModerId(map.get("userId"));
//        spJjxx.setModerTime(date);
//        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
//        if (sysDataOwnerDept != null) {
//            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
//                spJjxx.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
//            }
//            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
//                spJjxx.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
//            }
//            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
//                spJjxx.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
//            }
//            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
//                spJjxx.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
//            }
//            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
//                spJjxx.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
//            }
//            spJjxx.setOwnerType("1");
//        }

        String jjdbh = this.generateJjdbh(map.get("deptId"));
        spJjxx.setJjdbh(jjdbh);
        spJjxx.setStatus(JjptConstantCode.CASESTATUS_1001);//添加后默认是接警状态
        spJjxx.setJjsj(date);
        spJjxx.setJjy(map.get("userName"));
        spJjxx.setJjyCode(map.get("userId"));
        spJjxx.setJjdw(map.get("deptId"));
        spJjxx.setJjdwmc(map.get("deptName"));
        if (!StringUtils.hasText(spJjxx.getBjdh())){
            spJjxx.setBjdh(spJjxx.getLxdh());
        }
        // 如果报警时间为空，则报警时间就是当前时间
        if (spJjxx.getBjsj()==null){
            spJjxx.setBjsj(date);
        }
        // 如果报警类型为空，则默认为现场接警
        if (!StringUtils.hasText(spJjxx.getReporterSource())){
            spJjxx.setReporterSource(JjptConstantCode.REPORT_SOURCE_1001);
        }
        if (StringUtils.hasText(spJjxx.getBjrzp())){
            // 长度小于100的是hadoop地址，如果不是，则说明是base64，需要先上传hadoop
            if (spJjxx.getBjrzp().length()>100){
                // 说明是base64，需要先传到hadoop上面
                String retStr = hadoopService.hadoopUpload(spJjxx.getBjrzp());
                spJjxx.setBjrzp(retStr);
            }
        }
        int num = this.doSpJjxxSave(spJjxx,map);
        if (num > 0){
            // 现场接警情况下才会触发消除微报警的警情
            if (JjptConstantCode.REPORT_SOURCE_1001.equals(spJjxx.getReporterSource())){
                BdHandlingArea bdHandlingArea = bdHandlingAreaService.getBdHandlingAreaByUser(map);
                if (bdHandlingArea!=null && JjptConstantCode.IF_WECHAT_ALARM_1.equals(bdHandlingArea.getIfWechatAlarm())){
                    // 修改预报警信息
                    zzjbjBjxxService.updateAcceptWechatAlarm(bdHandlingArea.getOrgCode(),spJjxx);
                    // 如果微信小程序上传的有材料，则将材料也上传至hadoop
                    if (StringUtils.hasText(spJjxx.getBjid())){
                        int fileNum = spFilesService.saveSpFileByWechatFileData(spJjxx,map);
                    }
                }
            }
            // 将所有此电话号码的电话预报警进行闭环
            if (JjptConstantCode.REPORT_SOURCE_1003.equals(spJjxx.getReporterSource())){
                spCallRecordService.updateAllRelatedSpCall(spJjxx,map);
            }
        }
        return num;
    }

//    // 报警编号生成规则：8位日期+4位单位编码+5位流水号，如20190810T00400012
//    public  String getJjdbh(String shortCode,String orgCode){
//        String jjdbh = "";
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
//        String time = sdf.format(new Date());
//        String today = time.substring(0, 8);
//        String maxCode = spAlarmMapper.selectCode(orgCode);
//        if(!StringUtils.hasText(maxCode)){
//            // 无最大值
////            jjdbh = orgCode.substring(0,6)+today+shortCode+"00001";
//            jjdbh = today+shortCode+"00001";
////        }else if(maxCode.substring(6, 14).equals(today)){
//        }else if(maxCode.substring(0,8).equals(today)){
//            // 当天该单位非第一个
////            int lsh = Integer.parseInt(maxCode.substring(18))+1;
//            int lsh = Integer.parseInt(maxCode.substring(12))+1;
//            String lshStr = lsh + "";
//            int lshStrLength = lshStr.length();
//            for(int i=0;i<5-lshStrLength;i++){
//                lshStr = "0" + lshStr;
//            }
////            jjdbh = maxCode.substring(0, 18)+lshStr;
//            jjdbh = maxCode.substring(0, 12)+lshStr;
//        }else{
//            // 当天该单位第一个
////            jjdbh = orgCode.substring(0,6)+today+shortCode+"00001";
//            jjdbh = today+shortCode+"00001";
//        }
//        return jjdbh;
//    }

    // 黄冈报警编号生成规则：单位编号+时间戳
    public  String generateJjdbh(String orgCode){
        return "JJ"+orgCode + new Date().getTime();
    }

    // 黄冈报警编号生成规则：单位编号+时间戳
    public  String generateCjdbh(String orgCode){
        return "CJ"+orgCode + new Date().getTime();
    }

    public String receiveAlarmAndSendPolice(SpJjxx spJjxxNew, Map<String, String> user) {
        SpJjxx spJjxx = spJjxxMapper.selectByPrimaryKey(spJjxxNew.getObjid());
        BeanUtils.copyProperties(spJjxxNew,spJjxx);

        Date curDate =  new Date();
        spJjxx.setModerName(user.get("userName"));
        spJjxx.setModerId(user.get("userId"));
        spJjxx.setModerTime(curDate);
        int num = 0;
        String msg = "";
        //派警后状态改成出警-1002
        spJjxx.setStatus(JjptConstantCode.CASESTATUS_1002);
        spJjxx.setSldw(user.get("deptId"));
        spJjxx.setSldwName(user.get("deptName"));
//        if(!StringUtils.hasText(spJjxx.getGxdw())){
            spJjxx.setGxdw(user.get("deptId"));
            spJjxx.setGxdwName(user.get("deptName"));
//        }
//        if (!StringUtils.hasText(spJjxx.getDdrCode())){
            spJjxx.setDdrCode(user.get("userId"));
            spJjxx.setDdrName(user.get("userName"));
//        }
        spJjxx.setCjsj(curDate);
        num = spJjxxMapper.updateByPrimaryKeySelective(spJjxx);
        //存储出警人信息
        int cjrNum = 0;
        int fkxxNum = 0;
        if(num>0){
            if (StringUtils.hasText(spJjxx.getCjrCode())){
                String[] cjrCodeArr = spJjxx.getCjrCode().split(",");
                for (int i=0;i<cjrCodeArr.length;i++){
                    SysUser sysUser = sysUserService.getSysUser(cjrCodeArr[i]);
                    if (sysUser != null){
                        SpCjrxx spCjrxx = new SpCjrxx();
//                        spCjrxx.setObjid(UUID.randomUUID().toString());
                        spCjrxx.setCjId(sysUser.getUserId());
                        spCjrxx.setCjCode(sysUser.getPoliceCode());
                        spCjrxx.setCjName(sysUser.getUserName());
                        spCjrxx.setAfdd(spJjxx.getAfdd());
                        spCjrxx.setJjdObjid(spJjxx.getObjid());
                        spCjrxx.setJjdbh(spJjxx.getObjid());
                        spCjrxx.setPjData(curDate);
                        spCjrxx.setLxdh(sysUser.getTel());
                        spCjrxx.setStatus(JjptConstantCode.CASESTATUS_1002);
//                        spCjrxx.setCreateName(user.get("userName"));
//                        spCjrxx.setCreateId(user.get("userId"));
//                        spCjrxx.setCreateTime(curDate);
//                        spCjrxx.setModerName(user.get("userName"));
//                        spCjrxx.setModerId(user.get("userId"));
//                        spCjrxx.setModerTime(curDate);
//                        spCjrxx.setOrgCode(user.get("deptId"));
//                        spCjrxx.setOrgName(user.get("deptName"));
//                        spCjrxx.setGaOwnerDept1(spJjxx.getGaOwnerDept1());
//                        spCjrxx.setGaOwnerDept2(spJjxx.getGaOwnerDept2());
//                        spCjrxx.setGaOwnerDept3(spJjxx.getGaOwnerDept3());
//                        spCjrxx.setGaOwnerDept4(spJjxx.getGaOwnerDept4());
//                        spCjrxx.setGaOwnerDept5(spJjxx.getGaOwnerDept5());
                        cjrNum = cjrNum + spCjrxxService.spCjrxxSave(spCjrxx,user);
                    }
                }
            }
            // 生成反馈表信息
            SpFkxx spFkxx = new SpFkxx();
//            String cjdObjid = UUID.randomUUID().toString();
//            spFkxx.setObjid(cjdObjid);
            spFkxx.setJjdbh(spJjxx.getJjdbh());
            String cjdbh = this.generateCjdbh(user.get("deptId"));
            spFkxx.setCjdbh(cjdbh);
            spFkxx.setJjdObjid(spJjxx.getObjid());
            spFkxx.setStatus(spJjxx.getStatus());
            spFkxx.setCjsj(spJjxx.getCjsj());
            spFkxx.setCjrbm(spJjxx.getCjrCode());
            spFkxx.setCjrxm(spJjxx.getCjrName());
            spFkxx.setXqdm(spJjxx.getCommunityCode());
            spFkxx.setXqmc(spJjxx.getCommunityName());
            spFkxx.setReporterSource(spJjxx.getReporterSource());
//            spFkxx.setCreateName(user.get("userName"));
//            spFkxx.setCreateId(user.get("userId"));
//            spFkxx.setCreateTime(curDate);
//            spFkxx.setModerName(user.get("userName"));
//            spFkxx.setModerId(user.get("userId"));
//            spFkxx.setModerTime(curDate);
//            spFkxx.setOrgCode(spJjxx.getOrgCode());
//            spFkxx.setOrgName(spJjxx.getOrgName());
//            spFkxx.setGaOwnerDept1(spJjxx.getGaOwnerDept1());
//            spFkxx.setGaOwnerDept2(spJjxx.getGaOwnerDept2());
//            spFkxx.setGaOwnerDept3(spJjxx.getGaOwnerDept3());
//            spFkxx.setGaOwnerDept4(spJjxx.getGaOwnerDept4());
//            spFkxx.setGaOwnerDept5(spJjxx.getGaOwnerDept5());
            fkxxNum = spFkxxService.spFkxxSave(spFkxx,user);
            // 更新接警表的处警但信息
            spJjxx.setCjdbh(cjdbh);
            spJjxx.setCjdObjid(spFkxx.getObjid());
            spJjxxMapper.updateByPrimaryKeySelective(spJjxx);
        }
        if (num>0 && cjrNum>0 && fkxxNum>0) {
            // 操作成功
            msg = "666";
        }else if (num>0 && fkxxNum==0){
            msg = "反馈表信息添加失败";
        }else if (num>0 && cjrNum==0){
            msg = "出警人信息添加失败";
        }else if (num==0){
            msg = "派警信息更新失败";
        }else {
            msg = "操作失败";
        }
        return msg;
    }

    public int spJjxxUpdate(SpJjxx spJjxx, Map<String,String> map){
        spJjxx.setModerName(map.get("userName"));
        spJjxx.setModerId(map.get("userId"));
        spJjxx.setModerTime(new Date());
        int num = spJjxxMapper.updateByPrimaryKeySelective(spJjxx);
        return num;
    }


    public int updateSpJjxx(SpJjxx spJjxx, Map<String,String> map){
        // 以应对电话接警选择稍后处理后，报警人来到现场，并使用了人证比对提交了报警人照片的情况
        if (StringUtils.hasText(spJjxx.getBjrzp())&&spJjxx.getBjrzp().length()>100){
            // 长度小于100的是hadoop地址，如果不是，则说明是base64，需要先上传hadoop
            String retStr = hadoopService.hadoopUpload(spJjxx.getBjrzp());
            spJjxx.setBjrzp(retStr);
        }
        int num = spJjxxUpdate(spJjxx,map);
        return num;
    }

    public SpJjxx getSpJjxx(String objid){
        if (StringUtils.hasText(objid)){
            return spJjxxMapper.selectByPrimaryKey(objid);
        }
        return null;
    }

    public int spJjxxDelete(String objid){
        int num = 0;
        num = spJjxxMapper.deleteByPrimaryKey(objid);
        return num;
    }

    @Override
    public List<SpJjxx> spJjxxByCjrCode(String objid, String status) {
        List<SpJjxx> spJjxxs = new ArrayList<>();
        Example example = new Example(SpJjxx.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("CJSJ DESC");
        //状态
        if (StringUtils.hasText(status)){
            if("1004/1005".indexOf(status)!=-1){//1004反馈 1005补充反馈
                //查询已完成的
                List<String> list = Arrays.asList(status.split("/"));
                List<String> newlist = new ArrayList<String>(list);
                criteria.andIn("status",newlist);
                // 已处理的警情显示24小时内的
                criteria.andCondition("FKSJ >= sysdate-1");
            }else if("1002/1003".indexOf(status)!=-1)
            {
                //查询代办的
                List<String> list = Arrays.asList(status.split("/"));
                List<String> newlist = new ArrayList<String>(list);
                criteria.andIn("status",newlist);
            }else{//都不满足直接返回空
                return spJjxxs;
            }

        }
        //报警人id
        if (StringUtils.hasText(objid)){
            criteria.andLike("cjrCode","%" + objid + "%");
        }
        spJjxxs = spJjxxMapper.selectByExample(example);

        return spJjxxs;
    }

    @Override
    public SpJjxx getSpJjxxData(SpJjxx spJjxx) {
        return spJjxxMapper.selectOne(spJjxx);
    }

    public int spJjxxSave(SpJjxx spJjxx){
        return spJjxxMapper.insertSelective(spJjxx);
    }

}
