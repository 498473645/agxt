package pkubatis.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * base64转文件类型处理类
 * @author liuc
 * @date 2019/07/22
 */
public class Base64DecodedMultipartFile implements MultipartFile {
    private final String SUFFIX_PNG = "png";
    private final byte[] imgContent;
    private final String header;

    public Base64DecodedMultipartFile(byte[] imgContent, String header) {
        this.imgContent = imgContent;
        this.header = header;
    }

    @Override
    public String getName() {
        // TODO - implementation depends on your requirements
        if(header.contains(SUFFIX_PNG)){
            return System.currentTimeMillis() + Math.random() + ".png";
        }else{
            return System.currentTimeMillis() + Math.random() + ".jpg";
        }
    }

    @Override
    public String getOriginalFilename() {
        // TODO - implementation depends on your requirements
        if(header.contains("png")){
            return System.currentTimeMillis() + (int)Math.random() * 10000 + ".png";
        }else{
            return System.currentTimeMillis() + (int)Math.random() * 10000 + ".jpg";
        }
    }

    @Override
    public String getContentType() {
        // TODO - implementation depends on your requirements
        return header.split(":")[1];
    }

    @Override
    public boolean isEmpty() {
        return imgContent == null || imgContent.length == 0;
    }

    @Override
    public long getSize() {
        return imgContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return imgContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(imgContent);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(imgContent);
    }
}
