package com.example.me.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.me.R;
import com.example.me.ui.network.Endpoint;
import com.example.me.ui.network.RetrofitClient;
import com.example.me.ui.network.param.LoginParam;
import com.example.me.ui.network.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Call<LoginResponse> loginReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Login
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogin();
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

    private void doLogin(){
        Endpoint endpoint = RetrofitClient.createService(Endpoint.class);

        LoginParam param = new LoginParam("febry.wicaksono@skorpoints.com", "skor1234");
        loginReq = endpoint.login(param.getHeader(), param.getFormParams());
        loginReq.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}
