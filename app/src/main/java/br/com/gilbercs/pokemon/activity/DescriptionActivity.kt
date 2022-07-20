package br.com.gilbercs.pokemon.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.gilbercs.pokemon.databinding.ActivityDescriptionBinding

class DescriptionActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDescriptionBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}