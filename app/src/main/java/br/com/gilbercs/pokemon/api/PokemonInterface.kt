package br.com.gilbercs.pokemon.api

import br.com.gilbercs.pokemon.data.ModelPokemonRepo
import retrofit2.Call
import retrofit2.http.GET

interface PokemonInterface {
    @GET("pokemon")
    fun getData(): Call<ModelPokemonRepo>
}