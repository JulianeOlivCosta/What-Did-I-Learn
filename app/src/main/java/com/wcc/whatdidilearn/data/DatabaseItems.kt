package com.wcc.whatdidilearn.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.wcc.whatdidilearn.entities.LearnedItem
import com.wcc.whatdidilearn.entities.UnderstandingLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [LearnedItem::class], version = 1, exportSchema = false) //parametro passado é um array de entidades, banco de dados ta na versao 1
@TypeConverters(Converters::class)//passando os conversores

abstract class DatabaseItems: RoomDatabase() {

    abstract fun learnedItemDao(): LearnedItemDao

    companion object {
        // Singleton para evitar que multiplas instancias do banco de dados sejam abertas ao mesmo tempo
        @Volatile
        private var INSTANCE: DatabaseItems? = null

        fun getDatabase(context: Context, scope: CoroutineScope): DatabaseItems {
            // se INSTANCE não é nulo, então retorna ela mesma,
            // se INSTANCE é nula, então cria uma instancia do banco
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseItems::class.java,
                    "learned_item_database"
                ).addCallback(DataBaseCallBack(scope)).build()
                INSTANCE = instance
                instance
            }
        }

        fun getAll(): List<LearnedItem> {
            val itemOne = LearnedItem(
                "Kotlin - Null safety",
                "O sistema de tipos de Kotlin visa eliminar o perigo de referências nulas do código,",
                UnderstandingLevel.HIGH
            )
            val itemTwo = LearnedItem(
                "Layout editor",
                "O Design Editor exibe o layout em vários dispositivos e versões do Android.É possível criar e editar um layout usando apenas componentes visuais.",
                UnderstandingLevel.LOW
            )
            val itemThree = LearnedItem(
                "Git",
                "É um sistema de controle de versão distribuído. Com ele é possível rastrear mudanças no código-fonte durante o desenvolvimento de software.",
                UnderstandingLevel.HIGH
            )
            val itemFour = LearnedItem(
                "GroupView",
                "É uma view especial que pode conter outras views (chamadas de filhos).É a classe base para layouts e contêineres de views.",
                UnderstandingLevel.MEDIUM
            )
            val itemFive = LearnedItem(
                "View Binding",
                "View Binding é um recurso que facilita a programação de códigos que interagem com views.",
                UnderstandingLevel.MEDIUM
            )

            return listOf(itemOne, itemTwo, itemThree, itemFour, itemFive)
        }
    }
    private class DataBaseCallBack (
            private val scope: CoroutineScope
    ): RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch { populateDataBase(database.learnedItemDao()) }
            }
        }
        suspend fun populateDataBase(dao: LearnedItemDao){
            val itemOne = LearnedItem(
                    "Kotlin - Null safety",
                    "O sistema de tipos de Kotlin visa eliminar o perigo de referências nulas do código,",
                    UnderstandingLevel.HIGH
            )
            val itemTwo = LearnedItem(
                    "Layout editor",
                    "O Design Editor exibe o layout em vários dispositivos e versões do Android.É possível criar e editar um layout usando apenas componentes visuais.",
                    UnderstandingLevel.LOW
            )
            val itemThree = LearnedItem(
                    "Git",
                    "É um sistema de controle de versão distribuído. Com ele é possível rastrear mudanças no código-fonte durante o desenvolvimento de software.",
                    UnderstandingLevel.HIGH
            )
            val itemFour = LearnedItem(
                    "GroupView",
                    "É uma view especial que pode conter outras views (chamadas de filhos).É a classe base para layouts e contêineres de views.",
                    UnderstandingLevel.MEDIUM
            )
            val itemFive = LearnedItem(
                    "View Binding",
                    "View Binding é um recurso que facilita a programação de códigos que interagem com views.",
                    UnderstandingLevel.MEDIUM
            )
            dao.insert(itemOne)
            dao.insert(itemTwo)
            dao.insert(itemThree)
            dao.insert(itemFour)
            dao.insert(itemFive)
        }
    }
}