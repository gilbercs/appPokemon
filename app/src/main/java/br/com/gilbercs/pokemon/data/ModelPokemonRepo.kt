package br.com.gilbercs.pokemon.data

import br.com.gilbercs.pokemon.data.model.ModelPokemon

class ModelPokemonRepo {
    private lateinit var results: ArrayList<ModelPokemon>

    fun getResult(): ArrayList<ModelPokemon>{
        return  results
    }
}