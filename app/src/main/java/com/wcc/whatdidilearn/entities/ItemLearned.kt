package com.wcc.whatdidilearn.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "learned_item")
data class ItemLearned (
    @ColumnInfo(name = "item_title")
    val title: String,

    @ColumnInfo(name = "item_description")
    val description: String,

    @ColumnInfo(name = "item_understanding_level")
    val understanding_level: UnderstandingLevel, //nao é um tipo primario, fazer um conversao, pois é diferente do tipo primario.

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    val id: Int = 0
)
