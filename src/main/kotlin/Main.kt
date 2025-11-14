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

    println("How many questions? ")
    val numberOfWords = readlnOrNull()?.toIntOrNull()




}