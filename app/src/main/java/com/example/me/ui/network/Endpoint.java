package com.example.me.ui.network;

import com.example.me.ui.network.response.LoginResponse;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

public interface Endpoint {

    @Multipart
    @POST("profiles/api/token-auth/")
    Call<LoginResponse> login(
            @HeaderMap Map<String, String> header,
            @PartMap Map<String, RequestBody> param
    );
}
