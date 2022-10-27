package com.example.mvvmexample.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.mvvmexample.databinding.ActivityMainBinding
import com.example.mvvmexample.ui.viewmodel.CardViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val cardViewModel : CardViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cardViewModel.onCreate()


        cardViewModel.cardModel.observe(this, Observer { currentCard ->
            binding.tvCardName.text = currentCard.name
            binding.tvDesc.text = currentCard.desc
            val cardLink : String? = currentCard.cardImages?.get(0)?.imageUrl

            Picasso.get().load(cardLink).into(binding.imageView)

        })

        cardViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        binding.viewContainer.setOnClickListener{ cardViewModel.randomCard()}

    }
}