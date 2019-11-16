package com.example.me.dao.general;

import android.util.Log;

import com.example.me.network.connectorAPI.ConnectorFinhackAPI;
import com.example.me.network.retrofit.MyRetrofit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListAPI {
    private String CLIENT_ID = "77a6f272-b0e4-4ca6-93dd-d9664e353322";
    private String CLIENTSECRET = "a6546684-6689-45cd-9d97-2fca6e28884c";
    private String APIKEY = "fd8bff1f-1a68-49da-a185-f12819f0b183";
    private String APISECRET = "5f45e1d7-bddb-42cd-a43a-f2f155348eee";
    private String HOSTGLOBAL = "https://api.finhacks.id";
    private String CORPORATE_ID = "finhacks05";
    private String ACCOUNT1 = "8220000223";
    private String ACCOUNT2 = "8220000321";
    private String COMPANY_CODE = "88805";

    public ListAPI() {
    }

    public void testConnectorServerFinhack() {
        ConnectorFinhackAPI connectorFinhackAPI = MyRetrofit.createService(ConnectorFinhackAPI.BASE_URL, ConnectorFinhackAPI.class);
        Map<String, String> fields = new HashMap<>();
        fields.put("CLIENTID", CLIENT_ID);
        fields.put("CLIENTSECRET", CLIENTSECRET);
        fields.put("APIKEY", APIKEY);
        fields.put("APISECRET", APISECRET);
        fields.put("HOSTGLOBAL", HOSTGLOBAL);
        fields.put("METHODGLOBAL", "GET");
        fields.put("PATHGLOBAL", "/banking/v3/corporates/"+CORPORATE_ID+"/accounts/"+ACCOUNT1);
        fields.put("BODYGLOBAL", "");

        Call<ResponseBody> call = connectorFinhackAPI.getResponseJSON(fields);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (!response.isSuccessful()) {
//                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                try {
//                    Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG).show();
                    Log.e("UploadResponse>>>", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("UploadResponse>>>", "Failed");
//                                    Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void WalletUserRegistration() {
        Log.e("UploadResponse>>>", "WalletUserRegistration");
        ConnectorFinhackAPI connectorFinhackAPI = MyRetrofit.createService(ConnectorFinhackAPI.BASE_URL, ConnectorFinhackAPI.class);
        Map<String, String> fields = new HashMap<>();
        fields.put("CLIENTID", CLIENT_ID);
        fields.put("CLIENTSECRET", CLIENTSECRET);
        fields.put("APIKEY", APIKEY);
        fields.put("APISECRET", APISECRET);
        fields.put("HOSTGLOBAL", HOSTGLOBAL);
        fields.put("METHODGLOBAL", "POST");
        fields.put("PATHGLOBAL", "/ewallet/customers");
        fields.put("BODYGLOBAL", "{" +
                "    \"CustomerName\": \"Kevin Hertanto\"," +
                "    \"DateOfBirth\": \"1993-05-24\"," +
                "    \"PrimaryID\": \"00001\"," +
                "    \"MobileNumber\": \"082295869717\"," +
                "    \"EmailAddress\": \"dummy1@bca.co.id\"," +
                "    \"CompanyCode\": \"88805\"," +
                "    \"CustomerNumber\": \"00001\"," +
                "    \"IDNumber\": \"000000000001\"" +
                "}");

        Call<ResponseBody> call = connectorFinhackAPI.getResponseJSON(fields);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (!response.isSuccessful()) {
//                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                try {
//                    Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG).show();
                    Log.e("UploadResponse>>>", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("UploadResponse>>>", "Failed");
//                                    Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();

            }
        });
    }




    //POST
    public void createPaymentSakuku() {
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
//                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                //WITHOUT OKHTTP3
//                Log.e("UploadResponse>>>", response.body().toString());
                //WITH OKHTTP3
                try {
//                    Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG).show();
                    Log.e("UploadResponse>>>", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();

            }
        });
        Log.e("LEWAAAT>>>", "hai");


    }

    //GET
    public void getCurrency() {
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
//                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
                }
                //WITHOUT OKHTTP3
//                Log.e("UploadResponse>>>", response.body().toString());
                //WITH OKHTTP3
                try {
//                    Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_LONG).show();
                    Log.e("UploadResponse>>>", response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();

            }
        });
        Log.e("LEWAAAT>>>", "hai");


    }

//    private void createPost() {
//        JSONPlaceHolderAPI jsonPlaceHolderAPI = MyRetrofit.createService(JSONPlaceHolderAPI.BASE_URL, JSONPlaceHolderAPI.class);
//        Post post = new Post("My First Post", "This is my first POST", 23);
//        //OR
//        Map<String, String> fields = new HashMap<>();
//        fields.put("userId", "23");
//        fields.put("title", "My Second Post");
//        fields.put("body", "This is my Second POST");
//
//        Call<Post> call = jsonPlaceHolderAPI.createPost(fields);
//        call.enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//                if (!response.isSuccessful()) {
//                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
//                }
//                Post postResponse = response.body();
////                TextView x = findViewById(R.id.txtLogin);
//                EditText xx = findViewById(R.id.txtEmail);
////                x.setText(String.valueOf(response.code()));
//                xx.setText(String.valueOf(postResponse.getTitle()));
//
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
//    private void getPost() {
//        JSONPlaceHolderAPI jsonPlaceHolderAPI = MyRetrofit.createService(JSONPlaceHolderAPI.BASE_URL, JSONPlaceHolderAPI.class);
//
////        Call<List<Post>> call = jsonPlaceHolderAPI.getListData();
//        Call<Post> call = jsonPlaceHolderAPI.getListData(1);
//        call.enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//                if (!response.isSuccessful()) {
//                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
//                }
//                Post lData = response.body();
//                EditText x = findViewById(R.id.txtEmail);
//                x.setText(String.valueOf(lData.getTitle()));
//
//            }
//
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//
//                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
//    private void getComments() {
//        JSONPlaceHolderAPI jsonPlaceHolderAPI = MyRetrofit.createService(JSONPlaceHolderAPI.BASE_URL, JSONPlaceHolderAPI.class);
//
//        Call<List<Comment>> call = jsonPlaceHolderAPI.getComments(1);
//        call.enqueue(new Callback<List<Comment>>() {
//            @Override
//            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
//                if (!response.isSuccessful()) {
////                    Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_LONG).show();
//                }
//                List<Comment> lData = response.body();
////                TextView x = findViewById(R.id.txtLogin);
////                x.setText(String.valueOf(lData.get(2).getEmail()));
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Comment>> call, Throwable t) {
//
////                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_LONG).show();
//            }
//        });
//
//    }

}
