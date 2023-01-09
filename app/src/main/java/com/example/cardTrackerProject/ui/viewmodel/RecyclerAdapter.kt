package com.example.cardTrackerProject.ui.viewmodel


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cardTrackerProject.data.model.CardChecked
import com.example.cardTrackerProject.databinding.RowLayoutBinding
import com.example.cardTrackerProject.domain.model.Card
import com.example.cardTrackerProject.ui.CardsCheckedListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_layout.view.*


class RecyclerAdapter(private val context: Context) : ListAdapter<Card, RecyclerAdapter.CardViewHolder>(DiffCallback()) {

    var checkedCards: MutableList<String> = ArrayList()

    var cardsQuant: MutableList<Int> = ArrayList()

    var nameChecked = ""

    var quantChecked = 0

    var cardsChecked: MutableList<CardChecked> = ArrayList()


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

 //   private var listener: CardTextCheckedListener? = null

 //   private var quantListener: CardQuantityListener? = null

    private var cardCListener: CardsCheckedListener? = null

 //   fun cardTextCheckedListener(listener: CardTextCheckedListener) {
//        this.listener = listener
//    }

//    fun cardQuantityListener(listener: CardQuantityListener) {
//        this.quantListener = listener
//    }

    fun cardsCheckedListener(listener: CardsCheckedListener) {
        this.cardCListener = listener
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentCard = getItem(position)
        holder.bind(currentCard)

        val cardCheckBox = holder.itemView.cardCheckBox

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

            if (cardQuantity.text.isNotBlank() && cardQuantity.text.isNotEmpty()){

                if (cardCheckBox.isChecked) {


                    if (cardName != null) {
                    //Como enviar el valor solo cuando presione addCards
                        nameChecked = cardName
                        quantChecked = cardQuantity.text.toString().toInt()

                        val cardChecked = CardChecked(nameChecked, quantChecked)

                        cardsChecked += cardChecked

                        cardCListener?.getCardChecked(cardsChecked)

                    checkedCards += cardName
                    val quant = checkedCards.count()
                    //despues cambiar el quantListener y ver como enviar cantidades
            //        quantListener?.getCardQuantity(quant)
            //       listener?.getCardCheckedName(cardName)

                    }

                }
                else {

                    if (cardName != null) {

                        nameChecked = cardName
                        quantChecked = cardQuantity.text.toString().toInt()

                        val cardChecked = CardChecked(nameChecked, quantChecked)

                        cardsChecked = cardsChecked.filter { it != cardChecked }.toMutableList()

                        cardCListener?.getCardChecked(cardsChecked)
                    checkedCards = checkedCards.filter { it != cardName }.toMutableList()

           //         listener?.getCardUnCheckedName(cardName)
                }
            }
            }
            else{
                Toast.makeText(context, "You must first add the amount of copies", Toast.LENGTH_LONG).show()
                cardCheckBox.isChecked = false

            }

            //Ver como usar las diferentes colecciones para mostras y editarlas
        }


        //Conseguir que se envie correctamente las cantidades de las cartas checkeadas
        //y ver como ordenarlas con el nombre correcto para poder llenar la coleccion
        if (cardCheckBox.isChecked){

            if (cardQuantity.text.isNotEmpty() && cardQuantity.text.isNotBlank()) {
                cardsQuant += cardQuantity.text.toString().toInt()
            }

            cardQuantity.setOnFocusChangeListener { view, b ->
                if (cardQuantity.text.isNotEmpty() && cardQuantity.text.isNotBlank()) {
                    cardsQuant += cardQuantity.text.toString().toInt()
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
