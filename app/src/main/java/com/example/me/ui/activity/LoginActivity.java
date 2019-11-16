package com.example.me.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alamkanak.weekview.WeekViewEvent;
import com.example.me.R;
import com.example.me.dao.api.Comment;
import com.example.me.dao.api.Post;
import com.example.me.dao.calendar.BasicActivity;
import com.example.me.dao.general.ListAPI;
import com.example.me.dao.general.MyConstanta;
import com.example.me.network.connectorAPI.ConnectorFinhackAPI;
import com.example.me.network.connectorAPI.JSONPlaceHolderAPI;
import com.example.me.network.retrofit.MyRetrofit;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.util.ArrayList;
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
//              API
        hitAPI();

//        Login
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                TextInputEditText txtEmail = findViewById(R.id.txtEmail);
                BasicActivity.intRepeat = 0;
                MyConstanta.events = new ArrayList<WeekViewEvent>();
                if (txtEmail.getText().toString().equalsIgnoreCase("parent")) {
                    MyConstanta.isParent = true;
                } else {
                    MyConstanta.isParent = false;
                }
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);

                Toast.makeText(getApplicationContext(), "Login Sucessfull", Toast.LENGTH_LONG).show();


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


    private void hitAPI() {
        ListAPI listAPI = new ListAPI();
        listAPI.WalletUserRegistration();
//        getCurrency();
//        createPaymentSakuku();
//        testConnectorServerFinhack();
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
    //POST
    private void createPaymentSakuku() {
        ConnectorFinhackAPI connectorFinhackAPI = MyRetrofit.createService(ConnectorFinhackAPI.BASE_URL, ConnectorFinhackAPI.class);
        Map<String, String> fields = new HashMap<>();
        fields.put("CLIENTID", "41ab1463-2c7b-4c8e-b16a-5aeed15c813c");
        fields.put("CLIENTSECRET", "c2299172-d895-476c-bad3-c698155ada26");
        fields.put("APIKEY", "8555c52f-7c1f-42ec-9671-554dd6753e46");
        fields.put("APISECRET", "792a695b-3b29-4ae0-b977-0dd87e114b15");
        fields.put("HOSTGLOBAL", "https://sandbox.bca.co.id");
        fields.put("METHODGLOBAL", "POST");
        fields.put("PATHGLOBAL", "/sakuku-commerce/payments");
        fields.put("BODYGLOBAL", "{ \"MerchantID\":\"89000\", \"MerchantName\":\"Merchant One\", \"Amount\":\"100.22\", \"Tax\":\"0.0\", \"TransactionID\":\"156479\", \"CurrencyCode\":\"IDR\", \"RequestDate\":\"2015-04-29T09:54:00.234+07:00\", \"ReferenceID\":\"123465798\" }");

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
        Log.e("LEWAAAT>>>", "hai");


    }

    //GET
    private void getCurrency() {
        ConnectorFinhackAPI connectorFinhackAPI = MyRetrofit.createService(ConnectorFinhackAPI.BASE_URL, ConnectorFinhackAPI.class);
        Map<String, String> fields = new HashMap<>();
        fields.put("CLIENTID", "41ab1463-2c7b-4c8e-b16a-5aeed15c813c");
        fields.put("CLIENTSECRET", "c2299172-d895-476c-bad3-c698155ada26");
        fields.put("APIKEY", "8555c52f-7c1f-42ec-9671-554dd6753e46");
        fields.put("APISECRET", "792a695b-3b29-4ae0-b977-0dd87e114b15");
        fields.put("HOSTGLOBAL", "https://sandbox.bca.co.id");
//        fields.put("HOSTGLOBAL", "https://api.finhacks.id");
        fields.put("METHODGLOBAL", "GET");
//        fields.put("PATHGLOBAL", "/ewallet/customers/80173/081234567890");
        fields.put("PATHGLOBAL", "/sakuku-commerce/payments/89000/0FE117D539DF610FE0540021281A5568");
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
        Log.e("LEWAAAT>>>", "hai");


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
//            public void onResponse(Call<LoginResponse> call, MainTransaction<LoginResponse> response) {
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
