package pkubatis.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;

public class WebServiceUtils {

    private static Logger logger = LoggerFactory.getLogger(WebServiceUtils.class);

    public static Map<String,Object> send(String url,String nameSpaceUri,String methodName,String data){
        Map<String, Object> result = new HashMap<>();
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(url);
        QName name = new QName(nameSpaceUri, methodName);
        try {
            Object[] invoke = client.invoke(name, data);
            result = (Map<String, Object>) JSONObject.parse(invoke[0].toString());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("webservice调用失败,地址:{},命名空间:{},方法:{}",url,nameSpaceUri,methodName);
            logger.error("webservice调用错误",e);
            result.put("code",99);
            result.put("msg","发送失败");
            result.put("error",e);
            return result;
        } finally {
            client.destroy();
        }
    }

    public static String sendReturnStr(String url,String nameSpaceUri,String methodName,String sqzcm_qqwybsf,String information){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(url);
        QName name = new QName(nameSpaceUri, methodName);
        try {
            Object[] invoke = client.invoke(name, sqzcm_qqwybsf ,information);
            return invoke[0].toString();
        } catch (Exception e) {
            logger.error("webservice调用失败,地址:{},命名空间:{},方法:{}",url,nameSpaceUri,methodName);
            logger.error("webservice调用错误",e);
            e.printStackTrace();
            return "99";
        } finally {
            client.destroy();
        }
    }

    /**
     * webservice发送 不固定参数
     * @param url
     * @param nameSpaceUri
     * @param methodName
     * @param strData 不固定参数
     * @return
     */
    public static String sendReturnStr(String url,String nameSpaceUri,String methodName,String ...strData){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(url);
        QName name = new QName(nameSpaceUri, methodName);
        try {
            Object[] invoke = client.invoke(name ,strData);
            return invoke[0].toString();
        } catch (Exception e) {
            logger.error("webservice调用失败,地址:{},命名空间:{},方法:{}",url,nameSpaceUri,methodName);
            logger.error("webservice调用错误",e);
            e.printStackTrace();
            return "99";
        } finally {
            client.destroy();
        }
    }

    /**
     * webservice发送 不固定参数 对标湖南人像比对
     * @param url
     * @param nameSpaceUri
     * @param methodName
     * @param objects 不固定参数
     * @return
     */
    public static Object[] sendReturnObject(String url,String nameSpaceUri,String methodName,Object ...objects){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(url);
        QName name = new QName(nameSpaceUri, methodName);
        try {
            Object[] invoke = client.invoke(name ,objects);
            return invoke;
        } catch (Exception e) {
            logger.error("webservice调用失败,地址:{},命名空间:{},方法:{}",url,nameSpaceUri,methodName);
            logger.error("webservice调用错误",e);
            e.printStackTrace();
            return null;
        } finally {
            client.destroy();
        }
    }

    public static boolean send(String url, String nameSpaceUri, String methodName, String ...strData){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(url);
        QName name = new QName(nameSpaceUri, methodName);
        try {
            Object[] invoke = client.invoke(name, strData);
            logger.info(methodName+"返回参数:{}",invoke[0].toString());
            return true;
        } catch (Exception e) {
            logger.error("webservice调用失败,地址:{},命名空间:{},方法:{}",url,nameSpaceUri,methodName);
            logger.error("webservice调用错误",e);
            e.printStackTrace();
            return false;
        } finally {
            client.destroy();
        }
    }
}
