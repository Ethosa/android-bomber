package com.dm.bomber.services;

import org.json.JSONException;
import org.json.JSONObject;

public class GloriaJeans extends JsonService {

    public GloriaJeans() {
        super("https://www.gloria-jeans.ru/phone-verification/send-code/registration", POST);
    }

    @Override
    public String buildJson() {
        JSONObject json = new JSONObject();

        try {
            json.put("phoneNumber", "+" + getFormattedPhone());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();
    }
}