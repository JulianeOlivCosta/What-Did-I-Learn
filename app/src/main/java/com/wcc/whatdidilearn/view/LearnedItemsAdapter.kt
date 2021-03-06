package com.wcc.whatdidilearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wcc.whatdidilearn.R
import com.wcc.whatdidilearn.entities.LearnedItemEntity

class LearnedItemsAdapter: RecyclerView.Adapter<LearnedItemsAdapter.LearnedItemViewHolder>() {

    var data = listOf<LearnedItemEntity>() //segura dados do banco
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class LearnedItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        //cria uma variavel para cada item de tela.

        val titleItem: TextView = itemView.findViewById(R.id.itemTitle)
        val descriptionItem: TextView = itemView.findViewById(R.id.itemDescription)
        val levelItem: View = itemView.findViewById(R.id.itemLevel)

        fun bind(title: String, description: String, color: Int) {
            titleItem.text = title
            descriptionItem.text = description
            levelItem.setBackgroundResource(color)
        }
    }

    //pega o leyout do item criado e infla ele.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_learned, parent, false)
        return LearnedItemViewHolder(itemView)
    }

    //retorna qts elementos existem na nossa lista
    override fun getItemCount(): Int {
        return data.size
    }

    //conecta os dados com a viewHolder
    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        val itemLearnedToShowEntity: LearnedItemEntity = data.get(position)
        holder.bind(itemLearnedToShowEntity.title, itemLearnedToShowEntity.description, itemLearnedToShowEntity.understanding_level.color)
    }

}