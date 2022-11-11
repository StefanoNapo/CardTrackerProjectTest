package com.example.cardTrackerProject.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.LayoutInflaterCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cardTrackerProject.data.CardRepository
import com.example.cardTrackerProject.data.database.CardDatabase
import com.example.cardTrackerProject.data.database.dao.CardDao
import com.example.cardTrackerProject.databinding.ActivityMainBinding
import com.example.cardTrackerProject.domain.GetCardSearchUseCase
import com.example.cardTrackerProject.ui.viewmodel.CardViewModel
import com.example.cardTrackerProject.ui.viewmodel.RecyclerAdapter
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private val cardViewModel: CardViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        cardViewModel.onCreate()

        binding.searchButton.setOnClickListener() {

        }

        binding.addCardsButton.setOnClickListener() {

        }
        val recyclerAdapter = RecyclerAdapter()

        binding.apply {
            cardRecyclerView.apply {
                adapter = recyclerAdapter
                layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
            }
        }

        cardViewModel.cardSearch.observe(this){
            recyclerAdapter.submitList(it)

        }

        cardViewModel.cardSearch()

        /*      cardViewModel.cardModel.observe(this, Observer { currentCard ->
                  binding.tvCardName.text = currentCard.name
                  binding.tvDesc.text = currentCard.desc
                  val cardLink : String? = currentCard.cardImages?.get(0)?.imageUrlSmall

                  Picasso.get().load(cardLink).into(binding.imageView)

              })

              cardViewModel.isLoading.observe(this, Observer {
                  binding.progress.isVisible = it
              })

              binding.viewContainer.setOnClickListener{ cardViewModel.randomCard()}
        */
    }
}