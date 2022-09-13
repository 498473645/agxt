package com.pkusoft.usercenter.service.impl;
import com.pkusoft.usercenter.mapper.SysDeptMapper;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.usercenter.service.SysDeptService;
import com.pkusoft.usercenter.service.SysPermitService;
import com.pkusoft.usercenter.vo.DeptTree;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.DeptLevel;
import pkubatis.common.utils.OrgData;
import pkubatis.common.utils.PermitType;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
@Transactional
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

	@Autowired
	private SysDataOwnerDeptService sysDataOwnerDeptService;

	@Autowired
	private SysPermitService sysPermitService;

    public List<SysDept> getSysDeptList(Map<String, String> map) {

    	RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(SysDept.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return sysDeptMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSysDeptCount(Map<String, String> map) {

        Example example = new Example(SysDept.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return sysDeptMapper.selectCountByExample(example);
    }

    public int sysDeptSave(SysDept sysDept, Map<String,String> map){
        String deptId = UUID.randomUUID().toString();
        sysDept.setDeptId(deptId);
        sysDept.setModifyUserName(map.get("userName"));
//        sysDept.setModifyUserId(map.get("userId"));
        sysDept.setModifyTime(new Date());
        int num = sysDeptMapper.insertSelective(sysDept);
        return num;
    }

    public int sysDeptUpdate(SysDept sysDept, Map<String,String> map){
        sysDept.setModifyUserName(map.get("userName"));
//        sysDept.setModifyUserId(map.get("userId"));
        sysDept.setModifyTime(new Date());
        int num = sysDeptMapper.updateByPrimaryKeySelective(sysDept);
        return num;
    }

    public SysDept getSysDept(String deptId){
        return sysDeptMapper.selectByPrimaryKey(deptId);
    }

    public int sysDeptDelete(String[] deptId){
        int num = 0;
        for(int i = 0; i < deptId.length; i ++){
        num = sysDeptMapper.deleteByPrimaryKey(deptId[i]);
        }
        return num;
    }

	@Override
	public List<SysDept> selectSysDeptListByExample(Example example) {
		return sysDeptMapper.selectByExample(example);
	}

	@Override
	public List<SysDept> selectSysDeptListByMap(Map<String, Object> params) {
		return sysDeptMapper.getReleDeptListByParent(params);
	}

	@Override
	public List<SysDept> selectSysDeptList(SysDept sysDept) {
		return sysDeptMapper.select(sysDept);
	}

	@Override
	public String getDeptIdBypermit(SysUser user, String permitValue) {
		List<SysDept> deptList = new ArrayList<SysDept>();
		String deptId = "";
		//1.根据登录人及权限等级查询权限部门id,根据用户所属部门查询数据归属单位表
		SysDataOwnerDept owner = sysDataOwnerDeptService.selectByDeptId(user.getDeptId());
		//循环判断对应权限所属部门
		switch (permitValue){
			//省级单位数据查询权限
			case PermitType.PERMIT_VALUE_DEPT_1:
				deptId = owner.getOwnerDept1();
				break;
			//市局单位数据查询权限
			case PermitType.PERMIT_VALUE_DEPT_2:
				deptId = owner.getOwnerDept2();
				break;
			//分局单位数据查询权限
			case PermitType.PERMIT_VALUE_DEPT_3:
				deptId = owner.getOwnerDept3();
				break;
			//派出所数据查询权限
			case PermitType.PERMIT_VALUE_DEPT_4:
				deptId = owner.getOwnerDept4();
				break;
			//所属办案区数据查询权限及本人数据查询权限
			default:
				//根据登录人警号查询警员表的所属单位id
				deptId = user.getDeptId() ;
				break;
		}
		return deptId;
	}

	@Override
	public List<SysDept> selectSysDeptList(String permitDeptId) {
		List<SysDept> deptList = new ArrayList<SysDept>();
		//2.根据权限部门id及权限等级查询单位
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("deptId",permitDeptId);
		deptList = sysDeptMapper.getReleDeptListByParent(map);
		return deptList;
	}

	@Override
	public List<SysDept> getAllSysDeptList(){
		Example example = new Example(SysDept.class);
		Example.Criteria criteria = example.createCriteria();
		example.setOrderByClause("dept_id");
		List<SysDept> deptList = sysDeptMapper.selectByExample(example);
		return deptList;
	}
	@Override
	public List<SysDept> getDeptListByOwnerDept(SysDept dept) {
		Example example = new Example(SysDept.class);
		Example.Criteria criteria = example.createCriteria();
		if(StringUtils.hasText(dept.getDeptId())){
			criteria.andEqualTo("deptId",dept.getDeptId());
		}
		if(StringUtils.hasText(dept.getParentDeptId())){
			criteria.andEqualTo("parentDeptId",dept.getParentDeptId());
		}
		List<SysDept> deptList = sysDeptMapper.selectByExample(example);
		return deptList;
	}
	@Override
	public List<SysDept> getDeptList(Map<String, String> user,String deptLevel){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("parentDeptId",user.get("deptId"));
		params.put("deptLevel",deptLevel);
		List<SysDept> deptList = sysDeptMapper.queryDeptList(params);
		return deptList;
	}

	/**
	 * 获取下级归属单位信息和当前单位信息
	 * @param deptId
	 * @return
	 */
	@Override
	public List<SysDept> getParentDeptId(String deptId){
		return sysDeptMapper.getParentDeptId(deptId);
	}

	/**
	 * 获取下级归属单位信息
	 * @param deptId
	 * @return
	 */
	@Override
	public List<SysDept> getOnlyParentDeptId(String deptId){
		return sysDeptMapper.getOnlyParentDeptId(deptId);
	}

	@Override
	public List<SysDept> sysDeptDicByDeptLevel(String deptId) {
		String deptLevel= DeptLevel.getDeptLevel(deptId);
		Example example = new Example(SysDept.class);
		example.setOrderByClause("DEPT_ID asc");
		Example.Criteria criteria = example.createCriteria();
		if ("2".equals(deptLevel)){
			criteria.andEqualTo("cunitid",deptId);
		}else if ("3".equals(deptLevel)){
			criteria.andEqualTo("sunitid",deptId);
		}else if ("4".equals(deptLevel)){
			criteria.andEqualTo("tunitid",deptId);
		}
		List<SysDept> deptList = sysDeptMapper.selectByExample(example);
		return deptList;
	}


}
