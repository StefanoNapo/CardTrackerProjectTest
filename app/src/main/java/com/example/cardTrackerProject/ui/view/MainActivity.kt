package com.example.cardTrackerProject.ui.view

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isNotEmpty
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cardTrackerProject.data.database.dao.CardDao
import com.example.cardTrackerProject.databinding.ActivityMainBinding
import com.example.cardTrackerProject.domain.model.Card
import com.example.cardTrackerProject.ui.CardTextCheckedListener
import com.example.cardTrackerProject.ui.DialogCommunicator
import com.example.cardTrackerProject.ui.components.SearchOptionsDialog
import com.example.cardTrackerProject.ui.viewmodel.CardViewModel
import com.example.cardTrackerProject.ui.viewmodel.RecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_layout.view.*
import kotlinx.coroutines.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), DialogCommunicator, CardTextCheckedListener {

    private lateinit var binding: ActivityMainBinding

    private val cardViewModel: CardViewModel by viewModels()

    var cardTypeChoose: String = ""

    var monsterTypeChoose: String = ""

    var attrChoose: String = ""

    var atkChoose: Int? = null

    var defChoose: Int? = null

    var lvlChoose: Int? = null

    var checkedCards = arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        cardViewModel.onCreate()


        val collectionsSpin =
            arrayOf("Every Card", "My Collection", "For Sale Collection", "Competitive Collection")

        val collectionSpinner: Spinner = binding.collectionsSpinner

        var collectionSelected: String

        collectionSpinner.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, collectionsSpin)

        //Here we use an item listener to know what collection we show to the user

        collectionSpinner.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                collectionSelected = collectionSpinner.selectedItem.toString()
                Toast.makeText(baseContext, "Now showing $collectionSelected", Toast.LENGTH_SHORT)
                    .show()

                if (collectionSelected !== "Every Card") {
                    binding.modifyCardsBtn.isVisible = true
                    binding.addCardsButton.isVisible = false
                    binding.addCollSpinner.isVisible = false
                }
                else {
                    binding.modifyCardsBtn.isVisible = false
                    binding.addCardsButton.isVisible = true
                    binding.addCollSpinner.isVisible = true
                }

                cardViewModel.cardSearch.value = null
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }

        val dialog = SearchOptionsDialog()


        binding.searchButton.setOnClickListener() {

            dialog.show(supportFragmentManager, "searchOptionDialog")

        }


        val addCollSpin =
            arrayOf("My Collection", "For Sale Coll", "Competitive Coll")

        val addCollSpinner: Spinner = binding.addCollSpinner

        var addCollSelected: String

        addCollSpinner.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, addCollSpin)

        //Here we use an item listener to know what collection the user wants to add the selected cards

        addCollSpinner.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                addCollSelected = addCollSpinner.selectedItem.toString()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }

        binding.addCardsButton.setOnClickListener() {
            Toast.makeText(baseContext, "Cards added to collection", Toast.LENGTH_LONG).show()
            Toast.makeText(baseContext, "Added this cards$checkedCards", Toast.LENGTH_LONG).show()
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

        recyclerAdapter.cardTextCheckedListener(this)

        //Conseguir como hacer para saber que row se checkea y como adjuntar todos los nombres
        if (cardRecyclerView.isNotEmpty()) {

            val cardCheckBox = binding.cardRecyclerView.cardCheckBox



            cardCheckBox.setOnCheckedChangeListener { _, isChecked ->
                    val position = cardCheckBox.verticalScrollbarPosition
                    val cardName = binding.cardRecyclerView.cardName.text.toString()
                    val cardSelectedName = arrayOf(cardName)

                    Toast.makeText(
                        baseContext,
                        "Cards added to collection$cardSelectedName",
                        Toast.LENGTH_LONG
                    ).show()

                }
            }


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                return false
            }

            private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
            private var searchJob: Job? = null


            //Card Searcher with every possible combinations calling viewModel functions with the search parameters
            //Going from every variable use for the search (6 + text in searchView) to none (only searchView text)
            override fun onQueryTextChange(newText: String?): Boolean {
                searchJob?.cancel()
                searchJob = coroutineScope.launch {
                    newText?.let {

                        if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank()
                            && atkChoose != null && defChoose != null && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithTAMTAtkDL(
                                newText,
                                cardTypeChoose,
                                attrChoose,
                                monsterTypeChoose,
                                atkChoose!!,
                                defChoose!!,
                                lvlChoose!!
                            )
                            //agregar funciones llamadas y funciones del Dao para cada tabla ¿convendra hacer un inner join?
                            //    para pedir por los id en comun de cada tabla con la tabla "cards_table"

                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank()
                            && atkChoose != null && defChoose != null
                        ) {

                            cardViewModel.cardSearchWithTAMTAtkD(
                                newText,
                                cardTypeChoose,
                                attrChoose,
                                monsterTypeChoose,
                                atkChoose!!,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank()
                            && atkChoose != null && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithTAMTAtkL(
                                newText,
                                cardTypeChoose,
                                attrChoose,
                                monsterTypeChoose,
                                atkChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank()
                            && defChoose != null && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithTAMTDL(
                                newText,
                                cardTypeChoose,
                                attrChoose,
                                monsterTypeChoose,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && attrChoose.isNotBlank() && atkChoose != null
                            && defChoose != null && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithTAAtkDL(
                                newText,
                                cardTypeChoose,
                                attrChoose,
                                atkChoose!!,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && atkChoose != null
                            && defChoose != null && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithTMTAtkDL(
                                newText,
                                cardTypeChoose,
                                monsterTypeChoose,
                                atkChoose!!,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank() && atkChoose != null
                            && defChoose != null && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithMTAAtkDL(
                                newText,
                                monsterTypeChoose,
                                attrChoose,
                                atkChoose!!,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank()
                            && atkChoose != null
                        ) {

                            cardViewModel.cardSearchWithTypeMonTypeAttrAtk(
                                newText,
                                cardTypeChoose,
                                monsterTypeChoose,
                                attrChoose,
                                atkChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank()
                            && defChoose != null
                        ) {

                            cardViewModel.cardSearchWithTypeMonTypeAttrDef(
                                newText,
                                cardTypeChoose,
                                monsterTypeChoose,
                                attrChoose,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank()
                            && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithTypeMonTypeAttrLvl(
                                newText,
                                cardTypeChoose,
                                monsterTypeChoose,
                                attrChoose,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && atkChoose != null
                            && defChoose != null
                        ) {

                            cardViewModel.cardSearchWithTypeMonTypeAtkDef(
                                newText,
                                cardTypeChoose,
                                monsterTypeChoose,
                                atkChoose!!,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && atkChoose != null
                            && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithTypeMonTypeAtkLvl(
                                newText,
                                cardTypeChoose,
                                monsterTypeChoose,
                                atkChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && defChoose != null
                            && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithTypeMonTypeDefLvl(
                                newText,
                                cardTypeChoose,
                                monsterTypeChoose,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && attrChoose.isNotBlank() && atkChoose != null
                            && defChoose != null
                        ) {

                            cardViewModel.cardSearchWithTypeAttrAtkDef(
                                newText,
                                cardTypeChoose,
                                attrChoose,
                                atkChoose!!,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && attrChoose.isNotBlank() && atkChoose != null
                            && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithTypeAttrAtkLvl(
                                newText,
                                cardTypeChoose,
                                attrChoose,
                                atkChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && attrChoose.isNotBlank() && defChoose != null
                            && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithTypeAttrDefLvl(
                                newText,
                                cardTypeChoose,
                                attrChoose,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && atkChoose != null && defChoose != null
                            && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithTypeAtkDefLvl(
                                newText,
                                cardTypeChoose,
                                atkChoose!!,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank() && atkChoose != null
                            && defChoose != null
                        ) {

                            cardViewModel.cardSearchWithMonTypeAttrAtkDef(
                                newText,
                                monsterTypeChoose,
                                attrChoose,
                                atkChoose!!,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank() && atkChoose != null
                            && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithMonTypeAttrAtkLvl(
                                newText,
                                monsterTypeChoose,
                                attrChoose,
                                atkChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank() && defChoose != null
                            && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithMonTypeAttrDefLvl(
                                newText,
                                monsterTypeChoose,
                                attrChoose,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && atkChoose != null && defChoose != null
                            && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithMonTypeAtkDefLvl(
                                newText,
                                monsterTypeChoose,
                                atkChoose!!,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && attrChoose.isNotBlank() && atkChoose != null && defChoose != null
                            && lvlChoose != null
                        ) {

                            cardViewModel.cardSearchWithAttrAtkDefLvl(
                                newText,
                                attrChoose,
                                atkChoose!!,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank()) {

                            cardViewModel.cardSearchWithTypeAttrMonType(
                                newText,
                                cardTypeChoose,
                                attrChoose,
                                monsterTypeChoose
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && atkChoose != null) {

                            cardViewModel.cardSearchWithTypeMonTypeAtk(
                                newText,
                                cardTypeChoose,
                                monsterTypeChoose,
                                atkChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && defChoose != null) {

                            cardViewModel.cardSearchWithTypeMonTypeDef(
                                newText,
                                cardTypeChoose,
                                monsterTypeChoose,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank() && lvlChoose != null) {

                            cardViewModel.cardSearchWithTypeMonTypeLvl(
                                newText,
                                cardTypeChoose,
                                monsterTypeChoose,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && attrChoose.isNotBlank() && atkChoose != null) {

                            cardViewModel.cardSearchWithTypeAttrAtk(
                                newText,
                                cardTypeChoose,
                                attrChoose,
                                atkChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && attrChoose.isNotBlank() && defChoose != null) {

                            cardViewModel.cardSearchWithTypeAttrDef(
                                newText,
                                cardTypeChoose,
                                attrChoose,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && attrChoose.isNotBlank() && lvlChoose != null) {

                            cardViewModel.cardSearchWithTypeAttrLvl(
                                newText,
                                cardTypeChoose,
                                attrChoose,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && atkChoose != null && defChoose != null) {

                            cardViewModel.cardSearchWithTypeAtkDef(
                                newText,
                                cardTypeChoose,
                                atkChoose!!,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && atkChoose != null && lvlChoose != null) {

                            cardViewModel.cardSearchWithTypeAtkLvl(
                                newText,
                                cardTypeChoose,
                                atkChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && defChoose != null && lvlChoose != null) {

                            cardViewModel.cardSearchWithTypeDefLvl(
                                newText,
                                cardTypeChoose,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank() && atkChoose != null) {

                            cardViewModel.cardSearchWithMonTypeAttrAtk(
                                newText,
                                monsterTypeChoose,
                                attrChoose,
                                atkChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank() && defChoose != null) {

                            cardViewModel.cardSearchWithMonTypeAttrDef(
                                newText,
                                monsterTypeChoose,
                                attrChoose,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank() && lvlChoose != null) {

                            cardViewModel.cardSearchWithMonTypeAttrLvl(
                                newText,
                                monsterTypeChoose,
                                attrChoose,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && atkChoose != null && defChoose != null) {

                            cardViewModel.cardSearchWithMonTypeAtkDef(
                                newText,
                                monsterTypeChoose,
                                atkChoose!!,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && atkChoose != null && lvlChoose != null) {

                            cardViewModel.cardSearchWithMonTypeAtkLvl(
                                newText,
                                monsterTypeChoose,
                                atkChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && defChoose != null && lvlChoose != null) {

                            cardViewModel.cardSearchWithMonTypeDefLvl(
                                newText,
                                monsterTypeChoose,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && attrChoose.isNotBlank() && atkChoose != null && defChoose != null) {

                            cardViewModel.cardSearchWithAttrAtkDef(
                                newText,
                                attrChoose,
                                atkChoose!!,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && attrChoose.isNotBlank() && atkChoose != null && lvlChoose != null) {

                            cardViewModel.cardSearchWithAttrAtkLvl(
                                newText,
                                attrChoose,
                                atkChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && attrChoose.isNotBlank() && defChoose != null && lvlChoose != null) {

                            cardViewModel.cardSearchWithAttrDefLvl(
                                newText,
                                attrChoose,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && atkChoose != null && defChoose != null && lvlChoose != null) {

                            cardViewModel.cardSearchWithAtkDefLvl(
                                newText,
                                atkChoose!!,
                                defChoose!!,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && monsterTypeChoose.isNotBlank()) {

                            cardViewModel.cardSearchWithTypeMonType(
                                newText,
                                cardTypeChoose,
                                monsterTypeChoose
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && attrChoose.isNotBlank()) {

                            cardViewModel.cardSearchWithTypeAttr(
                                newText,
                                cardTypeChoose,
                                attrChoose
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && attrChoose.isNotBlank()) {

                            cardViewModel.cardSearchWithMonTypeAttr(
                                newText,
                                monsterTypeChoose,
                                attrChoose
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && atkChoose != null) {

                            cardViewModel.cardSearchWithTypeAtk(
                                newText,
                                cardTypeChoose,
                                atkChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && defChoose != null) {

                            cardViewModel.cardSearchWithTypeDef(
                                newText,
                                cardTypeChoose,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank() && lvlChoose != null) {

                            cardViewModel.cardSearchWithTypeLvl(
                                newText,
                                cardTypeChoose,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && atkChoose != null) {

                            cardViewModel.cardSearchWithMonTypeAtk(
                                newText,
                                monsterTypeChoose,
                                atkChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && defChoose != null) {

                            cardViewModel.cardSearchWithMonTypeDef(
                                newText,
                                monsterTypeChoose,
                                defChoose!!
                            )
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank() && lvlChoose != null) {

                            cardViewModel.cardSearchWithMonTypeLvl(
                                newText,
                                monsterTypeChoose,
                                lvlChoose!!
                            )
                        } else if (newText.length > 2 && attrChoose.isNotBlank() && atkChoose != null) {

                            cardViewModel.cardSearchWithAttrAtk(newText, attrChoose, atkChoose!!)
                        } else if (newText.length > 2 && attrChoose.isNotBlank() && defChoose != null) {

                            cardViewModel.cardSearchWithAttrDef(newText, attrChoose, defChoose!!)
                        } else if (newText.length > 2 && attrChoose.isNotBlank() && lvlChoose != null) {

                            cardViewModel.cardSearchWithAttrLvl(newText, attrChoose, lvlChoose!!)
                        } else if (newText.length > 2 && defChoose != null && atkChoose != null) {

                            cardViewModel.cardSearchWithAtkDef(newText, defChoose!!, atkChoose!!)
                        } else if (newText.length > 2 && lvlChoose != null && atkChoose != null) {

                            cardViewModel.cardSearchWithAtkLvl(newText, lvlChoose!!, atkChoose!!)
                        } else if (newText.length > 2 && defChoose != null && lvlChoose != null) {

                            cardViewModel.cardSearchWithDefLvl(newText, defChoose!!, lvlChoose!!)
                        } else if (newText.length > 2 && cardTypeChoose.isNotBlank()) {

                            cardViewModel.cardSearchWithType(newText, cardTypeChoose)
                        } else if (newText.length > 2 && monsterTypeChoose.isNotBlank()) {

                            cardViewModel.cardSearchWithMonType(newText, monsterTypeChoose)
                        } else if (newText.length > 2 && attrChoose.isNotBlank()) {

                            cardViewModel.cardSearchWithAttr(newText, attrChoose)
                        } else if (newText.length > 2 && atkChoose != null) {

                            cardViewModel.cardSearchWithAtk(newText, atkChoose!!)
                        } else if (newText.length > 2 && defChoose != null) {

                            cardViewModel.cardSearchWithDef(newText, defChoose!!)
                        } else if (newText.length > 2 && lvlChoose != null) {

                            cardViewModel.cardSearchWithLvl(newText, lvlChoose!!)
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

    override fun getCardTypeSelected(cardTypeSelec: String) {
        cardTypeChoose = cardTypeSelec
    }

    override fun getMonsterTypeSelected(monsTypeSelec: String) {
        monsterTypeChoose = monsTypeSelec
    }

    override fun getAttrSelected(attrSelec: String) {
        attrChoose = attrSelec
    }

    override fun getAtkSelected(atkSelec: Int?) {
        atkChoose = atkSelec
    }

    override fun getDefSelected(defSelec: Int?) {
        defChoose = defSelec
    }

    override fun getLvlSelected(lvlSelec: Int?) {
        lvlChoose = lvlSelec
    }

    override fun getCardCheckedName(text: String) {
        if(text.isNotEmpty()) {
                checkedCards += text
            }
        else {
            checkedCards = checkedCards.filter { it != checkedCards.last() }.toTypedArray()
        }
        Toast.makeText(baseContext, "Added this cards" + checkedCards.contentToString(), Toast.LENGTH_LONG).show()
    }
//Necesito agregar/usar query para consultar lista de cartas y hacer un insert de las mismas en la coleccion que corresponda
    //y hacer un update con las cantidades de cartas
    // Y remover los toast del checkCard onClickListener y puede que cambiarselo al de addCards Button
    //Ver tambien como hacer persistir los checks en los search y los textview de quantity
    //Y como hacer para limpiarlos cada vez que se busca algo nuevo
//Tambien hacer un onTextChangeListener para los quantities de cartas
    override fun getCardUnCheckedName(text: String) {
        checkedCards = checkedCards.filter { it != text }.toTypedArray()
    }


}