package com.pkusoft.agxt.service.impl;

import com.pkusoft.agxt.mapper.FileTempMapper;
import com.pkusoft.agxt.model.FileTemp;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.agxt.service.FileTempService;
import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysDeptService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FileTempServiceImpl implements FileTempService {

    @Autowired
    private FileTempMapper fileTempMapper;

    @Autowired
    private SysDeptService sysDeptService;

    public List<FileTemp> getFileTempList(FileTempParam fileTempParam, SysUser sysUser) {

        RowBounds rowBounds = new RowBounds(fileTempParam.getStart(),fileTempParam.getPageSize());
        Example example = new Example(FileTemp.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions(criteria,fileTempParam, sysUser);
        return fileTempMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileTempCount(FileTempParam fileTempParam, SysUser sysUser) {

        Example example = new Example(FileTemp.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions(criteria,fileTempParam, sysUser);
        return fileTempMapper.selectCountByExample(example);
    }

    private void setConditions(Example.Criteria criteria, FileTempParam fileTempParam, SysUser user) {
        criteria.andEqualTo("parentId", "00000000-0000-0000-0000-000000000000");
        criteria.andEqualTo("isPublic", "1");
    }

    public int fileTempSave(FileTemp fileTemp, SysUser sysUser){

        SysDept sysDept = sysDeptService.getSysDept(sysUser.getDeptId());

        String uuid = UUID.randomUUID().toString();
        fileTemp.setId(uuid);
        fileTemp.setCode(uuid);
        fileTemp.setParentId("00000000-0000-0000-0000-000000000000");
        Double sn = maxSn();
        fileTemp.setSn(Double.valueOf(++sn));
        fileTemp.setLev(1);
        fileTemp.setIsRequired(1);
        fileTemp.setTreePath("/" + uuid + "/");
        fileTemp.setDiskPath("/");
        fileTemp.setIcon("");
        fileTemp.setStatus("");
        fileTemp.setCreaterId(sysUser.getIdcard());
        fileTemp.setCreaterName(sysUser.getUserName());
        fileTemp.setCreateTime(new Date());
        fileTemp.setModerId(sysUser.getIdcard());
        fileTemp.setModerName(sysUser.getUserName());
        fileTemp.setModTime(new Date());
        fileTemp.setOrgC(sysDept.getCunitid());
        fileTemp.setOrgS(sysDept.getSunitid());
        fileTemp.setOrgT(sysDept.getTunitid());
        fileTemp.setOrgCData(sysDept.getDataCunitid());
        fileTemp.setOrgSData(sysDept.getDataSunitid());
        fileTemp.setOrgTData(sysDept.getDataTunitid());
        fileTemp.setCurOrgData(fileTemp.getCurOrg());
        fileTemp.setOrgCode(fileTemp.getCurOrg());

        SysDept sysDept1 = new SysDept();
        sysDept1.setDeptId(fileTemp.getCurOrg());
        if (fileTemp.getCurOrg() !=null) {
            List<SysDept> list = sysDeptService.selectSysDeptList(sysDept1);
            if (list != null && list.size() > 0) {
                fileTemp.setOrgName(list.get(0).getDeptName());
            }
        }
        int num = fileTempMapper.insertSelective(fileTemp);
        return num;
    }

    public int fileTempUpdate(FileTemp fileTemp, SysUser sysUser){
        fileTemp.setModerName(sysUser.getUserName());
        fileTemp.setModerId(sysUser.getUserId());
        fileTemp.setModTime(new Date());
        int num = fileTempMapper.updateByPrimaryKeySelective(fileTemp);
        return num;
    }

    public FileTemp getFileTemp(String id){
        return fileTempMapper.selectByPrimaryKey(id);
    }

    public int fileTempDelete(String id, SysUser sysUser){
        int num = fileTempMapper.deleteByPrimaryKey(id);
        return num;
    }

    /**
     * 最大排序号
     *
     * @return 排序号 sn
     */
    private Double maxSn() {
        Example example = new Example(FileTemp.class);
        example.setOrderByClause("SN desc");
        Double sn = 1.00;
        List<FileTemp> list = fileTempMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            FileTemp fileTemp = fileTempMapper.selectByExample(example).get(0);
            sn = fileTemp.getSn();
        }
        return sn;
    }
}
