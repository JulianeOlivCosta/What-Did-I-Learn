package com.wcc.whatdidilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.wcc.whatdidilearn.NewLearnedItem
import com.wcc.whatdidilearn.R
import com.wcc.whatdidilearn.data.DatabaseItems
import com.wcc.whatdidilearn.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater) //similar ao getInflate
        setContentView(binding.root)

        val recycleView = binding.itemsRecycleViews
        val adapter = LearnedItemsAdapter()
        recycleView.adapter = adapter

        val database = DatabaseItems.getDatabase(this, CoroutineScope(Dispatchers.IO))
        val dao = database.learnedItemDao()
        val itemsList = dao.getAll()
        itemsList.observe(this, androidx.lifecycle.Observer { items ->
            adapter.data = items
        })

        val addfab = binding.addFab
        addfab.setOnClickListener{
            var intent = Intent(this, NewLearnedItem::class.java)
            startActivity(intent)
        }
    }
}
