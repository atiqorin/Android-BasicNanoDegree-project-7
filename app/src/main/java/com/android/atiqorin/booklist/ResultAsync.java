package com.android.atiqorin.booklist;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by atiqorin on 7/4/16.
 */
public class ResultAsync extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        URL Url;
        HttpURLConnection connection;
        String Result = "";
        try {
            Url = new URL(params[0]);
            connection = (HttpURLConnection) Url.openConnection();
            InputStream in = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int status = ((HttpURLConnection) connection).getResponseCode();
            if (status == 204) {
                return "Error";
            }
            int data = reader.read();
            while (data != -1) {
                char curent = (char) data;
                Result += curent;
                data = reader.read();
            }
            return Result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result;
    }
}
