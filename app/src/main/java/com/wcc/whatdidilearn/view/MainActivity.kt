package com.wcc.whatdidilearn.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.wcc.whatdidilearn.data.DatabaseItems
import com.wcc.whatdidilearn.databinding.ActivityMainBinding
import com.wcc.whatdidilearn.repository.LearnedItemsRepository
import com.wcc.whatdidilearn.viewmodel.LearnedItemViewModel
import com.wcc.whatdidilearn.viewmodel.LearnedItemViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

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
        val repository = LearnedItemsRepository(dao)
        val viewModelFactory = LearnedItemViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(LearnedItemViewModel::class.java)
        val itemsList = viewModel.learnedItemsListEntity
        itemsList.observe(this, Observer { items ->
            adapter.data = items
        })

        binding.addFab.setOnClickListener{

            val intent = Intent(this, NewLearnedItem::class.java)
            startActivity(intent)
        }

    }


}
