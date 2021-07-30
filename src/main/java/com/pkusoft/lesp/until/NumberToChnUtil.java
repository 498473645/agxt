package com.pkusoft.lesp.until;

public class NumberToChnUtil {

    public static String numberToChinese(int number) {
        String[] numbers = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] units = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十"};
        String sign = number < 0 ? "负" : "";
        if (number < 0) {
            number = -number;
        }
        StringBuilder result = new StringBuilder(sign);
        String string = String.valueOf(number);
        int n = string.length();
        char[] numberCharArray = string.toCharArray();
        for (int i = 0; i < n; i++) {
            int digNum = n - i; // 位数
            int num = numberCharArray[i] - '0';
            if (num != 0) {
                result.append(numbers[num]).append(units[digNum - 1]);
                continue;
            }

            if (result.toString().endsWith(numbers[0])) {
                // 如果是单位所在的位数，则去除上一个0，加上单位
                if (digNum % 4 == 1) {
                    result.deleteCharAt(result.length() - 1);
                    result.append(units[digNum - 1]);
                }
            } else {
                result.append(numbers[0]);
            }
        }
        return result.toString();
    }

}
