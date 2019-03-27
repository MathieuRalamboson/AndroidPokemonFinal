package com;

import com.model.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestPokemonApi {

    @GET("pokemon")
    Call<RestPokemonResponse> getListPokemon();
}
