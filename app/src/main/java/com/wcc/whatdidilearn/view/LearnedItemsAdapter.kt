package com.wcc.whatdidilearn.view

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.wcc.whatdidilearn.R
import com.wcc.whatdidilearn.entities.ItemLearned
import org.w3c.dom.Text

class LearnedItemsAdapter: RecyclerView.Adapter<LearnedItemsAdapter.LearnedItemViewHolder>() {

    var data = listOf<ItemLearned>() //segura dados do banco


    inner class LearnedItemViewHolder (itemView: View): RecyclerView.ViewHolder (itemView){
        val titleItem: TextView = itemView.findViewById(R.id.itemTitle)
        val descriptionItem: TextView = itemView.findViewById(R.id.itemDescription)
        val levelItem: View = itemView.findViewById(R.id.itemLevel)

        fun bind(title: String, description:String, color: Int){
            titleItem.text = title,
            descriptionItem.text = description,
            levelItem.setBackgroundResource(color)
        }
    }

    //tela - dados
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        TODO("Not yet implemented")
    }

    //retorna qts elementos existem na nossa lista
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}