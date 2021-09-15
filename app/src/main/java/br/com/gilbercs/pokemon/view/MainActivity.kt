package br.com.gilbercs.pokemon.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import br.com.gilbercs.pokemon.R
import br.com.gilbercs.pokemon.adapter.AdapterPokemon
import br.com.gilbercs.pokemon.api.PokemonInterface
import br.com.gilbercs.pokemon.databinding.ActivityMainBinding
import br.com.gilbercs.pokemon.model.ModelPokemon
import br.com.gilbercs.pokemon.model.ModelPokemonRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var retrofit: Retrofit
    private lateinit var listaP: ArrayList<ModelPokemon>
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    companion object{
        val TAG = "POkemon"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        fectData()
    }

    private fun fectData() {
        val service: PokemonInterface = retrofit.create(PokemonInterface::class.java)
        val call: Call<ModelPokemonRepo> = service.getData()
        call.enqueue(object : Callback<ModelPokemonRepo>{
            override fun onResponse(
                call: Call<ModelPokemonRepo>,
                response: Response<ModelPokemonRepo>
            ) {
                if (response.isSuccessful){
                   response.body().let {
                       val modelPokemonRepo: ModelPokemonRepo = response.body()!!
                        listaP = modelPokemonRepo.getResult()
                       //for (i in 1.until(listaP.size)){
                       //val p: ModelPokemon = listaPokemon.get(i)
                       //Log.d(TAG,"Pokemon: ${p.name}")
                        //}
                       val layoutManager = GridLayoutManager(this@MainActivity, 3)
                       binding.idRecyclearview.layoutManager = layoutManager
                       //binding.idRecyclearview.setHasFixedSize(true)
                       binding.idRecyclearview.adapter =  AdapterPokemon(this@MainActivity, listaP)
                   }
                }else{
                    Log.d(TAG,"Erro onResponse: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<ModelPokemonRepo>, t: Throwable) {
                Log.d(TAG,"Erro no onFailure: ${t.localizedMessage}")
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_menu_description ->{
                val intent = Intent(this, DescriptionActivity::class.java)
                startActivity(intent)
            }
            R.id.id_menu_sair ->{
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}