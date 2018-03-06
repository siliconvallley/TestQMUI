package com.isoftstone.huidingc.testqmui.network.custom;

import android.support.annotation.Nullable;
import com.isoftstone.huidingc.testqmui.network.ProgressListener;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/**
 * @autor huidingc
 * @date 2018/2/2
 * @description ProgressRequestBody
 * @version 封装文件上传的的请求体
 */
public class ProgressRequestBody extends RequestBody {
    private RequestBody requestBody;
    private ProgressListener progressListener;
    private BufferedSink bufferedSink;

    public ProgressRequestBody(RequestBody requestBody,ProgressListener progressListener){
        this.requestBody = requestBody;
        this.progressListener = progressListener;
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return requestBody.contentType();
    }

    @Override
    public long contentLength() throws IOException {
        return requestBody.contentLength();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        if(null == bufferedSink){
            bufferedSink = Okio.buffer(sink(sink));
        }
        requestBody.writeTo(bufferedSink);
        //必须调用flush，否则最后一部分数据可能不会被写入
        bufferedSink.flush();
    }

    private Sink sink(BufferedSink sink) {
        return new ForwardingSink(sink) {
            //当前写入字节数
            long bytesWrite = 0L;
            //总字节长度，避免多次调用contentLength()方法
            long totalBytesWrite = 0L;

            @Override
            public void write(Buffer source, long byteCount) throws IOException {
                super.write(source, byteCount);
                //增加当前写入的字节数
                bytesWrite += byteCount;
                if(totalBytesWrite == 0){
                    totalBytesWrite = contentLength();
                }
                if(null != progressListener){
                    progressListener.onProgress(bytesWrite,totalBytesWrite,bytesWrite == totalBytesWrite);
                }
            }
        };
    }
}
