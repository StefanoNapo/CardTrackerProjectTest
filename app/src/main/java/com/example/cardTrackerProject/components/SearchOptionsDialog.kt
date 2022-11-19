package com.example.cardTrackerProject.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.cardTrackerProject.R
import kotlinx.android.synthetic.main.search_options_popup.*

class SearchOptionsDialog : DialogFragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.search_options_popup, container, false)

    }



}