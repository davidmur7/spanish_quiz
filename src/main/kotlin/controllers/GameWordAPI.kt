package ie.setu.controllers

import ie.setu.models.GameWord
import ie.setu.models.Word
import ie.setu.models.Game
import ie.setu.controllers.WordAPI
val wordAPI = WordAPI()

private var gameWordId = 100
class GameWordAPI {

    val gameWords = mutableListOf<GameWord>()

    fun addWordToGame(wordId: Int, givenWord: String, gameId: Int, answer: String, isCorrect: Boolean) {
        gameWords.add(
            GameWord(
                gameWordId = gameWordId++,
                gameId = gameId,
                wordId = wordId,
                answer = answer,
                isCorrect = isCorrect,
                givenWord = givenWord
            )
        )
    }
    fun wordStats(givenWord: String) {
        for (i in gameWords) {
            if (i.givenWord.equals(givenWord)) {
                print(i)
            }
        }
    }

}