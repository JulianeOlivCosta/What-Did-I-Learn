package com.wcc.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wcc.whatdidilearn.data.LearnedItemDao
import com.wcc.whatdidilearn.entities.LearnedItem

class LearnedItemViewModel(private val dao: LearnedItemDao): ViewModel() {
    val learnedItemsList: LiveData<List<LearnedItem>>

    init {
        learnedItemsList = dao.getAll()
    }
}