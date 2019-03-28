package com;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.model.Pokemon;
import com.model.RestPokemonResponse;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private MainActivity activity;
    private SecondActivity activity2;



    public MainController(MainActivity mainActivity) {
        this.activity = mainActivity;
    }
    public MainController(SecondActivity secondActivity) { this.activity2 = secondActivity; }

    public void onStart(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestPokemonApi restPokemonApi = retrofit.create(RestPokemonApi.class);
        Call<RestPokemonResponse> call = restPokemonApi.getListPokemon();
        call.enqueue(new Callback<RestPokemonResponse>() {
            @Override
            public void onResponse(Call<RestPokemonResponse> call,
                                   Response<RestPokemonResponse> response) {

                Log.d("Check", "Api Respond");
                RestPokemonResponse restPokemonResponse = response.body();
                ArrayList<Pokemon> listPokemon = restPokemonResponse.getResults();
                activity.showList(listPokemon);
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                Log.d("ERROR", "Api Error");
            }
        });
    }
}