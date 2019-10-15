package com.example.me.network.connectorAPI;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ConnectorFinhackAPI {
    String BASE_URL = "http://192.168.43.51:80/connector_finhack/";

    //No Param
    @FormUrlEncoded
    @POST("workshop.php")
    Call<ResponseBody> getResponseJSON(
            @FieldMap Map<String, String> field
    );

}

