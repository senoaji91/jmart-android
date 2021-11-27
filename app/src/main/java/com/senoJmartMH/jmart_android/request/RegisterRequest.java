package com.senoJmartMH.jmart_android.request;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import java.util.*;

public class RegisterRequest extends StringRequest {
    private static final String URL = "http://10.0.2.2:8080/account/login";
    private final Map<String, String> params;

    public RegisterRequest(String name, String email, String password, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, URL, listener, errorListener);
        params = new HashMap<>();
        params.put("name", name);
        params.put("email", email);
        params.put("password", password);
    }

    public Map<String, String> getParams(){
        return params;
    }
}
