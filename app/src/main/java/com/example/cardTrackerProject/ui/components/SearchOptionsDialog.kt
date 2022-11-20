package com.example.cardTrackerProject.ui.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import androidx.core.view.get
import androidx.fragment.app.DialogFragment
import com.example.cardTrackerProject.R
import com.example.cardTrackerProject.ui.view.MainActivity

class SearchOptionsDialog : DialogFragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val view = inflater.inflate(R.layout.search_options_popup, container, false)

        val closeDialogBtn : ImageButton = view.findViewById(R.id.closeImageButton)

        closeDialogBtn.setOnClickListener(){
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

        val cardTypeSpinner : Spinner = view.findViewById(R.id.cardTypeSpinner)

        var cardTypeSelected : String

        cardTypeSpinner.adapter = context?.let { ArrayAdapter<String>(it,android.R.layout.simple_list_item_1,cardTypeOptions) }

        cardTypeSpinner.onItemSelectedListener = object :AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                cardTypeSelected = cardTypeSpinner.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }

        val monsterTypeOptions = arrayOf(
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
            "Zombie")

        val monsterTypeSpinner : Spinner = view.findViewById(R.id.monsTypeSpinner)

        var monsterTypeSelected : String

        monsterTypeSpinner.adapter = context?.let { ArrayAdapter<String>(it,android.R.layout.simple_list_item_1,monsterTypeOptions) }

        monsterTypeSpinner.onItemSelectedListener = object :AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                monsterTypeSelected = monsterTypeSpinner.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }

        val attrOptions = arrayOf(
            "DARK",
            "EARTH",
            "FIRE",
            "LIGHT",
            "WATER",
            "WIND",
            "DIVINE"
            )

        val attrSpinner : Spinner = view.findViewById(R.id.attrSpinner)

        var attrSelected : String

        attrSpinner.adapter = context?.let { ArrayAdapter<String>(it,android.R.layout.simple_list_item_1,attrOptions) }

        attrSpinner.onItemSelectedListener = object :AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                attrSelected = attrSpinner.selectedItem.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }

        return view

    }




}