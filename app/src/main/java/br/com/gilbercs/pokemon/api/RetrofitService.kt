package br.com.gilbercs.pokemon.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    //url p/ API pokemon
    private val base_url = "https://pokeapi.co/api/v2/"
    //Create
    val retrofit = Retrofit.Builder()
        .baseUrl(base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    //create class generica
    fun <T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}