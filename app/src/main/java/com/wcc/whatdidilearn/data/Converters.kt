package com.wcc.whatdidilearn.data

import android.graphics.Color.red
import androidx.room.TypeConverter
import com.wcc.whatdidilearn.R
import com.wcc.whatdidilearn.entities.UnderstandingLevel

class Converters {
    @TypeConverter
    fun understanding_levelToInt(understanding_level: UnderstandingLevel): Int{
        return understanding_level.color
    }

    @TypeConverter
    fun intTo_understanding_level(color: Int): UnderstandingLevel{
        return when(color){
            R.color.purple_200 -> UnderstandingLevel.LOW
            R.color.purple_500 -> UnderstandingLevel.MEDIUM
            else -> UnderstandingLevel.HIGH
        }
    }
}