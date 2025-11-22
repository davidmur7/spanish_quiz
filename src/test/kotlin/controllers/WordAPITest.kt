package controllers

import ie.setu.controllers.WordAPI
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WordAPITest {

    private var wordAPI: WordAPI? = null

    @BeforeEach
    fun setup() {
        wordAPI = WordAPI()
        wordAPI!!.loadWords()
    }

    @Test
    fun `listWordsByLevel intermediate contains fuerte`() {
        val output = wordAPI!!.listWordsByLevel("intermediate")
        assertTrue(output.contains("fuerte"))
    }

}