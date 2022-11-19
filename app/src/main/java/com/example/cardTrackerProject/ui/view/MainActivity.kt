package com.example.cardTrackerProject.ui.view

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

import androidx.activity.viewModels
import androidx.core.view.get

import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardTrackerProject.R
import com.example.cardTrackerProject.components.SearchOptionsDialog
import com.example.cardTrackerProject.databinding.ActivityMainBinding
import com.example.cardTrackerProject.ui.viewmodel.CardViewModel
import com.example.cardTrackerProject.ui.viewmodel.RecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_layout.view.*
import kotlinx.android.synthetic.main.search_options_popup.*
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


        val collectionsSpin = arrayOf("Every Card", "My Collection","For Sale Collection", "Competitive Collection")

        val collectionSpinner : Spinner = binding.collectionsSpinner

        var collectionSelected : String

        collectionSpinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, collectionsSpin)

        collectionSpinner.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                collectionSelected = collectionSpinner.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }




        binding.searchButton.setOnClickListener() {
            val dialog = SearchOptionsDialog()

            dialog.show(supportFragmentManager, "searchOptionDialog")


            //Averiguar como hacer para poder inicializar los valores de los spinner en el search dialog
            //y como hacer funcionar el botón cerrar

/*

                    closeButton.setOnClickListener() {
            dismiss()
        }
                    val cardTypeOptions = arrayOf(
            "Effect Monster",
            "Flip Effect Monster",
            "Flip Tuner Effect Monster",
            "Gemini Monster",
            "Normal Monster",
            "Normal Tuner Monster",
            "Pendulum Effect Monster",
            "Pendulum Flip Effect Monster",
            "Pendulum Normal Monster",
            "Pendulum Tuner Effect Monster",
            "Ritual Effect Monster",
            "Ritual Monster",
            "Skill Card",
            "Spell Card",
            "Spirit Monster",
            "Toon Monster",
            "Trap Card",
            "Tuner Monster",
            "Union Effect Monster",
            "Fusion Monster",
            "Link Monster",
            "Pendulum Effect Fusion Monster",
            "Synchro Monster",
            "Synchro Pendulum Effect Monster",
            "Synchro Tuner Monster",
            "XYZ Monster",
            "XYZ Pendulum Effect Monster",
            "Spell Card",
            "Trap Card")

            val cardTypeSpinner : Spinner = findViewById(R.id.cardTypeSpinner)

            var cardTypeSelected : String

            cardTypeSpinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cardTypeOptions)

            cardTypeSpinner.onItemSelectedListener = object :AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    cardTypeSelected = cardTypeSpinner[p2].toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                }

            }

*/
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