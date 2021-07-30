package pkubatis.common.utils;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.IOException;

public class Base64ToMultipart {

    public static MultipartFile base64ToMultipart(String base64) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = new byte[0];
            b = decoder.decodeBuffer(base64);

            for(int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            return new Base64DecodedMultipartFile(b, "data:image/jpeg");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MultipartFile pngBase64ToMultipart(String base64) {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] b = new byte[0];
            b = decoder.decodeBuffer(base64);

            for(int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            return new Base64DecodedMultipartFile(b, "data:image/png");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //测试
    public static void main(String[] args) {
        MultipartFile multipartFiles[] = new MultipartFile[2];
        multipartFiles[0] = Base64ToMultipart.base64ToMultipart("");
        System.out.println(multipartFiles[0].getSize());
    }
}
