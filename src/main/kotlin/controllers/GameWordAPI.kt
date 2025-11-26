package ie.setu.controllers

import ie.setu.models.GameWord

val wordAPI = WordAPI()

private var gameWordId = 100

class GameWordAPI {
    val gameWords = mutableListOf<GameWord>()

    fun addWordToGame(
        wordId: Int,
        givenWord: String,
        gameId: Int,
        answer: String,
        isCorrect: Boolean,
    ) {
        gameWords.add(
            GameWord(
                gameWordId = gameWordId++,
                gameId = gameId,
                wordId = wordId,
                answer = answer,
                isCorrect = isCorrect,
                givenWord = givenWord,
            ),
        )
    }

    fun wordStats(givenWord: String) {
        val wordRecords = mutableListOf<GameWord>()

        val search = givenWord.trim().lowercase()

        for (i in gameWords) {
            val entryWord = i.givenWord.trim().lowercase()
            if (entryWord.equals(search)) {
                wordRecords.add(i)
            }
        }

        if (wordRecords.isEmpty()) {
            println("No records found for word: $givenWord")
            return
        }
        println("Entries for word '$givenWord':")
        for (record in wordRecords) {
            println("Game ${record.gameId}: Answer='${record.answer}', Correct=${record.isCorrect}")
        }
    }
}
