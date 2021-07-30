package pkubatis.common.utils;

public class CodeUtils {
    /**
     * 截取前四位
     */
    public static String getBegin4Character(String code) {
        return code.substring(0, 4);
    }

    /**
     * 截取后四位
     */
    public static String getLast4Character(String code) {
        int length = code.length();
        return code.substring(length - 4, length);
    }

    /**
     * 截取警种
     */
    public static String getPoliceClassifyCode(String code) {
        String back4Character = getLast4Character(code);
        return back4Character.substring(0, 2);
    }

    /**
     * 获取最后两位
     */
    public static String getLast2Character(String code) {
        int length = code.length();
        return code.substring(length - 2, length);
    }
}
