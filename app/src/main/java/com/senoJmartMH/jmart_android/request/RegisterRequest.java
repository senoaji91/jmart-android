package com.senoJmartMH.jmart_android.request;

/**
 * Class RegisterRequest - Class untuk mendefine request user register
 *
 * @author Seno Aji Wicaksono
 * @version 18-12-2021
 */
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

//Class for Register Requests
public class RegisterRequest extends StringRequest{
    private static final String URL = "http://10.0.2.2:8080/account/register";
    private Map<String, String> params;

    public RegisterRequest(String name, String email, String password, Response.Listener<String> listener, Response.ErrorListener errorListener){
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
