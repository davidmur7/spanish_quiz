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


fun startQuiz(wordAPI: WordAPI, gameAPI: GameAPI) {
    print("Enter your name: ")
    val userName = readln()

}