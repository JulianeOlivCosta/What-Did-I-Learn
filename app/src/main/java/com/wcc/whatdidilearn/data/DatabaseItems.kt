package com.wcc.whatdidilearn.data

import com.wcc.whatdidilearn.entities.ItemLearned
import com.wcc.whatdidilearn.entities.Level

class DatabaseItems {
    fun getAll(): List<ItemLearned> {
        val itemOne = ItemLearned(
            "Kotlin - Null safety",
            "O sistema de tipos de Kotlin visa eliminar o perigo de referências nulas do código,",
            Level.HIGH
        )
        val itemTwo = ItemLearned(
            "Layout editor",
            "O Design Editor exibe o layout em vários dispositivos e versões do Android.É possível criar e editar um layout usando apenas componentes visuais.",
            Level.HIGH
        )
        val itemThree = ItemLearned(
            "Git",
            "É um sistema de controle de versão distribuído. Com ele é possível rastrear mudanças no código-fonte durante o desenvolvimento de software.",
            Level.HIGH
        )
        val itemFour = ItemLearned(
            "GroupView",
            "É uma view especial que pode conter outras views (chamadas de filhos).É a classe base para layouts e contêineres de views.",
            Level.HIGH
        )

        return listOf(itemOne,itemTwo,itemThree,itemFour)
    }
}