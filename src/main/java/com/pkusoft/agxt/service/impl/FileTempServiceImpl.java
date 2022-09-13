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
import org.springframework.util.StringUtils;
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
        if(StringUtils.hasText(fileTempParam.getName())){
            criteria.andLike("name", '%' + fileTempParam.getName() + '%');
        }
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

    public int fileTempDelete(String[] ids){
        int num = 0;
        for (int i = 0; i < ids.length; i++) {
            num = fileTempMapper.deleteByPrimaryKey(ids[i]);
        }
        return num;
    }

    @Override
    public List<FileTemp> getFileTempTreeList(FileTempParam fileTempParam, SysUser user) {
        Example example = new Example(FileTemp.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        criteria.andNotEqualTo("parentId", "00000000-0000-0000-0000-000000000000");
        if(StringUtils.hasText(fileTempParam.getParentId())){
            criteria.andLike("treePath", '%' + fileTempParam.getParentId() + '%');
        }
        if(fileTempParam.getLev()!=null){
            criteria.andLike("lev", String.valueOf(fileTempParam.getLev()));
        }
        example.setOrderByClause("lev,sn");
        return fileTempMapper.selectByExample(example);
    }

    public int insertFileTempTree(FileTemp jobFileTemp,SysUser sysUser) {
        String uuid = UUID.randomUUID().toString();
        Double sn = maxSn();
        if (StringUtils.hasText(jobFileTemp.getId())) { // 根据的树节点编号查询得到父树节点信息
            FileTemp jobFile = fileTempMapper.selectByPrimaryKey(jobFileTemp.getId());
            jobFileTemp.setParentId(jobFile.getId());
            jobFileTemp.setLev(jobFile.getLev() + 1);
            jobFileTemp.setTreePath(jobFile.getTreePath() + uuid + "/");
            jobFileTemp.setDiskPath(jobFile.getDiskPath() + uuid + "/");
            jobFileTemp.setType(jobFile.getType());
            jobFileTemp.setMetalType(jobFile.getMetalType());
            jobFileTemp.setIcon(jobFile.getIcon());
        } else {// 默认添加的树级别为2级,并且为根节点
            FileTemp jobFile = fileTempMapper.selectByPrimaryKey(jobFileTemp.getParentId());
            Integer treeLevel = 2;
            jobFileTemp.setLev(treeLevel);
            jobFileTemp.setTreePath(jobFile.getTreePath() + uuid + "/");
            jobFileTemp.setDiskPath("/" + uuid + "/");
            jobFileTemp.setType(jobFile.getType());
        }

        // 生成的菜单标识号
        jobFileTemp.setId(uuid);
        jobFileTemp.setCode(uuid);

        // 排序--随单位标识号从小到大排列,可以直接将MenuId赋值给orderFlag
        jobFileTemp.setSn(Double.valueOf(++sn));

        // 录入用户信息
        jobFileTemp.setCreaterId(sysUser.getIdcard());
        jobFileTemp.setCreaterName(sysUser.getUserName());
        jobFileTemp.setCreateTime(new Date());
        jobFileTemp.setModerId(sysUser.getIdcard());
        jobFileTemp.setModerName(sysUser.getUserName());
        jobFileTemp.setModTime(new Date());

        return fileTempMapper.insertSelective(jobFileTemp);
    }

    @Transactional
    public int newJobFileTempDel(String id) {
        fileTempDel(id);
        int num = fileTempMapper.deleteByPrimaryKey(id);
        return num;
    }

    private void fileTempDel(String parentId) {
        FileTemp fileTemp = new FileTemp();
        fileTemp.setParentId(parentId);
        List<FileTemp> list = fileTempMapper.select(fileTemp);
        if (list.size() > 0) {
            for (FileTemp jobFileTemp : list) {
                fileTempDel(jobFileTemp.getId());
                fileTempMapper.delete(jobFileTemp);
            }
        }
    }

    /**
     * 最大排序号
     *
     * @return 排序号 sn
     */
    private Double maxSn() {
        Integer sn = fileTempMapper.getMaxSN();
        return Double.valueOf(sn);
    }
}
