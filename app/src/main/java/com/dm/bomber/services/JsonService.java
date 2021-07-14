package com.dm.bomber.services;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public abstract class JsonService extends SimpleBaseService {

    public JsonService(String url, String method) {
        super(url, method);
    }

    public JsonService(String url, String method, String requireCode) {
        super(url, method, requireCode);
    }

    public Request run() {
        RequestBody body = RequestBody.create(
                buildJson(), MediaType.parse("application/json"));

        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(url);
        requestBuilder.method(method, body);

        return buildRequest(requestBuilder);
    }

    public abstract String buildJson();
}