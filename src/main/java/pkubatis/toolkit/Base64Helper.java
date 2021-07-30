package pkubatis.toolkit;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import java.io.IOException;

public class Base64Helper {
	/**
	 * 编码
	 * @param byteArray
	 * @return
	 */
	   public static String encode(byte[] byteArray) {
	       return new String(new Base64().encode(byteArray));
	   }

	   /**
	    * 解码
	    * @param base64EncodedString
	    * @return
	    */
	   public static byte[] decode(String base64EncodedString) {
	    return new Base64().decode(base64EncodedString);
	   }

	   /**
		 * 字符串转二进制
		 *
		 * @param str
		 *            要转换的字符串
		 * @return 转换后的二进制数组
		 */
		public static byte[] hex2byte(String imgStr) { // 字符串转二进制
			//Base64解码
			BASE64Decoder decoder = new BASE64Decoder();
			try{
		        byte[] b = decoder.decodeBuffer(imgStr);
		        for(int i=0;i<b.length;++i){
		            if(b[i]<0){//调整异常数据
		                b[i]+=256;
		            }
		        }
		        return b;
			 } catch (IOException e) {
		            e.printStackTrace();
		            return null;
		     }
		}
}
