package br.com.gilbercs.pokemon.api

import br.com.gilbercs.pokemon.model.ModelPokemonRepo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonInterface {
    @GET("pokemon")
    fun getData(): Call<ModelPokemonRepo>
}