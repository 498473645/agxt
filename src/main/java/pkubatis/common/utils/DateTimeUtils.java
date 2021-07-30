package pkubatis.common.utils;

import com.alibaba.druid.util.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * 日期时间工具类
 *
 * @author Liz 二〇一二年十二月二十日
 *
 */
public class DateTimeUtils {

	public static final String DATE_PATTERN = "dd-MM-yyyy";

	public static final String DATE_PATTERN1 = "yyyy年MM月dd日";

	public static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final String TIME_PATTERN1 = "yyyy年MM月dd日HH时mm分";

	public static final String TIME_PATTERN2 = "yyyy/MM/dd HH:mm:ss";

	public static final String TIME_PATTERN3 = "dd-MM-yyyy HH:mm:ss";

	public static final String MILL_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * 得到当前日期的前几天
	 *
	 * @param span
	 *            间隔 (前几天就用负数，后几天用正数)
	 * @return
	 */
	public static String getNextDate(int span) {
		span = span - 1;
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH) + span);
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		return sdf.format(date.getTime());
	}

	/**
	 * 得到给定日期的前几年
	 *
	 * @param span
	 *            间隔 (前几年就用负数，后几年用正数)
	 * @return
	 */
	public static String getNextYearDate(String date, int span) {
		String[] dateArr = date.split("-");
		Calendar dateTemp = Calendar.getInstance();
		dateTemp.set(Integer.valueOf(dateArr[0]),
				Integer.valueOf(dateArr[1]) - 1, Integer.valueOf(dateArr[2]));
		dateTemp.set(Calendar.YEAR, dateTemp.get(Calendar.YEAR) + span);
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		return sdf.format(dateTemp.getTime());
	}

	/**
	 * 得到当前日期时间 yyyy-MM-dd
	 *
	 * @return
	 */
	public static String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		return sdf.format(new Date());
	}

	/**
	 * 得到当前日期时间 yyyy-MM
	 *
	 * @return
	 */
	public static String getMouth() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		return sdf.format(new Date());
	}

	/**
	 * getYear 得到当前年 yyyy年
	 *
	 * @return
	 */
	public static String getYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(new Date());
	}

	/**
	 * 得到当前时间 HH:mm:ss
	 *
	 * @return
	 */
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(new Date());
	}

	/**
	 *
	 * 得到当前日期时间
	 *
	 * @return yyyy-MM-dd HH:mm:ss字符串
	 */
	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN3);
		return sdf.format(new Date());
	}

	/**
	 * getMonthLastDay 得到本月的最后一天
	 *
	 * @return
	 */
	public static String getMonthLastDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}

	/**
	 * getMonthFirstDay 得到本月的第一天
	 *
	 * @return
	 */
	public static String getMonthFirstDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
	}

	/**
	 * getCurrentQuarterStartTime 得到当前季度
	 *
	 * @return
	 */
	public static String getCurrentQuarterStartTime() {
		Calendar c = Calendar.getInstance();
		int currentMonth = c.get(Calendar.MONTH) + 1;
		String QuarterStartTime = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				QuarterStartTime = c.get(Calendar.YEAR) + "年 01季度";
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				QuarterStartTime = c.get(Calendar.YEAR) + "年 02季度";
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				QuarterStartTime = c.get(Calendar.YEAR) + "年 03季度";
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				QuarterStartTime = c.get(Calendar.YEAR) + "年 04季度";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return QuarterStartTime;
	}

	public static void main(String[] args) {
		System.out.println(getCurrentQuarterStartTime());

	}

	/**
	 * 将yyyy-MM-dd格式日期转换成yyyy年MM月dd日
	 *
	 * @param date
	 *            yyyy-MM-dd、yyyy-MM-dd HH:mm:ss格式日期字符串
	 * @return
	 */
	public static String formatDate(String date) {
		if (date != null && !date.equals("")) {
			return date.split("-")[0] + "年" + date.split("-")[1] + "月"
					+ date.split("-")[2] + "日";
		} else {
			return "";
		}
	}

	/**
	 *
	 * 将Date转换成相应的yyyy-MM-dd HH:mm:ss字符串
	 *
	 * @return
	 */
	public static String dateToStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN);
		return sdf.format(date);
	}

	/**
	 *
	 * 将Date转换成相应的yyyy年MM月dd日HH时mm分字符串
	 *
	 * @return
	 */
	public static String getDateToStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN1);
		return sdf.format(date);
	}

	/**
	 *
	 * 将Date转换成相应的yyyy年MM月dd日字符串
	 *
	 * @return
	 */
	public static String getDateToStrNoHourAndSecond(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN1);
		return sdf.format(date);
	}

	/**
	 *
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN);
		return sdf.format(date);
	}

	/**
	 *
	 * 将Date转换成相应的HH字符串
	 *
	 * @return
	 */
	public static String dateToStr2(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		return sdf.format(date);
	}

	/**
	 *
	 * 将Date转换成相应的yyyyMMdd字符串
	 *
	 * @return
	 * @throws ParseException
	 */
	public static String dateToString2(String date) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(dateFormat.parse(date));
	}

	/**
	 *
	 * 将Date转换成相应的yyyyMMddHHmmSS字符串
	 *
	 * @return
	 */
	public static String dateToStrID() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}

	/**
	 * method 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp） dateString
	 * 需要转换为timestamp的字符串 dataTime timestamp
	 */
	public final static Timestamp stringToTime(String dateString)
			throws ParseException {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS",
				Locale.ENGLISH);// 设定格式
		// dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss",
		// Locale.ENGLISH);
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);// util类型
		Timestamp dateTime = new Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
		return dateTime;
	}

	/**
	 * method 将字符串类型的日期转换为一个Date（java.sql.Date） dateString 需要转换为Date的字符串
	 * dataTime Date
	 */
	public final static java.sql.Date stringToDate(String dateString)
			throws Exception {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat(DATE_PATTERN, Locale.ENGLISH);
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);// util类型
		java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());// sql类型
		return dateTime;
	}

	/**
	 * method 将字符串类型的日期转换为一个Date（java.sql.Date） dateString 需要转换为Date的字符串
	 * dataTime Date
	 */
	public final static java.sql.Date stringToDateTime(String dateString)
			throws Exception {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat(TIME_PATTERN, Locale.ENGLISH);
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);// util类型
		java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());// sql类型
		return dateTime;
	}

	/**
	 * method 将字符串类型的日期转换为一个Date（java.sql.Date） dateString 需要转换为Date的字符串
	 * dataTime Date
	 */
	public final static java.sql.Date stringToDateTime2(String dateString)
			throws Exception {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat(TIME_PATTERN2, Locale.ENGLISH);
		dateFormat.setLenient(false);
		dateString = dateString + ":00";
		Date timeDate = dateFormat.parse(dateString);// util类型
		java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());// sql类型
		return dateTime;
	}

	/**
	 * 将日期字符串转化成yyyy-MM-dd HH:mm:ss格式的字符串
	 *
	 * @param dateString
	 * @return
	 * @throws Exception
	 */
	public final static String formatDateTimeStr(String dateString)
			throws Exception {
		String formatString = "";
		DateFormat dateFormat = new SimpleDateFormat(TIME_PATTERN);
		Date date = dateFormat.parse(dateString);
		formatString = dateToString(date);
		return formatString;
	}

	/**
	 * 将Timestamp日期转化成yyyy-MM-dd HH:mm:ss格式的字符串,去除毫秒
	 *
	 * @param dateTime
	 * @return
	 * @throws Exception
	 */
	public final static String formatDateTime(Timestamp dateTime)
			throws Exception {
		if (dateTime == null) {
			return "";
		}
		DateFormat dateFormat = new SimpleDateFormat(TIME_PATTERN);
		return dateFormat.format(dateTime);
	}

	/**
	 * String转化成Timestamp 去除毫秒
	 *
	 * @param dateTimeStr
	 * @return
	 * @throws Exception
	 */
	public final static Timestamp StringToTimestamp(String dateTimeStr)
			throws Exception {
		SimpleDateFormat df = new SimpleDateFormat(MILL_TIME_PATTERN);
		Date date = df.parse(dateTimeStr);
		String time = df.format(date);
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}

	/**
	 * TimestampString转化成 Date String去除时分秒毫秒
	 *
	 * @param dateTimeStr
	 * @return
	 * @throws Exception
	 */
	public final static String ToDateString(String dateTimeStr)
			throws Exception {
		String str = "";
		if (!StringUtils.isEmpty(dateTimeStr)) {
			str = dateTimeStr.substring(0, 10);
		}
		return str;
	}

	/**
	 * 比较两个 日期字符串大小 大于零：BDate>EDate 小于零：BDate<EDate
	 *
	 * @param BDate
	 * @param EDate
	 * @return
	 * @throws ParseException
	 */
	public static long compareDateStr(String BDate, String EDate)
			throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(DATE_PATTERN);
		Date date1 = df.parse(BDate);
		Date date2 = df.parse(EDate);
		return date1.getTime() - date2.getTime();
	}

	/**
	 * 比较两个时间字符串大小 大于零：BDate>EDate 小于零：BDate<EDate
	 *
	 * @param BDate
	 * @param EDate
	 * @return
	 * @throws ParseException
	 */
	public static long compareDatetimeStr(String BDate, String EDate)
			throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(TIME_PATTERN);
		Date date1 = df.parse(BDate);
		Date date2 = df.parse(EDate);
		return date1.getTime() - date2.getTime();
	}

	/**
	 * 获取两个 日期字符串相差的天数
	 *
	 * @param BDate
	 * @param EDate
	 * @return
	 * @throws ParseException
	 */
	public static long getDaysFromDateStr(String BDate, String EDate)
			throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat(DATE_PATTERN);
		Date date = df.parse(BDate);
		Date now = df.parse(EDate);
		long l = now.getTime() - date.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		// long hour=(l/(60*60*1000)-day*24);
		// long min=((l/(60*1000))-day*24*60-hour*60);
		// long s=(l/1000-day*24*60*60-hour*60*60-min*60);
		// System.out.println(""+day+"天"+hour+"小时"+min+"分"+s+"秒");
		return day;
	}

	/**
	 * 给定一个日期MTime，算出它后面num个月之后的日期
	 *
	 * @param Mtime
	 * @param num
	 * @return
	 * @throws Exception
	 */
	public static String getAddMTime(String Mtime, int num) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat(DATE_PATTERN);
		Calendar nowTime = Calendar.getInstance();
		nowTime.setTime(stringToDate(Mtime));
		nowTime.add(Calendar.MONTH, num);// 日期加num个月
		Date dt = nowTime.getTime();
		String reStr = df.format(dt);
		return reStr;
	}

	/**
	 * 判断闰年
	 *
	 * @param year
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	// java获得两个日期之前相差的月份

	public static int getMonth(String startStr, String endStr) throws Exception {
		Date start = stringToDate(startStr);
		Date end = stringToDate(endStr);
		/*
		 * if (start.after(end)) { Date t = start; start = end; end = t; }
		 */
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(start);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(end);
		Calendar temp = Calendar.getInstance();
		temp.setTime(end);
		temp.add(Calendar.DATE, 1);

		int year = endCalendar.get(Calendar.YEAR)
				- startCalendar.get(Calendar.YEAR);
		int month = endCalendar.get(Calendar.MONTH)
				- startCalendar.get(Calendar.MONTH);

		if ((startCalendar.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month + 1;
		} else if ((startCalendar.get(Calendar.DATE) != 1)
				&& (temp.get(Calendar.DATE) == 1)) {
			return year * 12 + month;
		} else if ((startCalendar.get(Calendar.DATE) == 1)
				&& (temp.get(Calendar.DATE) != 1)) {
			return year * 12 + month;
		} else {
			return (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
		}
	}

	/**
	 * 在指定日期上往后加一天 支持 yyyy-MM-dd 格式
	 *
	 * @param specifiedDay
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
				.format(c.getTime());
		return dayAfter;
	}

	/**
	 * 返回指定年月的月的第一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDayOfMonth(Integer year, Integer month) {
		Calendar calendar = Calendar.getInstance();
		if (year == null) {
			year = calendar.get(Calendar.YEAR);
		}
		if (month == null) {
			month = calendar.get(Calendar.MONTH);
		}
		month = month - 1;
		calendar.set(year, month, 1);
		return DateTimeUtils.dateToStr2(calendar.getTime());
	}

	/**
	 * 返回指定年月的月的最后一天
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDayOfMonth(Integer year, Integer month) {
		Calendar calendar = Calendar.getInstance();
		if (year == null) {
			year = calendar.get(Calendar.YEAR);
		}
		if (month == null) {
			month = calendar.get(Calendar.MONTH);
		}
		month = month - 1;
		calendar.set(year, month, 1);
		calendar.roll(Calendar.DATE, -1);
		return DateTimeUtils.dateToStr2(calendar.getTime());
	}

	/**
	 * 返回当前日期是第几周
	 *
	 * @return
	 */
	public static int getWeekOfTodate() {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(new Date());
		int i = c.get(Calendar.WEEK_OF_YEAR);
		return i;
	}

	/**
	 * 返回指定日期是第几周
	 *
	 * @return
	 * @throws ParseException
	 */
	public static int getWeekOfDate(String d) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(d);
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 得到某年某周的第一天,星期一为每周的第一天
	 *
	 * @param year
	 * @param week
	 * @return
	 */
	public static String getFirstDayOfWeek(int year, int week) {
		week = week - 1;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DATE, 1);

		Calendar cal = (Calendar) calendar.clone();
		cal.add(Calendar.DATE, week * 7);

		return DateTimeUtils.dateToStr2(getFirstDayOfWeek(cal.getTime()));
	}

	/**
	 * 得到某年某周的最后一天,星期一为每周的第一天
	 *
	 * @param year
	 * @param week
	 * @return
	 */
	public static String getLastDayOfWeek(int year, int week) {
		week = week - 1;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DATE, 1);
		Calendar cal = (Calendar) calendar.clone();
		cal.add(Calendar.DATE, week * 7);

		return DateTimeUtils.dateToStr2(getLastDayOfWeek(cal.getTime()));
	}

	/**
	 * 取得当前日期所在周的第一天,星期一为每周的第一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek()); // Sunday
		return calendar.getTime();
	}

	/**
	 * 取得当前日期所在周的最后一天,星期一为每周的第一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6); // Saturday
		return calendar.getTime();
	}

	/**
	 * 在指定时间上往后加n小时,n可为负数
	 *
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date getSpecifiedHourAfter(Date date, int n) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR, n);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateStr = c.getTime();
		return dateStr;
	}

	/**
	 * 根据出生日期计算年龄
	 *
	 * @param birthday_
	 *            yyyy-MM-dd格式的日期
	 * @return age
	 * @throws ParseException
	 */
	public static String getAgeByBirth(String birthday_) throws ParseException {
		int age = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = format.parse(birthday_);
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(new Date());// 当前时间

			Calendar birth = Calendar.getInstance();
			birth.setTime(birthday);

			if (birth.after(now)) {// 如果传入的时间，在当前时间的后面，返回0岁
				age = 0;
			} else {
				age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
				if (now.get(Calendar.DAY_OF_YEAR) > birth
						.get(Calendar.DAY_OF_YEAR)) {
					age += 1;
				}
			}
			return age + "";
		} catch (Exception e) {// 兼容性更强,异常后返回数据
			return "0";
		}
	}

	/**
	 * 两个时间相差距离多少天多少小时多少分
	 *
	 * @param str1
	 *            开始时间
	 * @param str2
	 *            结束时间
	 * @param pattern
	 *            日期格式 可为空
	 * @return /分
	 */
	public static long getDistanceTime(String str1, String str2, String pattern) {
		if (pattern == null || pattern.equals("")) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		DateFormat df = new SimpleDateFormat(pattern);
		long day = 0;
		long hour = 0;
		long min = 0;
		try {
			Date one = df.parse(str1);
			Date two = df.parse(str2);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff;
			if (time1 < time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			// day = diff / (24 * 60 * 60 * 1000);
			// hour = (diff / (60 * 60 * 1000) - day * 24);
			min = diff / 1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		/*
		 * if(day==0){ return hour + "H" + min + "m" ; }else return day + "d" +
		 * hour + "H" + min + "m" ;
		 */
		return min;
	}

	public static String minToHMin(long timeNew) {
		long hour = 0;
		long min = 0;
		long time = timeNew / 60;
		if (time < 60) {
			return time + "m";
		} else {
			hour = time / 60;
			min = time - hour * 60;
			return hour + "H" + min + "m";
		}

	}

	// 时间加一秒
	public static Date addOneSecond(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, 1);
		return calendar.getTime();
	}

	/**
	 * 传入时间字符串，减去或加上n秒
	 *
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	/*
	 * public static String getMinusDateStr(String dateStr, int n) throws
	 * ParseException { SimpleDateFormat format = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); Date date =
	 * format.parse(dateStr); Calendar c = Calendar.getInstance();
	 * c.setTime(date); c.add(Calendar.SECOND,n);
	 *
	 * SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); Date
	 * dateNew=c.getTime();
	 *
	 * return dateStr; }
	 */

	/**
	 * getMonthLastDay 得到制定某月的最后一天
	 *
	 * @return
	 */
	public static int getChooseMonthLastDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
}
