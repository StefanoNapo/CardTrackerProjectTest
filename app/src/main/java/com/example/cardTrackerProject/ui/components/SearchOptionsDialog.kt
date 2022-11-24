package com.example.cardTrackerProject.ui.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.cardTrackerProject.R
import com.example.cardTrackerProject.ui.DialogCommunicator

class SearchOptionsDialog : DialogFragment() {

    var monsterTypeChoose: String = ""

    var attrChoose: String = ""

    var cardTypeChoose: String = ""

    var atkChoose: Int? = null

    var defChoose: Int? = null

    var lvlChoose: Int? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.search_options_popup, container, false)

        val closeDialogBtn: ImageButton = view.findViewById(R.id.closeImageButton)

        closeDialogBtn.setOnClickListener() {
            dismiss()
        }

        val cardTypeOptions = arrayOf(
            "",
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
            "Trap Card"
        )

        val cardTypeSpinner: Spinner = view.findViewById(R.id.cardTypeSpinner)



        cardTypeSpinner.adapter = context?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1,
                cardTypeOptions
            )
        }

        cardTypeSpinner.onItemSelectedListener =
            object : AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    cardTypeChoose = cardTypeOptions[p2]


                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    cardTypeChoose = cardTypeOptions[p2]

                }

            }

        val monsterTypeOptions = arrayOf(
            "",
            "Aqua",
            "Beast",
            "Beast-Warrior",
            "Creator-God",
            "Cyberse",
            "Dinosaur",
            "Divine-Beast",
            "Dragon",
            "Fairy",
            "Fiend",
            "Fish",
            "Insect",
            "Machine",
            "Plant",
            "Psychic",
            "Pyro",
            "Reptile",
            "Rock",
            "Sea Serpent",
            "Spellcaster",
            "Thunder",
            "Warrior",
            "Winged Beast",
            "Wyrm",
            "Zombie"
        )

        val monsterTypeSpinner: Spinner = view.findViewById(R.id.monsTypeSpinner)



        monsterTypeSpinner.adapter = context?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1,
                monsterTypeOptions
            )
        }

        monsterTypeSpinner.onItemSelectedListener =
            object : AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    monsterTypeChoose = monsterTypeOptions[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    monsterTypeChoose = monsterTypeOptions[p2]
                }

            }

        val attrOptions = arrayOf(
            "",
            "DARK",
            "EARTH",
            "FIRE",
            "LIGHT",
            "WATER",
            "WIND",
            "DIVINE"
        )

        val attrSpinner: Spinner = view.findViewById(R.id.attrSpinner)



        attrSpinner.adapter = context?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1,
                attrOptions
            )
        }

        attrSpinner.onItemSelectedListener =
            object : AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    attrChoose = attrOptions[p2]
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    attrChoose = attrOptions[p2]
                }

            }

        val communicator:DialogCommunicator = activity as DialogCommunicator

        val confirmOptionsBtn: Button = view.findViewById(R.id.confirmOptionsBtn)

        val atkEditText: EditText = view.findViewById(R.id.atkEditText)

        val defEditText: EditText = view.findViewById(R.id.defEditText)

        val lvlEditText: EditText = view.findViewById(R.id.lvlEditText)

        confirmOptionsBtn.setOnClickListener() {

            val atkSelec = atkEditText.text.toString()

            val defSelec = defEditText.text.toString()

            val lvlSelec = lvlEditText.text.toString()

            if (atkSelec != "") atkChoose = atkSelec.toInt()

            if (defSelec != "") defChoose = defSelec.toInt()

            if (lvlSelec != "") lvlChoose = lvlSelec.toInt()

            communicator.getCardTypeSelected(cardTypeChoose)

            communicator.getMonsterTypeSelected(monsterTypeChoose)

            communicator.getAttrSelected(attrChoose)

            atkChoose?.let { it1 -> communicator.getAtkSelected(it1) }

            defChoose?.let { it1 -> communicator.getDefSelected(it1) }

            lvlChoose?.let { it1 -> communicator.getLvlSelected(it1) }

            Toast.makeText(context, "Search Filters added", Toast.LENGTH_LONG).show()

            dismiss()
            //Conseguir forma de enviar esto a main activity para saber cual carta buscar
            //cardTypeSelected
            //monsterTypeSelected
            //attrSelected
        }


        return view

    }


}