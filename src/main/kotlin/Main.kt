package ie.setu

import ie.setu.controllers.GameAPI
import ie.setu.controllers.GameWordAPI
import ie.setu.controllers.WordAPI
import ie.setu.utils.readIntNotNull
import ie.setu.utils.readNextInt
import ie.setu.utils.readNextLine

val wordAPI = WordAPI()
val gameAPI = GameAPI()
val gameWord = GameWordAPI()


fun main() {

    wordAPI.loadWords()
    runMenu(wordAPI, gameAPI)

}

fun menu(): Int {
    println("    Spanish Quiz  ")
    println("1. Start game")
    println("2. Search word records")
    println("3. List words by level")
    println("0. Exit")
    return readNextInt("Choose option: ")
}


fun runMenu(wordAPI: WordAPI, gameAPI: GameAPI) {

    do {
        val option = menu()
        when (option) {
            1 -> startQuiz(wordAPI, gameAPI)
            0 -> {
                println("exiting")
                return
            }
            2 -> {
                val word = readNextLine("Enter the Spanish word to search for: ").trim()
                gameWord.wordStats(word)
            }
            3 -> {
                val chosenLevel = readNextLine("Enter level to list (beginner, intermediate, advanced): ").trim()
                println(wordAPI.listWordsByLevel(chosenLevel))
            }
            else -> println("Invalid option entered: $option")

        }
    }
    while (true)
}

val niveles  = listOf("beginner", "intermediate", "advanced") // levels
val categorias = listOf("noun", "verb", "adjective") // categories


fun startQuiz(wordAPI: WordAPI, gameAPI: GameAPI) {
    val userName = readNextLine("Enter your username: ").trim()


    for (i in niveles) {
        print(i + " ")
    }
    var chosenLevel = readNextLine("\nChoose level: ").trim().lowercase()
    while (chosenLevel !in niveles) {
        println("${chosenLevel} is not a valid option")
        for (i in niveles) {
            print(i + " ")
        }
        chosenLevel = readNextLine("\nChoose level: ").trim().lowercase()
    }


    for (i in categorias) {
        print(i + " ")
    }

    var chosenCategory = readNextLine("\nEnter the category: ").trim().lowercase()
    while (chosenCategory !in categorias) {
        println("${chosenCategory} is not a valid option")
        for (i in categorias) {
            print(i + " ")
        }
        chosenCategory = readNextLine("\nEnter the category: ").trim().lowercase()
    }

    //println("How many words would you like to be quized on? ")
    //val numberOfWords = readlnOrNull()?.toIntOrNull() ?: 5
    val numberOfWords = readNextInt("How many words would you like to be quized on? ")

    val game = gameAPI.createGame(userName, chosenLevel, chosenCategory, numberOfWords)

    val palabras = wordAPI.getWordsByLevelAndCategory(chosenLevel, chosenCategory) //words

    val quizWords = palabras.shuffled().take(numberOfWords)

    var score = 0

    for (word in quizWords) {
        println("Translate '${word.givenWord}' to English:")

        print("Your answer: ")
        val answer1 = readln()

        if (answer1.equals(word.translatedWord)) {
            println("Correct!")
            score++

        } else {
            println("Incorrect. Correct answer: ${word.translatedWord}")

        }
        val givenWord = word.givenWord
        val isCorrect = answer1.equals(word.translatedWord)
        gameWord.addWordToGame(
            wordId = word.wordId,
            gameId = game.gameId,
            givenWord = givenWord,
            answer = answer1,
            isCorrect = isCorrect
        )
    }

    println("\nGame over! ${userName}")
    println("Level: $chosenLevel \n Category: $chosenCategory")
    println("Score: $score out of ${quizWords.size}\n")
    //print(gameWord.gameWords)

}