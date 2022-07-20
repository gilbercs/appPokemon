package br.com.gilbercs.pokemon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.gilbercs.pokemon.R
import br.com.gilbercs.pokemon.data.model.ModelPokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_adapter_pokemon.view.*

class AdapterPokemon(private val context: Context, private val listPokemonA: ArrayList<ModelPokemon>) : RecyclerView.Adapter<AdapterPokemon.ViewHolder>(){
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindData(modelPokemon: ModelPokemon) {
            //Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png").into(itemView.id_imagen_pokemon)
            itemView.id_name_pokemon.text = modelPokemon.name
            //Glide.with(context)
                //.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png")
                //.into(itemView.id_imagen_pokemon)


        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(
           LayoutInflater.from(context).inflate(R.layout.activity_adapter_pokemon,parent,false)
       )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val idImg: Int = position + 1
        holder.bindData(listPokemonA.get(position))
        Picasso.get()
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$idImg.png")
            .into(holder.itemView.id_imagen_pokemon)
    }

    override fun getItemCount(): Int {
        return listPokemonA.size
    }

    fun adicionarLista(listaP: ArrayList<ModelPokemon>){
         listPokemonA.addAll(listaP)
        notifyDataSetChanged()
    }

}