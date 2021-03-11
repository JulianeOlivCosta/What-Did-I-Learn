package com.wcc.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wcc.whatdidilearn.entities.LearnedItemEntity
import com.wcc.whatdidilearn.repository.LearnedItemsRepository

class LearnedItemViewModel(private val repository: LearnedItemsRepository): ViewModel() {
    val learnedItemsListEntity: LiveData<List<LearnedItemEntity>> = repository.learnedItems

}