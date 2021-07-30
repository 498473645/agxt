package pkubatis.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;

/**
 * 文件非空检查
 * @author livvy
 * @date 2019/06/18
 */
public class FieldNotNull {
	public final static String IDDEFAULT="00000000-0000-0000-0000-000000000000";
    /**
     * 成功
     */
    public final static String STATUS_CODE_SUCCESS = "00";// 成功
    /**
     * 程序问题
     */
    public final static String EXTERNAL_INTERFACE = "10";// 程序问题
    /**
     * 参数错误
     */
    public final static String STATUS_CODE_PARAM_ERROR = "20";// 参数错误
    /**
     * 第三方接口问题
     */
    public final static String STATUS_CODE_INTERFACE_ERROR = "30";// 第三方接口问题
    /**
     * 业务问题
     */
    public final static String STATUS_CODE_BUSINESS_ERROR = "40";// 业务问题
    /**
     * 其他出错
     */
    public final static String STATUS_CODE_ERROR = "99";// 失败
    /**
     * 未找到数据
     */
    public final static String STATUS_CODE_NOTFOUND ="90";//未找到数据
	public final static String str="";

	public static boolean isJson(String content){

	    try {
	        JSONObject jsonStr= JSONObject.parseObject(content);
	        return  true;
	   } catch (Exception e) {
	        return false;
	  }
	 }

	/**
	 * 去掉字符串末尾的0
	 * @param str
	 * @return
	 */
	public static String removeTail(String str){
		if(!str.substring(str.length() -1).equals("0")){
			return str;
		}else{
			return removeTail(str.substring(0, str.length() -1 ));
		}
	}
//	public static Date getDate(){
//	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    try {
//	        Date date=sdf.parse("1970-1-1 00:00:00");
//	        return date;
//	    } catch (ParseException e) {
//	        e.printStackTrace();
//	    }
//	    return new Date(0);
//	}
   //根据身份编号获取年龄
   public static int getAgeByIdCard(String idCard) {
        int iAge = 0;
        Calendar cal = Calendar.getInstance();
        String year = idCard.substring(6, 10);
        int iCurrYear = cal.get(Calendar.YEAR);
        iAge = iCurrYear - Integer.valueOf(year);
        return iAge;
    }
   public static <T> T  toJavaObject(String data,String name, Class<T> clazz){
	   JSONObject jsonObject = JSONArray.parseObject(data);
       String haRecordStr = FieldNotNull.stringisNull(jsonObject.get(name));
       JSONObject haRecordJson = JSONObject.parseObject(haRecordStr);
       T t = JSONObject.toJavaObject(haRecordJson,clazz);
       return t;
   }
   public static <T> List<T>  parseArray(String data,String name, Class<T> clazz){
	   JSONObject jsonObject = JSONArray.parseObject(data);
       String haRecordPeopleListStr = FieldNotNull.stringisNull(jsonObject.get(name));
       List<T> t = JSON.parseArray(haRecordPeopleListStr,clazz);
       return t;
   }
   public static String  toJavaObject(String data,String name){
	   JSONObject jsonObject = JSONArray.parseObject(data);
	   String retu = FieldNotNull.stringisNull(jsonObject.get(name));
       return retu;
   }
    public static Integer integerisNull(Integer data){
    	if(data == null){
    		return 0;
    	}
    	return data;
    }
    public static String stringisNull(Object data){
    	if(data == null){
    		return null;
    	}
    	return data.toString();
    }

