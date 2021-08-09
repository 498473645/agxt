package com.pkusoft.usercenter.service.impl;
import com.pkusoft.jjpt.po.SpAlarmType;
import com.pkusoft.lesp.po.StatisticsData;
import com.pkusoft.usercenter.mapper.SysDeptMapper;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.usercenter.service.SysDeptService;
import com.pkusoft.usercenter.service.SysPermitService;
import com.pkusoft.usercenter.vo.DeptTree;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
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

	/**
	 * 查询单位树形结构数据
	 *
	 * @return
	 */
	@Override
	public List<DeptTree> getSysDeptTreeList(String deptId,String deptLevel,List<StatisticsData> curData) {
//		Map<String,String> retData = sysPermitService.setUserDataPermits(map, PermitType.PERMIT_TYPE_CASE_QUERY);
//		String deptLevel = retData.get("level");
//		String deptId = retData.get("deptId");
		if (!StringUtils.hasText(deptLevel) || !StringUtils.hasText(deptId)){
			return new ArrayList<DeptTree>();
		}
		List<DeptTree> deptTreeList = sysDeptMapper.getSysDeptList(deptLevel,deptId);
		// 最后的结果
		List<DeptTree> resultList = new ArrayList<DeptTree>();
		// 先找父节点
		for (int i = 0; i < deptTreeList.size(); i++) {
			// 市局单位的deptLevel是 2
			if (deptTreeList.get(i).getDeptLevel().equals(deptLevel)) {
				for(StatisticsData statisticsData : curData) {
					if (statisticsData.getData15().equals(deptTreeList.get(i).getDeptId())) {
						deptTreeList.get(i).setStatisticsData(statisticsData);
					}
				}
				resultList.add(deptTreeList.get(i));
			}else if ("8".equals(deptLevel)) {
				// 查本单位
				resultList.add(deptTreeList.get(i));
			}
		}
		// 为父节点设置子节点，getChild是递归调用的
		for (DeptTree tree : resultList) {
			tree.setChildren(getChildren(tree.getDeptId(), deptTreeList, curData));
		}
		return resultList;
	}

	/**
	 * 递归遍历
	 * @param deptId
	 * @param deptTreeList
	 * @return
	 */
	private List<DeptTree> getChildren(String deptId, List<DeptTree> deptTreeList,List<StatisticsData> curData) {
		// 子节点
		List<DeptTree> childList = new ArrayList<>();
		for (DeptTree tree : deptTreeList) {
			// 遍历所有节点，将父节点id与传过来的id比较
			if (tree.getParentDeptId().equals(deptId)) {
				for(StatisticsData statisticsData : curData) {
					if (statisticsData.getData15().equals(tree.getDeptId())) {
						tree.setStatisticsData(statisticsData);
					}
				}
				childList.add(tree);
			}
		}
		// 循环查询子节点的下级单位
		for (DeptTree tree : childList) {
			tree.setChildren(getChildren(tree.getDeptId(), deptTreeList, curData));
		} // 递归退出条件
		if (childList.size() == 0) {
			return null;
		}
		return childList;
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
	public String getDeptIdBypermit(Map<String, String> user, String permitValue) {
		List<SysDept> deptList = new ArrayList<SysDept>();
		String deptId = "";
		//1.根据登录人及权限等级查询权限部门id,根据用户所属部门查询数据归属单位表
		SysDataOwnerDept owner = sysDataOwnerDeptService.selectByDeptId(user.get("deptId"));
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
				deptId = user.get("deptId") ;
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


}
