package controllers

import ie.setu.controllers.GameAPI
import ie.setu.models.Game
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameAPITest {
    private var gameAPI: GameAPI? = null

    @BeforeEach
    fun setup() {
        gameAPI = GameAPI()
    }

    @AfterEach
    fun tearDown() {
        gameAPI = null
    }

    @Test
    fun `createGame returns game with correct attributes`() {
        val userName = "Haaland"
        val level = "beginner"
        val category = "noun"
        val numberOfWords = 4

        val game: Game = gameAPI!!.createGame(userName, level, category, numberOfWords)

        assertNotNull(game)
        assertEquals(1, game.gameId)
        assertEquals(userName, game.userName)
        assertEquals(level, game.chosenLevel)
        assertEquals(category, game.chosenCategory)
        assertEquals(numberOfWords, game.numberOfWords)
    }

    @Test
    fun `createGame increments gameId after each instance`() {
        val game1 = gameAPI!!.createGame("Salah", "beginner", "noun", 2)
        val game2 = gameAPI!!.createGame("Parrott", "intermediate", "verb", 6)
        val game3 = gameAPI!!.createGame("Pirlo", "advanced", "adjective", 1)

        assertEquals(1, game1.gameId)
        assertEquals(2, game2.gameId)
        assertEquals(3, game3.gameId)
    }
}
