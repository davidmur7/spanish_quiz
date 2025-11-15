package ie.setu.controllers

import ie.setu.models.GameWord
import ie.setu.models.Word
import ie.setu.models.Game
private var gameWordId = 100
class GameWordAPI {

    private val gameWords = mutableListOf<GameWord>()

    fun addWordToGame(wordId: Int, gameId: Int, answer: String, isCorrect: Boolean) {
        gameWords.add(
            GameWord(
                gameWordId = gameWordId++,
                gameId = gameId,
                wordId = wordId,
                answer = answer,
                isCorrect = isCorrect
            )
        )
    }

}