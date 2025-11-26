package ie.setu.controllers
import ie.setu.models.Game
/**
 * API for creating and storing games.
 */
class GameAPI {
    private val games = ArrayList<Game>()
    /**
     * Create a Game record.
     *
     * @param userName the user's name
     * @param level the difficulty level (e.g- "beginner")
     * @param category the word category chosen (e.g- "verb")
     * @param numberOfWords how many words the game will include
     * @return the Game instance
     */
    fun createGame(
        userName: String,
        level: String,
        category: String,
        numberOfWords: Int,
    ): Game {
        val newGame =
            Game(
                gameId = games.size + 1,
                userName = userName,
                chosenLevel = level,
                chosenCategory = category,
                numberOfWords = numberOfWords,
            )
        games.add(newGame)
        return newGame
    }
}
