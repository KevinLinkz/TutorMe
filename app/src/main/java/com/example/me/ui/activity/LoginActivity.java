package com.example.me.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.me.R;
import com.example.me.dao.api.Comment;
import com.example.me.dao.api.Post;
import com.example.me.network.connectorAPI.ConnectorFinhackAPI;
import com.example.me.network.connectorAPI.JSONPlaceHolderAPI;
import com.example.me.network.retrofit.MyRetrofit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        Login
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                doLogin();

                Toast.makeText(getApplicationContext(), "Login Sucessfull", Toast.LENGTH_LONG).show();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //Sign Up
//        TextView lblSignUp = (TextView) findViewById(R.id.lnkSignUp);
//        lblSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
//                startActivity(i);
//            }
//        });
    }


    private void doLogin() {

        testConnectorServerFinhack();
//        createPost();
//        getPost();
//        getComments();
    }

    private void testConnectorServerFinhack() {
        ConnectorFinhackAPI connectorFinhackAPI = MyRetrofit.createService(ConnectorFinhackAPI.BASE_URL, ConnectorFinhackAPI.class);
        Map<String, String> fields = new HashMap<>();
        fields.put("CLIENTID", "41ab1463-2c7b-4c8e-b16a-5aeed15c813c");
        fields.put("CLIENTSECRET", "c2299172-d895-476c-bad3-c698155ada26");
        fields.put("APIKEY", "8555c52f-7c1f-42ec-9671-554dd6753e46");
        fields.put("APISECRET", "792a695b-3b29-4ae0-b977-0dd87e114b15");
        fields.put("HOSTGLOBAL", "https://sandbox.bca.co.id");
        fields.put("METHODGLOBAL", "GET");
        fields.put("PATHGLOBAL", "/banking/v3/corporates/BCAAPI2016/accounts/0201245680/statements?EndDate=2016-09-01&StartDate=2016-09-01");
        fields.put("BODYGLOBAL", "");

        Call<ResponseBody> call = connectorFinhackAPI.getResponseJSON(fields);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                //WITHOUT OKHTTP3
//                Log.e("UploadResponse>>>", response.body().toString());
                //WITH OKHTTP3
                try {
                    Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG).show();
                    Log.e("UploadResponse>>>", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();

            }
        });

    }

    private void createPost() {
        JSONPlaceHolderAPI jsonPlaceHolderAPI = MyRetrofit.createService(JSONPlaceHolderAPI.BASE_URL, JSONPlaceHolderAPI.class);
        Post post = new Post("My First Post", "This is my first POST", 23);
        //OR
        Map<String, String> fields = new HashMap<>();
        fields.put("userId", "23");
        fields.put("title", "My Second Post");
        fields.put("body", "This is my Second POST");

        Call<Post> call = jsonPlaceHolderAPI.createPost(fields);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                Post postResponse = response.body();
//                TextView x = findViewById(R.id.txtLogin);
                EditText xx = findViewById(R.id.txtEmail);
//                x.setText(String.valueOf(response.code()));
                xx.setText(String.valueOf(postResponse.getTitle()));

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getPost() {
        JSONPlaceHolderAPI jsonPlaceHolderAPI = MyRetrofit.createService(JSONPlaceHolderAPI.BASE_URL, JSONPlaceHolderAPI.class);

//        Call<List<Post>> call = jsonPlaceHolderAPI.getListData();
        Call<Post> call = jsonPlaceHolderAPI.getListData(1);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                Post lData = response.body();
                EditText x = findViewById(R.id.txtEmail);
                x.setText(String.valueOf(lData.getTitle()));

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getComments() {
        JSONPlaceHolderAPI jsonPlaceHolderAPI = MyRetrofit.createService(JSONPlaceHolderAPI.BASE_URL, JSONPlaceHolderAPI.class);

        Call<List<Comment>> call = jsonPlaceHolderAPI.getComments(1);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                List<Comment> lData = response.body();
//                TextView x = findViewById(R.id.txtLogin);
//                x.setText(String.valueOf(lData.get(2).getEmail()));

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();
            }
        });

    }

    //In doLogin()
//        LoginParam param = new LoginParam("febry.wicaksono@skorpoints.com", "skor1234");
//        loginReq = endpoint.login(param.getHeader(), param.getFormParams());
//        loginReq.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                LoginResponse loginResponse = response.body();
//
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//
//            }
//        });
}
