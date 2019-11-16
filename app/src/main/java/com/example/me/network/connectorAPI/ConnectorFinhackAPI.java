package com.example.me.network.connectorAPI;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ConnectorFinhackAPI {
    String BASE_URL = "http://149.129.248.37/connector_finhack/";
//    String BASE_URL = "http://192.168.1.3:80/connector_finhack/";

    //No Param
    @FormUrlEncoded
    @POST("workshop.php")
    Call<ResponseBody> getResponseJSON(
            @FieldMap Map<String, String> field
    );

    //No Param
//    @FormUrlEncoded
//    @POST("workshop.php")
//    Call<ResponseBody> getResponseJSON(
//            @FieldMap Map<String, String> field
//    );

}

