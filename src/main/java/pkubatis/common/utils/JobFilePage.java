package pkubatis.common.utils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import pkubatis.model.JsonResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 案卷页信息表控制器
 *
 * @author
 */
@Controller
public class JobFilePage {
	/**
	  * 根据文件流读取图片文件真实类型
	  * @param src
	  * @return
	  */
	public static String bytesToHexString(byte[] src){
       StringBuilder strBuilder = new StringBuilder();
       if (src == null || src.length <= 0) {
           return null;
       }
       for (int i = 0; i < src.length; i++) {
           int v = src[i] & 0xFF;
           String strhs = Integer.toHexString(v);
           if (strhs.length() < 2) {
           	strBuilder.append(0);
           }
           strBuilder.append(strhs);
       }
       return strBuilder.toString();
   }

	 /**
	  * 根据文件流读取图片文件真实类型
	  * @param bytes
	  * @return
	  */
	public static String getTypeByStream(byte [] bytes) {
		byte[] b = new byte[4];
		try {
			 System.arraycopy(bytes, 0, b, 0, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String type = bytesToHexString(b).toUpperCase();
		if (type.contains("FFD8FF")) {
			return ".jpg";
		} else if (type.contains("89504E47")) {
			return ".png";
		} else if (type.contains("47494638")) {
			return ".gif";
		} else if (type.contains("41433130")) {
			return ".dwg";
		} else if (type.contains("424D")) {
			return ".bmp";
		} else if(type.contains("2020300D")){
			return ".dxf";
		}else if(type.contains("504B0304")){
			return ".docx";
		}else if(type.contains("50524F5F")){
			return ".txt";
		}else if(type.contains("D4B1B9A4")){
			return ".txt";
		}else if(type.contains("2F396A2F")){
			return ".txt";
		}else if(type.contains("D0CF11E0")){
			return ".xls";
		}else if(type.contains("504B0304")){
			return ".xlsx";
		}else {
			return "false";
		}

	}


	/**
	  * 根据文件流读取图片文件真实类型  上传文件  txt  doc xls
	  * @param bytes
	  * @return
	  */
	public static String getTypeByStreamDownload(byte [] bytes) {
		byte[] b = new byte[4];
		try {
			 System.arraycopy(bytes, 0, b, 0, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String type = bytesToHexString(b).toUpperCase();
		if(type.contains("504B0304")){
			return ".docx";
		}else if(type.contains("D0CF11E0")){
			return ".xls";
		}else if(type.contains("504B0304")){
			return ".xlsx";
		}else {
			return ".txt";
		}

	}
		/**
		 * 响应json结果
		 * @param jsonResult
		 * @param response
		 */
		public void toJsonResponse(JsonResult jsonResult, HttpServletResponse response){
			PrintWriter pw = null;
			try {
				response.reset();
				response.setContentType("text/html;charset=utf-8");
				ObjectMapper mapper = new ObjectMapper();
				String str = mapper.writeValueAsString(jsonResult);
				pw = response.getWriter();
				pw.write(str);
				pw.flush();
				pw.close();
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
