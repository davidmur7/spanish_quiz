package ie.setu.controllers
import ie.setu.models.Word

import java.io.File


class WordAPI () {

    private val words = ArrayList<Word>()

    fun loadWords() {
        words.add(Word(1, "caminar", "walk", "verb", "beginner", true))
    }

    }
