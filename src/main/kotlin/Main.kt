package ie.setu

import ie.setu.controllers.GameAPI
import ie.setu.controllers.WordAPI

val wordAPI = WordAPI()
val gameAPI = GameAPI()

fun main() {

    wordAPI.loadWords()
    runMenu(wordAPI, gameAPI)

}


fun menu(): Int {
    println("    Spanish Quiz  ")
    println("1. Start game")
    println("0. Exit")
    return readlnOrNull()?.toIntOrNull() ?: -1
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
        }
    }
    while (true)
}

val niveles  = listOf("beginner", "intermediate", "advanced") // levels
val categorias = listOf("noun", "verb", "adjective") // categories


fun startQuiz(wordAPI: WordAPI, gameAPI: GameAPI) {
    print("Enter your name: ")
    val userName = readln()

    println("Choose level:")
    for (i in niveles) {
        print(i + " ")
    }
    println("\nEnter the level name: ")
    val chosenLevel = readln()

    println("Choose category: ")
    for (i in categorias) {
        print(i + " ")
    }

    println("\nEnter the category: ")
    val chosenCategory = readln()

    println("How many words? ")
    val numberOfWords = readlnOrNull()?.toIntOrNull() ?: 5

    val game = gameAPI.createGame(userName, chosenLevel, chosenCategory, numberOfWords)

    val palabras = wordAPI.getWordsByLevelAndCategory(chosenLevel, chosenCategory) //words

    val quizWords = palabras.shuffled().take(numberOfWords)

    var score = 0

    for (word in quizWords) {
        println("Translate '${word.givenWord}' to English:")

        print("Your answer: ")
        val answer = readlnOrNull()

        if (answer.equals(word.translatedWord)) {
            println("Correct!")
            score++
        } else {
            println("Incorrect. Correct answer: ${word.translatedWord}")
        }
    }

    println("\nGame over! ${userName}")
    println("Name: ${userName}")
    println("Level: $chosenLevel \t Category: $chosenCategory")
    println("Score: $score out of ${quizWords.size}")

}