package com.example.cardTrackerProject.ui.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import com.example.cardTrackerProject.R

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


        return view

    }




}