package pkubatis.common.utils;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理类
 * @author
 * @date 2019/06/16
 * Created by Think on 2019/06/14.
 */
public class DateUtils {

    public static final String YEAR_MONTH_DAY = "yyyyMMdd";
    public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_SIMPLE = "yyyyMMddHHmmss";

    /**
     * 字符转日期
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Date parse(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 日期转换
     * yyyy-MM-dd转yyyyMMdd
     *
     * @param strDate
     * @return
     */
    public static String strDateFormatOne(String strDate) {
        String retDate = "";
        strDate = strDate.replaceAll("-","");
        if(strDate.length()==8){
            retDate = strDate;
        }else{
            retDate = strDate.substring(0,8);
        }
        return retDate;
    }

    /**
     * 计算n天后的日期
     * @param days
     * @return
     */
    public static String getEndDateByDay(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        String newDate = new SimpleDateFormat("yyyyMMdd")
                .format(new Date(calendar.getTimeInMillis()));
        return newDate;
    }
    /**
     * 日期转换
     * yyyyMMdd转yyyy-MM-dd
     * yyyyMMddHHmm转yyyy-MM-dd HH:mm
     * yyyyMMddHHmmss转yyyy-MM-dd HH:mm:ss
     * @param strDate
     * @param length
     * @return
     */
    public static String strDateFormatSperation(String strDate,Integer length){
        String retDate = "";
        if (null == length){
            retDate = formateDateWithoutLen(strDate);
        }else {
            if (StringUtil.isNotEmpty(strDate) && strDate.trim().length()>=length){
                if (length==8){
                    retDate = formateYMD(strDate);
                }else if(length==12){
                    retDate = formateYMDHM(strDate);
                }
            }else {
                retDate = formateDateWithoutLen(strDate);
            }
        }
        return retDate;
    }

    /**
     * 日期格式转换（不指定转换长度len）
     * @param strDate
     * @return
     */
    public static String formateDateWithoutLen(String strDate){
        if (StringUtil.isNotEmpty(strDate) && strDate.trim().length()==8){
            return formateYMD(strDate);
        }else if (StringUtil.isNotEmpty(strDate) && strDate.trim().length()==12){
            return formateYMDHM(strDate);
        }else if (StringUtil.isNotEmpty(strDate) && strDate.trim().length()==14){
            return formateYMDHMS(strDate);
        }else {
            return strDate;
        }
    }

    //格式：年-月-日(yyyy-MM-dd)
    public static String formateYMD(String strDate){
        return strDate.substring(0, 4) + '-' + strDate.substring(4, 6) + '-' + strDate.substring(6, 8);
    }
    //格式：年-月-日 小时:分钟(yyyy-MM-dd HH:mm)
    public static String formateYMDHM(String strDate){
        return strDate.substring(0, 4) + '-' + strDate.substring(4, 6) + '-' + strDate.substring(6, 8) + ' ' + strDate.substring(8, 10) + ':' + strDate.substring(10, 12);
    }
    //格式：年-月-日 小时:分钟(yyyy-MM-dd HH:mm)
    public static String formateYMDHMS (String strDate){
        return strDate.substring(0, 4) + '-' + strDate.substring(4, 6) + '-' + strDate.substring(6, 8) + ' ' + strDate.substring(8, 10) + ':' + strDate.substring(10, 12)+ ':' + strDate.substring(12, 14);
    }

    public static int getAgeByBirthday(String birthday){
        try {
        //Calendar：日历
        /*从Calendar对象中或得一个Date对象*/
        Calendar cal = Calendar.getInstance();
        /*把出生日期放入Calendar类型的bir对象中，进行Calendar和Date类型进行转换*/
        Calendar bir = Calendar.getInstance();
        //将dd-MM-yyyy转为yyyy-MM-dd
        birthday = DataFormat(birthday);
        Date birth = parse(birthday,"yyyy-MM-dd");
        bir.setTime(birth);
        /*如果生日大于当前日期，则抛出异常：出生日期不能大于当前日期*/
        if(cal.before(birthday)){
            throw new IllegalArgumentException("The birthday is before Now,It's unbelievable");
        }
        /*取出当前年月日*/
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayNow = cal.get(Calendar.DAY_OF_MONTH);
        /*取出出生年月日*/
        int yearBirth = bir.get(Calendar.YEAR);
        int monthBirth = bir.get(Calendar.MONTH);
        int dayBirth = bir.get(Calendar.DAY_OF_MONTH);
        /*大概年龄是当前年减去出生年*/
        int age = yearNow - yearBirth;
        /*如果出当前月小与出生月，或者当前月等于出生月但是当前日小于出生日，那么年龄age就减一岁*/
        if(monthNow < monthBirth || (monthNow == monthBirth && dayNow < dayBirth)){
            age--;
        }
        return age;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public final static String DataFormat(String dateString)
            throws Exception {
        if (StringUtils.hasText(dateString)){
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date date = sdf.parse(dateString);
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            return sdf1.format(date);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }


    /**
     * 获取时间差
     * @param startTime,endTime
     * @return
     */
    public static String getMinusTime(String startTime,String endTime) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        // 获取当前时间
        /*Date date = new Date();
        String nowtime = df.format(date);*/
        try {
            Date d2 = df.parse(startTime);  //
            Date d1 = df.parse(endTime);

            long diff = d1.getTime() - d2.getTime();// 差值微秒
            long days = diff / (1000 * 60 * 60 * 24);
            /*小时 */
            long hours = (diff - days * (1000 * 60 * 60 * 24))
                    / (1000 * 60 * 60);
            /* long sc = (diff - days * (1000 * 60 * 60 * 24) - hours
             * (1000 * 60 * 60)) / (1000);  秒 */
            int day = (int)days;
            int hour = (int)hours;
            String minusTime = (day+"day"+hour+"h");
            return minusTime;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
