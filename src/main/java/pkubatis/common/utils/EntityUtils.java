package pkubatis.common.utils;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Bean操作类
 * @author tangqiang
 */
public class EntityUtils {

    public static boolean hasList(List<?> list){
        boolean result = true;
        if(null == list){
            result = false;
        }else if(list.size()==0){
            result = false;
        }
        return result;
    }


    /**
     * 对象属性复制方法
     * @param resource 源对象
     * @param target 目标对象
     */
    public static void copyProperties(Object resource,Object target){
        copyProperties(resource, target, false);
//        final BeanCopier beanCopier = BeanCopier.create(resource.getClass(), target.getClass(), false);
//        beanCopier.copy(resource,target,null);
    }

    /**
     * 对象属性复制方法
     * @param resource 源对象
     * @param target 目标对象
     * @param coverNull 是否将null值也进行覆盖 false：会选择不为空的属性对目标对象赋值 true：null值会覆盖目标对象的值
     */
    public static void copyProperties(Object resource,Object target, boolean coverNull){
        if (coverNull){
            copyProperties(resource,target);
        }else {
            org.springframework.beans.BeanUtils.copyProperties(resource, target, getNullPropertyNames(resource));
        }
    }

    /**
     * 将bean转成map 注意：会去除class属性
     * 此方法会打日志，不建议使用
     * @param bean
     * @return
     */
    @Deprecated
    public static Map<String, String> describe(final Object bean) {
        Map<String, String> describe = null;
        try {
            describe = BeanUtilsBean.getInstance().describe(bean);
            describe.remove("class");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return describe;
    }

    /**
     * 将map中的属性赋值到bean中
     * @param bean
     * @param properties
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static void populate(final Object bean, final Map<String, ? extends Object> properties) {
        try {
            BeanUtilsBean.getInstance().populate(bean, properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到对象中的空属性
     * @param source
     * @return
     */
    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }

        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}
