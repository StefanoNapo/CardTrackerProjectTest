package com.example.cardTrackerProject.ui.viewmodel


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cardTrackerProject.R
import com.example.cardTrackerProject.databinding.RowLayoutBinding
import com.example.cardTrackerProject.domain.model.Card
import com.example.cardTrackerProject.ui.CardQuantityListener
import com.example.cardTrackerProject.ui.CardTextCheckedListener
import com.example.cardTrackerProject.ui.DialogCommunicator
import com.example.cardTrackerProject.ui.view.MainActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_layout.view.*


class RecyclerAdapter : ListAdapter<Card, RecyclerAdapter.CardViewHolder>(DiffCallback()) {

    var checkedCards: MutableList<String> = ArrayList()

    class CardViewHolder(private val binding: RowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

                fun bind(card: Card) {

            binding.apply {

                val cardImageBtn = binding.CardImageButton
                val cardLink = card.cardImages?.get(0)?.imageUrlSmall

                binding.cardName.text = card.name

                Picasso.get().load(cardLink).into(cardImageBtn)

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

    private var quantListener: CardQuantityListener? = null

    fun cardTextCheckedListener(listener: CardTextCheckedListener) {
        this.listener = listener
    }

    fun cardQuantityListener(listener: CardQuantityListener) {
        this.quantListener = listener
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentCard = getItem(position)
        holder.bind(currentCard)

        val cardCheckBox = holder.itemView.cardCheckBox


        //Necesito verificar si considera si el array contiene los nombres de la row del mismo check
        //Conseguir una forma de que se pase por el if y no vaya directamente al else

        for (cardName in checkedCards) {

            if (cardName == currentCard.name){
                cardCheckBox.isChecked = true
                break
            }
            else{
                cardCheckBox.isChecked = false
            }
        }
        //Hacer las cosas para que el quantity sea enviado a la main y se alinie con el cardName
        val cardQuantity = holder.itemView.quantity

        cardCheckBox.setOnClickListener {
            val cardName = currentCard.name
            if (cardCheckBox.isChecked) {

                if (cardName != null) {
                    //Como enviar el valor solo cuando presione addCards
                    //Como hacer para sacar los valores previos
                    //Probablemente haciendo un array con append y usando "array.filter { it != 3 }"

                    checkedCards += cardName
                    //averiguar porque la cuenta siempre da maximo 1 con los checks
                    val quant = checkedCards.count()
                    //despues cambiar el quantListener y ver como enviar cantidades
                    quantListener?.getCardQuantity(quant)
                    listener?.getCardCheckedName(cardName)
                }

            }
            else {
                //   array.filter { it != 3 }

                if (cardName != null) {
                    checkedCards = checkedCards.filter { it != cardName }.toMutableList()

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
