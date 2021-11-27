package com.senoJmartMH.jmart_android.request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.ErrorListener;

public class RequestFactory {
    public final String URL_FORMAT_ID = "http://10.2.2.2:8080/%s/%d";
    public final String URL_FORMAT_PAGE = "http://10.2.2:8080/%s/page";
    public static StringRequest getById
            (
                    String parentURI,
                    int id,
                    Response.Listener<String> listener,
                    Response.ErrorListener errorListener
            )
    {
        String url = String.format("http://10.2.2.2:8080/%s/%d", parentURI, id);
        return new StringRequest(Request.Method.GET, url, listener, errorListener);
    }
    public static StringRequest getPage
            (
                    String parentURI,
                    int page,
                    int pageSize,
                    Response.Listener<String> listener,
                    Response.ErrorListener errorListener
            )
    {
        String url = String.format("http://10.2.2:8080/%s/page", parentURI);
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("pageSize", String.valueOf(pageSize));
        return new StringRequest(Request.Method.GET, url, listener, errorListener) {
            public Map<String, String> getParams() { return params; }
        };
    }
}

