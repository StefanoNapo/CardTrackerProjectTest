package com.example.cardTrackerProject.ui.viewmodel


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cardTrackerProject.databinding.RowLayoutBinding
import com.example.cardTrackerProject.domain.model.Card
import com.example.cardTrackerProject.ui.CardTextCheckedListener
import com.example.cardTrackerProject.ui.DialogCommunicator
import com.example.cardTrackerProject.ui.view.MainActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_layout.view.*


class RecyclerAdapter : ListAdapter<Card, RecyclerAdapter.CardViewHolder>(DiffCallback()) {



    class CardViewHolder(private val binding: RowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

                fun bind(card: Card) {

            binding.apply {

                val cardImageBtn = binding.CardImageButton
                val cardLink = card.cardImages?.get(0)?.imageUrlSmall

                binding.cardName.text = card.name

                Picasso.get().load(cardLink).into(cardImageBtn)

                val cardCheckBox = binding.cardCheckBox

                val cardsChecked = MutableLiveData<List<Card>>()

                if (cardCheckBox.isChecked){
                    cardsChecked.postValue(listOf(card))
                }


            }
        }
    }

    /*This 2 functions help the Recycler to recognize items and not checking 2 items or more with one click
    (multiple checking or multiple cards getting set the amount when changing only 1 of those, like 1 and 11 row,
     2 and 12 and so on happened before adding this 2 functions)
    */
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CardViewHolder(binding)

    }

    private var listener: CardTextCheckedListener? = null

    fun cardTextCheckedListener(listener: CardTextCheckedListener) {
        this.listener = listener
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentCard = getItem(position)
        holder.bind(currentCard)

        val cardCheckBox = holder.itemView.cardCheckBox

        cardCheckBox.setOnClickListener {
            if (cardCheckBox.isChecked) {
                val cardName = currentCard.name
                if (cardName != null) {
                    //Como enviar el valor solo cuando presione addCards
                    //Como hacer para sacar los valores previos
                    //Probablemente haciendo un array con append y usando "array.filter { it != 3 }"
                    listener?.getCardCheckedName(cardName)
                }

            }
            else {
                //   array.filter { it != 3 }
                val cardName = currentCard.name
                if (cardName != null) {
                    listener?.getCardUnCheckedName(cardName)
                }
            }
        }



    }

    class DiffCallback : DiffUtil.ItemCallback<Card>() {
        override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean =
            oldItem == newItem

    }

}
