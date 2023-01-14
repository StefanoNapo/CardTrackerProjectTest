package com.example.cardTrackerProject.ui.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.example.cardTrackerProject.R
import com.squareup.picasso.Picasso

class CardImageDialog : DialogFragment() {

    private lateinit var imageUrl: String

    companion object {
        fun newInstance(imageUrl: String): CardImageDialog {
            val fragment = CardImageDialog()
            fragment.imageUrl = imageUrl
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.image_dialog_popup, container, false)

        val closeDialogBtn: ImageButton = view.findViewById(R.id.closeCardBtn)

        val cardImage: ImageView = view.findViewById(R.id.bigCardImage)

        Picasso.get().load(imageUrl).into(cardImage)

        closeDialogBtn.setOnClickListener() {
            dismiss()
        }


        return view

    }


}