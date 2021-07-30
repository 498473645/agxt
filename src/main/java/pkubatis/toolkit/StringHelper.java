package pkubatis.toolkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper extends org.springframework.util.StringUtils{

    /**
     * 下划线转驼峰
     *
     * @param s
     * @return
     */
    public static String toCamelCase(String s) {
        Pattern p = Pattern.compile("_[a-z]{1}");
        if (s == null || s.equals("")) {
            return "";
        }
        s = s.toLowerCase();
        Matcher mc = p.matcher(s);
        while (mc.find()) {
            s = s.replace(mc.group(), mc.group().replace("_", "").toUpperCase());
        }
        return s;
    }

	/**
	 * 驼峰转下划线
	 * @param args
	 * @return 转换后的字符串
	 */
	public static String toUnderline(String args) {
	    return toUnderline(args,true);

	}

	public static String toUnderline(String args,boolean flag){
        Pattern p = Pattern.compile("[A-Z]");
        if (args == null || args.equals("")) {
            return "";
        }
        StringBuilder builder = new StringBuilder(args);
        Matcher mc = p.matcher(args);
        int i = 0;
        while (mc.find()) {
            builder.replace(mc.start() + i, mc.end() + i, "_"+ mc.group().toLowerCase());
            i++;
        }

        if ('_' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        String ret = builder.toString();
        return flag?ret.toUpperCase():ret;
    }

	public static void main(String[] args) {
		System.out.println(toUnderline("sysUser"));
	}
}
