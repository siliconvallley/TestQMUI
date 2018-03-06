package com.isoftstone.huidingc.testqmui.network;

/**
 * @autor huidingc
 * @date 2018/2/2
 * @description ProgressListener 进度监听
 * @version
 */
public interface ProgressListener {
    /**
     * 进度监听
     * @param bytesRead 读取的文件长度
     * @param contentLength 文件总的长度
     * @param done
     */
    void onProgress(long bytesRead, long contentLength, boolean done);
}
