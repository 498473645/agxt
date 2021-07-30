package pkubatis.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件处理
 * @author
 * @date 2019/06/16
 * Created by Think on 2017/11/29.
 */
public class FileUtis {
    private static Logger logger = LoggerFactory.getLogger(FileUtis.class);

    /**
     * 保存文件
     *
     * @param fileInputStream 上传文件
     * @param directory       根目录
     * @param fileName        文件名称
     * @return
     */
    public static boolean saveFilesByInputStream(InputStream fileInputStream, String directory, String fileName) {
        try {
            File file = new File(FileUtis.spellFileRelativePath(directory, fileName));
            FileCopyUtils.copy(fileInputStream, new FileOutputStream(file));
            return true;
        } catch (IOException e) {
            logger.info("文件上传失败", e);
            return false;
        }
    }

    /**
     * 拼写文件相当路径
     *
     * @param directory 目录
     * @param fileName  文件名称
     */
    public static String spellFileRelativePath(String directory, String fileName) {
        StringBuffer path = new StringBuffer();
        if (StringUtil.isNullOrEmpty(directory) || StringUtil.isNullOrEmpty(fileName)) {
            return null;
        }
        if (directory.endsWith(File.separator)) {
            path.append(directory);
        } else {
            path.append(directory + File.separator);
        }
        path.append(fileName);
        return path.toString();
    }

    /**
     * 保存文件
     *
     * @param file     上传文件
     * @param path     保存地址
     * @param fileName 文件名称
     */
    public static void saveUploadFiles(File file, String path, String fileName) {

    }

    /**
     * 删除文件通过文件路径
     *
     * @param pathName 文件相对路径
     */
    public static boolean deleteFileByPathName(String pathName) {
        if (StringUtil.isNullOrEmpty(pathName)) {
            return false;
        }
        return deleteFile(new File(pathName));
    }

    /**
     * 删除文件通过文件路径
     *
     * @param file
     */
    public static boolean deleteFile(File file) {
        if (file.exists()) {
            //判断是否是文件
            if (file.isFile()) {
                //删除文件
                file.delete();
            } else if (file.isDirectory()) {
                //否则如果它是一个目录
                //声明目录下所有的文件 files[];
                File[] files = file.listFiles();
                //遍历目录下所有的文件
                for (int i = 0; i < files.length; i++) {
                    //把每个文件用这个方法进行迭代
                    deleteFile(files[i]);
                }
                //删除文件夹
                file.delete();
            }
        } else {
            logger.info("delete file is null");
        }
        return true;
    }

}
