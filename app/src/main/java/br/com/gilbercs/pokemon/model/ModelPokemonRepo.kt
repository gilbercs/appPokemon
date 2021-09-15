package br.com.gilbercs.pokemon.model

class ModelPokemonRepo {
    private lateinit var results: ArrayList<ModelPokemon>

    fun getResult(): ArrayList<ModelPokemon>{
        return  results
    }
}