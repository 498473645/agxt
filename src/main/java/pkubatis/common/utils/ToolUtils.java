package pkubatis.common.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类方法
 *
 * @author liuc
 * @date 2019/06/14
 *
 */
public class ToolUtils {
    private static Pattern pattern = Pattern.compile("[0-9]*");
    private static Pattern patternZh = Pattern.compile("[\u4e00-\u9fa5]");
    /**
     * 判断是否为数字
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isNumber(String str) {
        return pattern.matcher(str).matches();
    }
    /**
     * 判断字符串中是否包含中文
     * @param str
     * 待校验字符串
     * @return 是否为中文
     * @warn 不能校验是否为中文标点符号
     */
    public static boolean isContainChinese(String str) {
        Matcher m = patternZh.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
