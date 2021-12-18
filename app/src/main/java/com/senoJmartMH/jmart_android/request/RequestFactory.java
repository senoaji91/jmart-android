package com.senoJmartMH.jmart_android.request;

/**
 * Class RequestFactory - class untuk mendefine back end yang digunakan
 *
 * @author Seno Aji Wicaksono
 * @version 18-12-2021
 */

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class RequestFactory {
    private static final String URL_FORMAT_ID = "http://10.0.2.2:8080/%s/%d";
    private static final String URL_FORMAT_PAGE = "http://10.0.2.2:8080/%s/page?page=%s&pageSize=&s";

    public static StringRequest getById(String parentURI,
                                        int id,
                                        Response.Listener<String> listener,
                                        Response.ErrorListener errorListener)
    {
        String url = String.format(URL_FORMAT_ID, parentURI, id);
        return new StringRequest(Request.Method.GET, url, listener, errorListener);
    }

    public static StringRequest getPage(String parentURI,
                                        int page,
                                        int pageSize,
                                        Response.Listener<String> listener,
                                        Response.ErrorListener errorListener)
    {
        String url = String.format(URL_FORMAT_PAGE, parentURI, page, pageSize);
        return new StringRequest(Request.Method.GET, url, listener, errorListener);
    }
}
