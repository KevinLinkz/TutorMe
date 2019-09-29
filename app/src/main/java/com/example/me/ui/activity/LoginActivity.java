package com.example.me.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.me.R;
import com.example.me.dao.Comment;
import com.example.me.dao.Post;
import com.example.me.network.connectorAPI.JSONPlaceHolderAPI;
import com.example.me.network.retrofit.MyRetrofit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Login
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                doLogin();

            Toast.makeText(getApplicationContext(),"Login Sucessfull",Toast.LENGTH_LONG).show();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        //Sign Up
        TextView lblSignUp = (TextView) findViewById(R.id.lnkSignUp);
        lblSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }


    private void doLogin() {

        createPost();
//        getPost();
//        getComments();
    }

    private  void createPost(){
        JSONPlaceHolderAPI jsonPlaceHolderAPI = MyRetrofit.createService(JSONPlaceHolderAPI.BASE_URL,JSONPlaceHolderAPI.class);
        Post post = new Post("My First Post","This is my first POST",23);
        //OR
        Map<String,String> fields = new HashMap<>();
        fields.put("userId","23");
        fields.put("title","My Second Post");
        fields.put("body","This is my Second POST");

        Call<Post> call = jsonPlaceHolderAPI.createPost(fields);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                Post postResponse = response.body();
                TextView x = findViewById(R.id.txtLogin);
                EditText xx = findViewById(R.id.txtEmail);
                x.setText(String.valueOf(response.code()));
                xx.setText(String.valueOf(postResponse.getTitle()));

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getPost(){
        JSONPlaceHolderAPI jsonPlaceHolderAPI = MyRetrofit.createService(JSONPlaceHolderAPI.BASE_URL,JSONPlaceHolderAPI.class);

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

    private void getComments(){
        JSONPlaceHolderAPI jsonPlaceHolderAPI = MyRetrofit.createService(JSONPlaceHolderAPI.BASE_URL,JSONPlaceHolderAPI.class);

        Call<List<Comment>> call = jsonPlaceHolderAPI.getComments(1);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                List<Comment> lData = response.body();
                TextView x = findViewById(R.id.txtLogin);
            x.setText(String.valueOf(lData.get(2).getEmail()));

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