    public static <T> Object field(Object object){
        if(object == null){
            return null;
        }
        try {
            if("java.util.ArrayList".equals(object.getClass().getName())){
                List<T> list=(List<T>) object;
                for(int i=0;i<list.size();i++){
                    java.lang.reflect.Field[] field = list.get(i).getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
                    for (int j = 0; j < field.length; j++) { // 遍历所有属性
                        String name = field[j].getName(); // 获取属性的名字
                        name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                        String type = field[j].getGenericType().toString(); // 获取属性的类型
                        if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                            Method m = list.get(i).getClass().getMethod("get" + name);
                            String value = (String) m.invoke(list.get(i)); // 调用getter方法获取属性值
                            if (value == null) {
                                m = list.get(i).getClass().getMethod("set"+name,String.class);
                                m.invoke(list.get(i), "");
                            }
                        }
                        if (type.equals("class java.lang.Integer")) {
                            Method m = list.get(i).getClass().getMethod("get" + name);
                            Integer value = (Integer) m.invoke(list.get(i));
                            if (value == null) {
                                m = list.get(i).getClass().getMethod("set"+name,Integer.class);
                                m.invoke(list.get(i), 0);
                            }
                        }
                        if (type.equals("class java.lang.Double")) {
                            Method m = list.get(i).getClass().getMethod("get" + name);
                            Double value = (Double) m.invoke(list.get(i));
                            if (value == null) {
                                m = list.get(i).getClass().getMethod("set"+name,Double.class);
                                m.invoke(list.get(i), 0.0);
                            }
                        }
                        if (type.equals("class java.lang.Boolean")) {
                            Method m = list.get(i).getClass().getMethod("get" + name);
                            Boolean value = (Boolean) m.invoke(list.get(i));
                            if (value == null) {
                                m = list.get(i).getClass().getMethod("set"+name,Boolean.class);
                                m.invoke(list.get(i), false);
                            }
                        }
	    /*                if (type.equals("class java.util.Date")) {
	                        Method m = list.get(i).getClass().getMethod("get" + name);
	                        Date value = (Date) m.invoke(list.get(i));
	                        if (value == null) {
	                            m = list.get(i).getClass().getMethod("set"+name,Date.class);
	                            m.invoke(list.get(i), new Date());
	                        }
	                    }*/
                    }
                }
                return object;
            }else{
                //java.lang.reflect.Field[]
                java.lang.reflect.Field[] field = object.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组

                for (int j = 0; j < field.length; j++) { // 遍历所有属性
                    String name = field[j].getName(); // 获取属性的名字
                    name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                    String aaaa = field[j].getType().toString(); // 获取属性的类型
                    String type = field[j].getGenericType().toString(); // 获取属性的类型
                    if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                        Method m = object.getClass().getMethod("get" + name);
                        String value = (String) m.invoke(object); // 调用getter方法获取属性值
                        if (value == null) {
                            m = object.getClass().getMethod("set"+name,String.class);
                            m.invoke(object, "");
                        }
                    }
                    if (type.equals("class java.lang.Integer")) {
                        Method m = object.getClass().getMethod("get" + name);
                        Integer value = (Integer) m.invoke(object);
                        if (value == null) {
                            m = object.getClass().getMethod("set"+name,Integer.class);
                            m.invoke(object, 0);
                        }
                    }
                    if (type.equals("class java.lang.Double")) {
                        Method m = object.getClass().getMethod("get" + name);
                        Double value = (Double) m.invoke(object);
                        if (value == null) {
                            m = object.getClass().getMethod("set"+name,Double.class);
                            m.invoke(object, 0.0);
                        }
                    }
                    if (type.equals("class java.lang.Boolean")) {
                        Method m = object.getClass().getMethod("get" + name);
                        Boolean value = (Boolean) m.invoke(object);
                        if (value == null) {
                            m = object.getClass().getMethod("set"+name,Boolean.class);
                            m.invoke(object, false);
                        }
                    }
	    /*                if (type.equals("class java.util.Date")) {
	                        Method m = object.getClass().getMethod("get" + name);
	                        Date value = (Date) m.invoke(object);
	                        if (value == null) {
	                            m = object.getClass().getMethod("set"+name,Date.class);
	                            m.invoke(object, new Date());
	                        }
	                    }*/
                }
                return object;
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }

}
