package com.wcc.whatdidilearn.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.wcc.whatdidilearn.entities.LearnedItem

@Dao
interface LearnedItemDao {
    @Query("SELECT * FROM learned_item ORDER BY item_title ASC")//ordenacao da tabela
    fun getAll(): LiveData<List<LearnedItem>>

    @Insert
    suspend fun insert(item: LearnedItem)
}