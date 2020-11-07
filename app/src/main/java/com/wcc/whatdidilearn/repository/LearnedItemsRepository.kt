package com.wcc.whatdidilearn.repository

import com.wcc.whatdidilearn.data.LearnedItemDao
import com.wcc.whatdidilearn.entities.LearnedItem

class LearnedItemsRepository(private val dao: LearnedItemDao) {

    val learnedItems = dao.getAll()

    suspend fun insertNewLearnedItem(item: LearnedItem){
        dao.insert(item)
    }

}