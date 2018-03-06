package com.isoftstone.huidingc.testqmui.network.utils;

import com.isoftstone.huidingc.testqmui.utils.CloseUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;

import okhttp3.MediaType;

/**
 * @auther huidingc
 * @date 2018/2/6 11:31
 * @description FileUtils
 */

public class FileUtils {
    /**
     * 将文件上传类型改为流类型
     */
    public static final MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");

    /** 根据文件名获取MIME类型 */
    public static MediaType guessMimeType(String fileName) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        //解决文件名中含有#号异常的问题
        fileName = fileName.replace("#", "");
        String contentType = fileNameMap.getContentTypeFor(fileName);
        if (contentType == null) {
            return MEDIA_TYPE_STREAM;
        }
        return MediaType.parse(contentType);
    }

    /**
     * 将文件写入指定文件夹
     * @param inputStream
     * @param path
     */
    public static void writeFileToSdcard(InputStream inputStream,String path){
        File file = new File(path);
        if(!isFileExists(file)){
            file.delete();
            file.getParentFile().mkdirs();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseUtils.closeIO(inputStream);
            CloseUtils.closeIO(fos);
        }
    }

    /**
     * 根据文件路径获取文件
     * @param filePath
     * @return
     */
    public static File getFileByPath(String filePath) {
        return isSpace(filePath) ? null : new File(filePath);
    }

    /**
     * 判断文件是否存在
     *
     * @param filePath 文件路径
     * @return {@code true}: 存在<br>{@code false}: 不存在
     */
    public static boolean isFileExists(String filePath) {
        return isFileExists(getFileByPath(filePath));
    }

    /**
     * 判断文件是否存在
     *
     * @param file 文件
     * @return {@code true}: 存在<br>{@code false}: 不存在
     */
    public static boolean isFileExists(File file) {
        return file != null && file.exists();
    }

    /**
     * 判断String数据是否为空
     * @param s
     * @return
     */
    private static boolean isSpace(String s) {
        if (s == null){
            return true;
        }
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
