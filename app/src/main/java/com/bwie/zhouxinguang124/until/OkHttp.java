package com.bwie.zhouxinguang124.until;
/*
 *@auther:周鑫光
 *@Date: 2019/12/4
 *@Time:8:45
 *@Description:${DESCRIPTION}
 * */

import android.os.Handler;
import android.os.Message;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttp {
    private OkHttpClient okHttpClient;
    private HttpLoggingInterceptor interceptor;
    private MycallBack mmycallBack;
    private static final OkHttp ourInstance = new OkHttp();

    public static OkHttp getInstance() {
        return ourInstance;
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    mmycallBack.onsuccess(msg.obj.toString());
                    break;
                case 2:
                    mmycallBack.onError(msg.obj.toString());
                    break;
            }
        }
    };

    private OkHttp() {
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public void onget(String url, MycallBack mycallBack) {
        Request request = new Request.Builder().url(url).build();
        mmycallBack = mycallBack;
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendMessage(handler.obtainMessage(2, e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.sendMessage(handler.obtainMessage(1, response.body().string()));
            }
        });
    }

    public void onpost(String url, MycallBack mycallBack) {
        mmycallBack = mycallBack;
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.sendMessage(handler.obtainMessage(2, e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.sendMessage(handler.obtainMessage(1, response.body().string()));
            }
        });
    }

    public interface MycallBack {
        void onsuccess(String json);

        void onError(String error);

    }
}
