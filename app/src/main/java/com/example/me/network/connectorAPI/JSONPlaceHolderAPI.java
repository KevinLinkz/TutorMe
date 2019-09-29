package com.example.me.network.connectorAPI;

import com.example.me.dao.Comment;
import com.example.me.dao.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JSONPlaceHolderAPI {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

//    @Multipart
//    @POST("profiles/api/token-auth/")
////    Call<LoginResponse> login(
////            @HeaderMap Map<String, String> header,
////            @PartMap Map<String, RequestBody> param
////    );

    //No Param
    @GET("posts")
    Call<List<Post>> getListData();

    //With Param
    @GET("posts/{id}")
    Call<Post> getListData(
            @Path("id") int id
    );

    //With Param MAP
    @GET("posts/{id}")
    Call<Post> getListData(
            @QueryMap Map<String,String> param
    );

    //With Param in The Middle
    @GET("posts/{id}/comments")
    Call<List<Comment>> getCommentsPost(
            @Path("id") int id
    );

    //With Param Query
    @GET("comments")
    Call<List<Comment>> getComments(
            @Query("postId") int id
    );

    //Create POST with Object
    @POST("posts")
    Call<Post> createPost(@Body Post post);

    //Create POST with FormURLEncode
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userID") int userID,
            @Field("title") String title,
            @Field("body") String body
    );

    //Create POST with MAP
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @FieldMap Map<String, String> field
    );


}

