package pkubatis.model;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * <pre>
 * 基础model，只实现了toString()方法。
 * 只要实体类继承了该方法，默认就实现了toString方法，不需要重写toString方法。
 * 格式如下：
 * ModelName [field1=value1, field2=value2, ...]
 *
 * @author qiuyg
 * @version 0.3
 * @create：2017年3月25日
 * </pre>
 */
public class BaseModel {
	@Override
	public String toString() {
		Field[] fields = this.getClass().getDeclaredFields();
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
		sb.append(" [");
		for (Field f : fields) {
			// 如果是静态变量、或者不可赋值的变量
			if (Modifier.isStatic(f.getModifiers())
					|| Modifier.isFinal(f.getModifiers()))
				continue;
			// 亦或者加Hidden注解了的变量均不显示在toString方法中
			Object value = null;
			try {
				f.setAccessible(true);
				value = f.get(this);
				f.setAccessible(false);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			if (value != null)
				sb.append(f.getName()).append('=').append(value).append(", ");
		}
		sb.append(']');
		return sb.toString();
	}
}
