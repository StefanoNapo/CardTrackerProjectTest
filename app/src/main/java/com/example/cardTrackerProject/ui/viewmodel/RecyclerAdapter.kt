package com.example.cardTrackerProject.ui.viewmodel


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cardTrackerProject.CardTrackerProject
import com.example.cardTrackerProject.data.model.CardChecked
import com.example.cardTrackerProject.databinding.RowLayoutBinding
import com.example.cardTrackerProject.domain.model.Card
import com.example.cardTrackerProject.ui.CardsCheckedListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_layout.view.*


class RecyclerAdapter(private val context: Context) : ListAdapter<Card, RecyclerAdapter.CardViewHolder>(DiffCallback()) {



    var cardsQuant: MutableList<Int> = ArrayList()

    var nameChecked = ""

    var quantChecked = 0

    var cardsChecked = CardTrackerProject.cardsChecked


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

    private var cardCListener: CardsCheckedListener? = null


    fun cardsCheckedListener(listener: CardsCheckedListener) {
        this.cardCListener = listener
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val currentCard = getItem(position)
        holder.bind(currentCard)

        val cardCheckBox = holder.itemView.cardCheckBox
        val deleteBtn = holder.itemView.deleteButton
        val cardQuantity = holder.itemView.quantity

        when (CardTrackerProject.collectionSelected) {
            "Every Card" -> {
                deleteBtn.isVisible = false
                cardCheckBox.isVisible = true

                //Checkear aca tambien las cantidades y comparar con el valor del quantity
                for (card in CardTrackerProject.cardsChecked) {

                    if (card.cardName == currentCard.name) {
                        cardCheckBox.isChecked = true
                        cardQuantity.setText(card.cardQuant.toString())
                        break
                    } else {
                        cardCheckBox.isChecked = false
                        cardQuantity.text.clear()
                    }
                }
            }
            "My Collection" -> {
                //Hacer en cada uno de estos un bucle for checkeando con la query de getAllCards de cada collection para quantity
                //Y hacer que el onclicklistener del boton haga la query con borrar la carta con la variable nombre del cardname
                //Como el cardname de arriba

                for (card in CardTrackerProject.cardListMyColl) {

                    if (card.name == currentCard.name) {
                        cardQuantity.setText(card.quantity.toString())
                    }
                }

                cardCheckBox.isVisible = false
                deleteBtn.isVisible = true
            }
            "For Sale Collection" -> {
                for (card in CardTrackerProject.cardListForSaleColl) {

                    if (card.name == currentCard.name) {
                        cardQuantity.setText(card.quantity.toString())
                    }
                }

                cardCheckBox.isVisible = false
                deleteBtn.isVisible = true
            }
            "Competitive Collection" -> {
                cardCheckBox.isVisible = false
                deleteBtn.isVisible = true
            }
        }



        //hacer onTextChangeListener para el quantity y que cambie las cantidades de

        cardCheckBox.setOnClickListener {
            val cardName = currentCard.name

            if (cardQuantity.text.isNotBlank() && cardQuantity.text.isNotEmpty()){

                if (cardCheckBox.isChecked) {

                    if (cardName != null) {

                        nameChecked = cardName
                        quantChecked = cardQuantity.text.toString().toInt()

                        val cardChecked = CardChecked(nameChecked, quantChecked)

                        cardsChecked += cardChecked

                        cardCListener?.getCardChecked(cardsChecked)

                        Toast.makeText(context, "$nameChecked Added to the list", Toast.LENGTH_LONG).show()

                    }

                }
                else {

                    if (cardName != null) {

                        nameChecked = cardName
                        quantChecked = cardQuantity.text.toString().toInt()

                        val cardChecked = CardChecked(nameChecked, quantChecked)

                        cardsChecked = cardsChecked.filter { it != cardChecked }.toMutableList()

                        cardCListener?.getCardChecked(cardsChecked)

                        Toast.makeText(context, "$nameChecked Removed from the list", Toast.LENGTH_LONG).show()
               }

            }
            }
            else{
                Toast.makeText(context, "You must first add the amount of copies", Toast.LENGTH_LONG).show()
                cardCheckBox.isChecked = false

            }

            //Ver como usar las diferentes colecciones para mostras y editarlas
        }


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
