package com.example.me.ui.network.param;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public class LoginParam extends ParamMaster {

    private String username, password;

    public LoginParam(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @NonNull
    @Override
    protected Map<String, String> requestParams() {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        return map;
    }

    @Nullable
    @Override
    protected Map<String, String> header() {
        Map<String, String> map = new HashMap<>();
        map.put("USER-AGENT", "Skor/3 Android|Samsung|20|20");

        return map;
    }
}
