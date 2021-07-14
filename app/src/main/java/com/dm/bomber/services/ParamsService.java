package com.dm.bomber.services;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

public abstract class ParamsService extends SimpleBaseService {

    public ParamsService(String url) {
        super(url);
    }

    public ParamsService(String url, String method) {
        super(url, method);
    }

    public ParamsService(String url, String method, String requireCode) {
        super(url, method, requireCode);
    }

    public Request run() {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(url).newBuilder();
        buildParams(httpBuilder);

        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(httpBuilder.build().toString());

        if (method != null)
            requestBuilder.method(method, RequestBody.create("", null));

        return buildRequest(requestBuilder);
    }

    public abstract void buildParams(HttpUrl.Builder builder);
}