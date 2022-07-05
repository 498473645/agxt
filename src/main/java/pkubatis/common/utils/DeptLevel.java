package pkubatis.common.utils;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DeptLevel {

//    public static void main(String[] args) {
//        String deptLevel = "";
//        String deptid = "421252560000";
//        if ("0000000000".equals(deptid.substring(deptid.length()-10))){
//            deptLevel="1";
//        }else if("00000000".equals(deptid.substring(deptid.length()-8))){
//            deptLevel="2";
//        }else if("000000".equals(deptid.substring(deptid.length()-6))){
//            deptLevel="3";
//        }else if("0000".equals(deptid.substring(deptid.length()-4))){
//            deptLevel="4";
//        }else{
//            deptLevel="5";
//        }
//        System.out.println(deptLevel);
//    }

    /**
     * 字符转日期
     *
     * @param deptId
     * @return
     */
    public static String getDeptLevel(String deptId) {
        if(!StringUtils.hasText(deptId)){
            return null;
        }
        String deptLevel = "";
        if ("0000000000".equals(deptId.substring(deptId.length()-10))){
            deptLevel="1";
        }else if("00000000".equals(deptId.substring(deptId.length()-8))){
            deptLevel="2";
        }else if("000000".equals(deptId.substring(deptId.length()-6))){
            deptLevel="3";
        }else if("0000".equals(deptId.substring(deptId.length()-4))){
            deptLevel="4";
        }else{
            deptLevel="5";
        }
        return deptLevel;
    }
}
