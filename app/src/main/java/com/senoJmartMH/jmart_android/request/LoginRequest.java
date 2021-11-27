package com.senoJmartMH.jmart_android.request;

import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import java.util.*;

public class LoginRequest extends StringRequest {
    private static final String URL = "http://10.0.2.2:8080/account/login";
    private final Map<String, String> params;

    public LoginRequest(String email, String password, Response.Listener<String> listener, Response.ErrorListener errorListener)
    {
        super(Request.Method.POST, URL, listener, errorListener);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }
}
