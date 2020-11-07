package com.wcc.whatdidilearn.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wcc.whatdidilearn.repository.LearnedItemsRepository
import java.lang.IllegalArgumentException

class NewLearnedItemViewModelFactory(private val dao: LearnedItemsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if ( modelClass.isAssignableFrom(NewLearnedItemViewModel::class.java)){
            return NewLearnedItemViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}