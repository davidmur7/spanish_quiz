package ie.setu.controllers
import ie.setu.models.Word
import ie.setu.models.Game


class GameAPI {
    private val games = ArrayList<Game>()

    fun createGame(userName: String, level: Int, category: String, numberOfWords: Int): Game {
        val newGame = Game(
            gameId = games.size + 1,
            userName = userName,
            chosenLevel = level,
            chosenCategory = category,
            numberOfWords = numberOfWords
        )
        games.add(newGame)
        return newGame

    }

}