package com.wcc.whatdidilearn.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.wcc.whatdidilearn.R
import com.wcc.whatdidilearn.data.DatabaseItems
import com.wcc.whatdidilearn.databinding.NewLearnedItemBinding
import com.wcc.whatdidilearn.repository.LearnedItemsRepository
import com.wcc.whatdidilearn.viewmodel.NewLearnedItemViewModel
import com.wcc.whatdidilearn.viewmodel.NewLearnedItemViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class NewLearnedItem: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.title = "New Learned Item"

        val binding = NewLearnedItemBinding.inflate(layoutInflater) //similar ao getInflate
        setContentView(binding.root)

        val database = DatabaseItems.getDatabase(this, CoroutineScope(Dispatchers.IO))
        val dao = database.learnedItemDao()
        val repository = LearnedItemsRepository(dao)
        val viewModelFactory = NewLearnedItemViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory)
                .get(NewLearnedItemViewModel::class.java)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()
            viewModel.insertNewLearnedItem(title, description)

            navigateToMainActivity()
        }
    }
    private fun navigateToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}


