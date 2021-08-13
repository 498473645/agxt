package com.pkusoft.jjpt.service;

import com.pkusoft.jjpt.po.SpFiles;
import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.req.SpFilesReqParam;

import java.util.List;
import java.util.Map;


public interface SpFilesService {

    /**
    * 查询业务数据_材料信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<SpFiles> getSpFilesList(SpFilesReqParam spFiles,Map<String, String> map);

    /**
     * 根据预报警信息查询接警平台材料
     * @param spFiles
     * @param map
     * @return
     */
    List<SpFiles> getSpFilesListByYbj(SpFilesReqParam spFiles,Map<String, String> map);

    /**
     * 根据
     * @param spFiles
     * @return
     */
    List<SpFiles> getFileListByAobjidAndObjtype(SpFiles spFiles);

    /**
    * 查询业务数据_材料信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getSpFilesCount(SpFilesReqParam spFiles,Map<String, String> map);

    /**
    * 新增业务数据_材料信息表
    * @param spFiles	业务数据_材料信息表
    * @param map	用户集合
    * @return
    */
    int spFilesSave(SpFiles spFiles, Map<String,String> map);

    /**
     * 新增业务数据_材料信息表(阳光警务专用)
     * @param spFiles	业务数据_材料信息表
     * @return
     */
    int spFilesSaveYGJW(SpFiles spFiles);

    /**
     * 微信端单个材料上传
     * @param spFiles
     * @return
     */
    int spFilesSaveFromWechat(SpFilesReqParam spFiles);

    /**
     * 基础保存
     * @param spFiles
     * @param map
     * @return
     */
    int doSpFilesSave(SpFiles spFiles, Map<String,String> map);

    /**
    * 修改业务数据_材料信息表
    * @param spFiles	业务数据_材料信息表
    * @param map	用户集合
    * @return
    */
    int spFilesUpdate(SpFiles spFiles, Map<String,String> map);

    /**
     * 保存微信端的报案材料
     * @return
     */
    int saveSpFileByWechatFileData(SpJjxx spJjxx, Map<String, String> user);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    SpFiles getSpFiles(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int spFilesDelete(String objid);

    /**
     * 根据案件id和文件类型查询附件信息
     * @param
     * @return
     */
    List<SpFiles> selectPicByCase(String jjdObjid,String objtype);

    /**
     * 根据
     * @param spFiles
     * @return
     */
    List<SpFiles> getFileListByTransIdAndObjtype(SpFiles spFiles);
}
