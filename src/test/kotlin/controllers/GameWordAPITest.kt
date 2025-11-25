package controllers

import ie.setu.models.GameWord
import ie.setu.controllers.GameWordAPI
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameWordAPITest {

    private var gameWordAPI: GameWordAPI? = null

    @BeforeEach
    fun setup() {
        gameWordAPI = GameWordAPI()
    }

    @AfterEach
    fun tearDown() {
        gameWordAPI = null
    }

    @Test
    fun `adding game word stores the expected values in the list`() {
        gameWordAPI!!.addWordToGame(wordId = 5, givenWord = "madera", gameId = 1, answer = "wood", isCorrect = true)
        gameWordAPI!!.addWordToGame(wordId = 17, givenWord = "divertido", gameId = 2, answer = "fun", isCorrect = true)

        assertEquals(2, gameWordAPI!!.gameWords.size)

        val first = gameWordAPI!!.gameWords[0]
        assertEquals(5, first.wordId)
        assertEquals(1, first.gameId)
        assertEquals("madera", first.givenWord)
        assertEquals("wood", first.answer)
        assertTrue(first.isCorrect)

        val second = gameWordAPI!!.gameWords[1]
        assertEquals(17, second.wordId)
        assertEquals(2, second.gameId)
        assertEquals("divertido", second.givenWord)
        assertEquals("fun", second.answer)
        assertTrue(second.isCorrect)
    }

    @Test
    fun `wordStats stores multiple attempts and counts correct and incorrect`() {
        gameWordAPI!!.addWordToGame(wordId = 74, givenWord = "juicio", gameId = 1, answer = "judgement", isCorrect = true)
        gameWordAPI!!.addWordToGame(wordId = 74, givenWord = "juicio", gameId = 2, answer = "judgement", isCorrect = false)
        gameWordAPI!!.addWordToGame(wordId = 74, givenWord = "juicio", gameId = 3, answer = "judgement", isCorrect = true)

        val records = gameWordAPI!!.gameWords.filter { it.givenWord.trim().equals("juicio", ignoreCase = true) }

        assertEquals(3, records.size)
        val correctCount = records.count { it.isCorrect }
        val incorrectCount = records.count { !it.isCorrect }

        assertEquals(2, correctCount)
        assertEquals(1, incorrectCount)
    }
}