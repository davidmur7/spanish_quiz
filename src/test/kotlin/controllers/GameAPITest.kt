package controllers
import ie.setu.models.Game
import ie.setu.controllers.GameAPI
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
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
}