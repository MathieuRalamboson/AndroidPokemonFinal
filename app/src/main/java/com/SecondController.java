package com;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.model.Pokemon;
import com.model.RestPokemonResponse;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondController {

    private SecondActivity activity;

    public SecondController(SecondActivity activity) {
        this.activity = activity;
    }

    public void onStart(){

    }
}
