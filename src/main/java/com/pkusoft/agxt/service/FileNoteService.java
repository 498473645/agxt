package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FileNote;

/**
* @author
* @title: FileNoteService
*/
public interface FileNoteService {

    /**
    * 查询案卷页备注信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<FileNote> getFileNoteList(Map<String, String> map);

    /**
    * 查询案卷页备注信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getFileNoteCount(Map<String, String> map);

    /**
    * 新增案卷页备注信息表
    * @param fileNote	案卷页备注信息表
    * @param map	用户集合
    * @return
    */
    int fileNoteSave(FileNote fileNote, Map<String,String> map);

    /**
    * 修改案卷页备注信息表
    * @param fileNote	案卷页备注信息表
    * @param map	用户集合
    * @return
    */
    int fileNoteUpdate(FileNote fileNote, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    FileNote getFileNote(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int fileNoteDelete(String id);

    int deleteJobFileNoteByAjbh(String ajbh);
}
