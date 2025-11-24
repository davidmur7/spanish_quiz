package controllers

import ie.setu.controllers.WordAPI
import ie.setu.models.Word
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WordAPITest {

    private var wordAPI: WordAPI? = null

    @BeforeEach
    fun setup() {
        wordAPI = WordAPI()
        wordAPI!!.loadWords()
    }

    @AfterEach
    fun tearDown() {
        wordAPI = null
    }

    @Test
    fun `listWordsByLevel intermediate contains fuerte`() {
        val output = wordAPI!!.listWordsByLevel("intermediate")
        assertTrue(output.contains("fuerte"))
    }

    @Test
    fun `getWordsByLevelAndCategory returns matching words for advanced and verb`() {

        val level = "advanced"
        val category = "verb"

        val results: List<Word> = wordAPI!!.getWordsByLevelAndCategory(level, category)

        assertFalse(results.isEmpty())
        assertTrue(results.all { it.level == level && it.category == category })

        val givenWords = mutableSetOf<String>()
        for (word in results) {
            givenWords.add(word.givenWord)
        }
        assertTrue(givenWords.contains("renunciar"))
        assertTrue(givenWords.contains("desplegar"))
    }

}