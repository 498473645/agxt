package com.pkusoft.jjpt.service;


public interface HadoopService {

    /**
     * 用于上传身份证照片
     * @param base64Str
     * @return
     */
    String hadoopUpload(String base64Str);

    /**
     * 调用upload接口的hadoop通用模式上传
     * @param base64Str
     * @return
     */
    String hadoopFileUpload(String base64Str);
}
