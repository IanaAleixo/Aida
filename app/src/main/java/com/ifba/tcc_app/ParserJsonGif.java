package com.ifba.tcc_app;

import com.ifba.tcc_app.model.Gif;
import com.ifba.tcc_app.model.ImagemGif;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParserJsonGif {
    public static Gif getGif(String data) throws JSONException {
        Gif gif = new Gif();

        // We create out JSONObject from the data
        JSONObject jObj = new JSONObject(data);

        // We start extracting the info
        ImagemGif img = new ImagemGif();

        return gif;
    }

    private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
        JSONObject subObj = jObj.getJSONObject(tagName);
        return subObj;
    }

    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

    private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
        return (float) jObj.getDouble(tagName);
    }

    private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getInt(tagName);
    }
}
