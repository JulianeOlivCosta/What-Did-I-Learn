package com.wcc.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wcc.whatdidilearn.entities.LearnedItem
import com.wcc.whatdidilearn.repository.LearnedItemsRepository

class LearnedItemViewModel(private val repository: LearnedItemsRepository): ViewModel() {
    val learnedItemsList: LiveData<List<LearnedItem>>

    init {
        learnedItemsList = repository.learnedItems
    }
}