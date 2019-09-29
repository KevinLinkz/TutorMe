package com.example.me.ui.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String BASE_URL = "https://staging.skorpoints.com/";
    private final static OkHttpClient OK_HTTP_CLIENT = UnsafeHttpCLient.getUnsafeOkHttpClient();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass){
        builder.client(OK_HTTP_CLIENT);
        retrofit = builder.build();

        return retrofit.create(serviceClass);
    }
}
