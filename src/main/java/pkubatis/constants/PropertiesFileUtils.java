package pkubatis.constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * @version
 * 001    20150715    李向卫    修复路径中包含空格的问题
 */
public class PropertiesFileUtils {

	/**
	 * 将指定路径的properties文件读入map<br/>
	 * 如 读取"scrk/resource/print/setting.properties", 则传参"print/setting.properties"
	 * @param propertiesFilepathRelativeToClassesDir 从 /WEB-INF/classes 开始的路径
	 */
	public static Map<String, String> readProperties2Map(String propertiesFilepathRelativeToClassesDir) {
		Map<String, String> printSettingMap = new HashMap<String, String>();
		Properties properties = new Properties();
		InputStream in = null;
		try {
			in = PropertiesFileUtils.class.getClassLoader().getResourceAsStream(propertiesFilepathRelativeToClassesDir);
			properties.load(in);
			for (Iterator<Entry<Object, Object>> it = properties.entrySet().iterator(); it.hasNext();) {
				Entry<Object, Object> entry = it.next();
				printSettingMap.put((String)entry.getKey(), (String)entry.getValue());
			}
			return printSettingMap;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			if ( in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
