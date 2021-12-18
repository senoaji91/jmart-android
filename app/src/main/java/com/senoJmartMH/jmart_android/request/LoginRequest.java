package com.senoJmartMH.jmart_android.request;

/**
 * Class LoginRequest - Class untuk mendefine request user login
 *
 * @author Seno Aji Wicaksono
 * @version 18-12-2021
 */

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;


import java.util.HashMap;
import java.util.Map;

//Class for Login Requests
public class LoginRequest extends StringRequest{
    private static final String URL = "http://10.0.2.2:8080/account/login";
    private Map<String, String> params;

    public LoginRequest(String email, String password, Response.Listener<String> listener, Response.ErrorListener errorListener){
        super(Method.POST, URL, listener, errorListener);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }
    public Map<String, String> getParams(){
        return params;
    }
}
