package com.wcc.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wcc.whatdidilearn.entities.LearnedItemEntity
import com.wcc.whatdidilearn.entities.UnderstandingLevel
import com.wcc.whatdidilearn.repository.LearnedItemsRepository
import kotlinx.coroutines.launch

class NewLearnedItemViewModel(private var repository: LearnedItemsRepository): ViewModel() {
    fun insertNewLearnedItem(itemTitle: String, itemDescription: String){
        viewModelScope.launch{
            val item = LearnedItemEntity(itemTitle, itemDescription, UnderstandingLevel.HIGH)
            repository.insertNewLearnedItem(item)
        }

    }

}