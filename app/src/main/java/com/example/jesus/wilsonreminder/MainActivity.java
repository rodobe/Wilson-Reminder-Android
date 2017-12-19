package com.example.jesus.wilsonreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.HashMap;

import client.HttpClient;
import client.OnHttpRequestComplete;
import client.Response;

public class MainActivity extends AppCompatActivity implements OnHttpRequestComplete{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*HttpClient client = new HttpClient(new OnHttpRequestComplete() {
            @Override
            public void onComplete(Response status) {

            }
        });
        client.excecute("http://wilsonreminder.heroku.com/users/register");*/
    }

    @Override
    public void onComplete(Response status) {

    }
    
}
