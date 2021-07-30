package pkubatis.toolkit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.time.DateUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import pkubatis.model.Criteria;
import pkubatis.model.QueryBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


public class WebUtils implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 将 页面传过来的 txtQuery 转换成查询条件对象 Criteria
	 * @param txtQuery
	 * <pre>
	 * {
		    "orderByClause" : "USER_ID DESC",
		    "distinct" : false,
		    "pager" : {
		        "start" : 0,
		        "limit" : 20,
		        "pageSize" : 20,
		        "totalRecords" : 0
		    },
		    "oredCriteria" : [
		        [{
		            "property" : "userName",
		            "operator" : "like",
		            "value" : "%a%",
		            "datatype" : "string"
		        },{
		            "property" : "deptId",
		            "operator" : "=",
		            "value" : "4201010000",
		            "datatype" : "string"
		        }],
		        [{
		            "property" : "realName",
		            "operator" : "like",
		            "value" : "%a%",
		            "datatype" : "string"
		        }]
		    ]
		}
	 * </pre>
	 * @return
	 */
    public static QueryBuilder toQueryBuilder(String txtQuery){
        try {
            QueryBuilder qb = new QueryBuilder();
            JSONObject object = JSON.parseObject(txtQuery);
            JSONObject rowBoundsObject = (JSONObject) object.get("pager");
            RowBounds rowBounds = new RowBounds((Integer)rowBoundsObject.get("start"),(Integer) rowBoundsObject.get("pageSize"));
            qb.setRowBounds(rowBounds);
            String orderBy = (String) object.get("orderByClause");
            if (StringUtils.hasText(orderBy)) {
                // 防sql注入
                if (checkSqlInjection(orderBy)) {
                    throw new IllegalArgumentException("查询条件中不能包含特殊字符");
                }
                qb.setOrderByClause(orderBy);
            }
            qb.setDistinct(false);
            List<JSONArray> oredCriteriaList = (List<JSONArray>) object.get("oredCriteria");
            if(oredCriteriaList!=null && oredCriteriaList.size() > 0){
                List<QueryBuilder.CriterionArray> qa = qb.getOredCriteria();
                for (int i = 0; i < oredCriteriaList.size(); i++) {
                    QueryBuilder.CriterionArray ca = new QueryBuilder.CriterionArray();
                    List<QueryBuilder.QueryCriterion> qc = ca.getCriteria();
                    JSONArray t = oredCriteriaList.get(i);
                    for (int j = 0; j < t.size(); j++) {
                        JSONObject criterionObject = (JSONObject)t.get(j);

                        qc.add(criterionObject.toJavaObject(QueryBuilder.QueryCriterion.class));
                    }
                    qa.add(ca);
                }

            }
            return qb;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("传入参数不是标准查询条件格式",e);
        }
    }

	public static Criteria toCriteria(QueryBuilder queryBuilder){
		Criteria targetCriteria = new Criteria();
		return setCriteria(targetCriteria,queryBuilder);
	}
	public static Criteria setCriteria(Criteria targetCriteria,QueryBuilder queryBuilder){
		targetCriteria.setDistinct(queryBuilder.isDistinct());
		String srcOrderBy = queryBuilder.getOrderByClause();
		if(StringUtils.hasText(srcOrderBy)){
			targetCriteria.setOrderByClause(srcOrderBy);
		}
		RowBounds srcRowBounds = queryBuilder.getRowBounds();
		if(srcRowBounds != null){
			targetCriteria.setRowBounds(srcRowBounds);
		}

		List<QueryBuilder.CriterionArray> srcOredCriteria = queryBuilder.getOredCriteria();
		if(!CollectionUtils.isEmpty(srcOredCriteria)){
			List<Criteria.BaseCriteria> targetOredCriteria = targetCriteria.getOredCriteria();
			for (QueryBuilder.CriterionArray srcCriterionArray : srcOredCriteria) {
				Criteria.BaseCriteria targetBc = new Criteria.BaseCriteria();
				for (QueryBuilder.QueryCriterion srcQc : srcCriterionArray.getCriteria()) {
					setTargetCriterion(targetBc, srcQc);
				}
				targetOredCriteria.add(targetBc);
			}
		}
		return targetCriteria;
	}


    /**
     * 将页面条件设置到查询标准中
     * @param targetBc 查询标准
     * @param srcQc 页面条件
     */
    private static void setTargetCriterion(Criteria.BaseCriteria targetBc, QueryBuilder.QueryCriterion srcQc) {
        // 字段对应的java属性名
        String regex = "^[a-zA-Z][a-zA-Z0-9_.]{1,30}$";
        Pattern pattern = Pattern.compile(regex);
        String property = srcQc.getProperty();
        if(!pattern.matcher(property).matches()){
            throw new IllegalArgumentException("查询条件中属性字段含有非法字符");
        }

        // 字段名
        String fieldName = "";
        if(property.indexOf(".") != -1){
            String refField = property.substring(0,property.indexOf(".") + 1);
            String txtField = StringHelper.toUnderline(property.substring(property.indexOf(".") + 1)).toUpperCase();
            fieldName = refField + txtField;
        }else{
            fieldName = StringHelper.toUnderline(property).toUpperCase();
        }

        // 操作符
        String operator = getOperator(srcQc.getOperator());

        if("NULL".equals(operator) || "NOT NULL".equals(operator)){
            targetBc.addCriterion(fieldName + " is " + operator);
        }else if("BETWEEN".equals(operator) || "NOT BETWEEN".equals(operator)){
            Object value = getValue(srcQc.getDatatype(), srcQc.getValue());
            Object value1 = getValue(srcQc.getDatatype(), srcQc.getValue1());
            targetBc.addCriterion(fieldName + " " + operator + " ", value, value1, property);
        }else if("IN".equals(operator) || "NOT IN".equals(operator)){
            // 返回list值
            Object value = getValue(srcQc.getDatatype(), srcQc.getValue(), true);
            targetBc.addCriterion(fieldName + " " + operator + " ", value, property);
        }else{
            Object value = getValue(srcQc.getDatatype(), srcQc.getValue());
            targetBc.addCriterion(fieldName + " " + operator + " ", value, property);
        }
    }

	public static Criteria toCriteria(String txtQuery){
		return toCriteria(toQueryBuilder(txtQuery));
	}
    /**
     * 获取操作符
     * @param operator
     * @return
     */
    private static String getOperator(String operator){
        // 默认操作符为：=
        if(operator == null || operator.trim().length() == 0){
            return "=";
        }
        String allOperator = "|=|!=|<>|>|>=|<|<=|LIKE|NOT LIKE|IN|NOT IN|BETWEEN|NOT BETWEEN|NULL|NOT NULL|";
        operator = operator.trim().toUpperCase();
        if(allOperator.indexOf("|" + operator + "|") == -1){
            throw new IllegalArgumentException("查询条件中操作符不合法");
        }
        return operator;
    }

    /**
     * 获取指定类型的值，注意：以逗号","隔开的值不转为list
     * @param datatype
     * @param value
     * @return 转换成对应类型后的值
     */
    private static Object getValue(String datatype, String value){
        return getValue(datatype,value,false);
    }



    /**
     * 获取指定类型的值
     * @param datatype
     * @param value
     * @param isArray 若为true，返回值将为list。处理以逗号","隔开的值
     * @return 转换成对应类型后的值
     */
    private static Object getValue(String datatype, String value, boolean isArray){
        if(value == null){
            throw new IllegalArgumentException("查询条件中存在值为空的条件");
        }
        // 防sql注入
        if(checkSqlInjection(value)){
            throw new IllegalArgumentException("查询条件中不能包含特殊字符");
        }

        datatype = datatype.trim().toLowerCase();
        value = value.trim();
        if("1".equals(datatype)){
            try {
                if(isArray){
                    List<Long> listValue = new ArrayList<Long>();
                    String[] valArray = StringUtils.split(value, ",");
                    for (int i = 0; i < valArray.length; i++) {
                        listValue.add(Long.parseLong(valArray[i]));
                    }
                    return listValue;
                }else{
                    return Long.parseLong(value);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("查询条件中存在类型与值不匹配的条件。类型要求为长数型，但传入的值不是合法的长整型数字");
            }
        }else if("3".equals(datatype)){
            try {
                if(isArray){
                    List<Date> listValue = new ArrayList<Date>();
                    String[] valArray = StringUtils.split(value, ",");
                    for (int i = 0; i < valArray.length; i++) {
                        Date date = DateUtils.parseDate(getNumber(valArray[i]),new String[]{"yyyyMMdd"});
                        if(date == null){
                            throw new Exception("不能正确格式化日期: " + valArray[i]);
                        }
                        listValue.add(date);
                    }
                    return listValue;
                }else{
                    Date date = DateUtils.parseDate(getNumber(value), new String[]{"yyyyMMdd"});
                    if(date == null){
                        throw new Exception("不能正确格式化日期: " + value);
                    }
                    return date;
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("查询条件中存在类型与值不匹配的条件。类型要求为日期型，但传入的值不是合法的日期型");
            }
        }else if("4".equals(datatype)){
            try {
                if(isArray){
                    List<Date> listValue = new ArrayList<Date>();
                    String[] valArray = StringUtils.split(value, ",");
                    for (int i = 0; i < valArray.length; i++) {
                        Date date = DateUtils.parseDate(getNumber(value), new String[]{"yyyyMMddHHmmss"});
                        if(date == null){
                            throw new Exception("不能正确格式化日期时间: " + valArray[i]);
                        }
                        listValue.add(date);
                    }
                    return listValue;
                }else{
                    Date date = DateUtils.parseDate(getNumber(value), new String[]{"yyyyMMddHHmmss"});
                    if(date == null){
                        throw new Exception("不能正确格式化日期时间: " + value);
                    }
                    return date;
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("查询条件中存在类型与值不匹配的条件。类型要求为日期时间型，但传入的值不是合法的日期时间型");
            }
        }else if("7".equals(datatype)){
            try {
                if(isArray){
                    List<Float> listValue = new ArrayList<Float>();
                    String[] valArray = StringUtils.split(value, ",");
                    for (int i = 0; i < valArray.length; i++) {
                        listValue.add(Float.parseFloat(valArray[i]));
                    }
                    return listValue;
                }else{
                    return Float.parseFloat(value);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("查询条件中存在类型与值不匹配的条件。类型要求为浮点型，但传入的值不是合法的浮点型数字");
            }
        }else{
            if(isArray){
                String[] valArray = value.split(",");
                return CollectionUtils.arrayToList(valArray);
            }else{
                return value;
            }
        }
    }

    /**
     * 只提取数字
     * @param str 字符串
     * @return 只含有数字的字符串
     */
    private static String getNumber(String str){
        StringBuffer buffer = new StringBuffer();
        char []ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                buffer.append(ch[i]);
            }
        }
        return buffer.toString();
    }
	/**
	 * 检查是否存在sql注入 true为存在，false不存在
	 * @param str 检查值
	 * @return true/false
	 */
	private static boolean checkSqlInjection(String str){
		if(str.indexOf("'") != -1){
			return true;
		}
		return false;
	}

	public static void main( String[] args ) {
	    String txtQuery = "{\"orderByClause\" : \"USER_ID DESC\",\"distinct\" : false,\"rowBounds\" : {\"offset\" : 0,\"limit\" : 20,\"pageSize\" : 20,\"totalRecords\" : 0},\"oredCriteria\" : [[{\"property\" : \"userName\",\"operator\" : \"like\",\"value\" : \"%a%\",\"datatype\" : \"string\"},{\"property\" : \"deptId\",\"operator\" : \"=\",\"value\" : \"4201010000\",\"datatype\" : \"string\"}],[{\"property\" : \"realName\",\"operator\" : \"like\",\"value\" : \"%a%\",\"datatype\" : \"string\"}]]}";
        System.out.println(toCriteria(txtQuery));
        System.out.println("==========================");

	}
}


