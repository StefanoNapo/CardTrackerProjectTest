package com.example.cardTrackerProject.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView

import androidx.activity.viewModels

import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardTrackerProject.databinding.ActivityMainBinding
import com.example.cardTrackerProject.ui.viewmodel.CardViewModel
import com.example.cardTrackerProject.ui.viewmodel.RecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

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
                layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
            }
        }

        cardViewModel.cardSearch.observe(this) {

            recyclerAdapter.submitList(it)

        }

        var spellSelected: Boolean = false
        var effMonSelected: Boolean = false
        var norMonSelected: Boolean = false
        var trapSelected: Boolean = false


        binding.checkBox.setOnClickListener() {
            spellSelected = binding.checkBox.isChecked

        }


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                return false
            }

            private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
            private var searchJob: Job? = null

            override fun onQueryTextChange(newText: String?): Boolean {
                searchJob?.cancel()
                searchJob = coroutineScope.launch {
                    newText?.let {
                        delay(350)
                        if (newText.length > 2 && spellSelected) {

                            cardViewModel.cardSearchWithType(newText, "Spell Card")
                        } else if (newText.length > 2) {
                            cardViewModel.cardSearch(newText)
                        }
                    }
                }


                return false
            }

        })



        cardViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })


    }


}