package ie.setu

import ie.setu.controllers.WordAPI
import ie.setu.models.Word
import ie.setu.controllers.GameAPI

val wordAPI = WordAPI()
val gameAPI = GameAPI()

fun main() {

    wordAPI.loadWords()
    runMenu(wordAPI, gameAPI)

}


fun menu(): Int {
    println("    Spanish Quiz  ")
    println("1. Start beginner game")
    println("2. Start intermediate game")
    println("3. Start advanced game")
    println("0. Exit")
    return readlnOrNull()?.toIntOrNull() ?: -1
}


fun runMenu(wordAPI: WordAPI, gameAPI: GameAPI) {

    do {
        val option = menu()
        when (option) {
            1 -> beginnerQuiz()
            2 ->intermediateQuiz()
            3 -> advancedQuiz()
            0 -> {
                println("exiting")
                return
            }
        }
    }
    while (true)
}


fun beginnerQuiz() {
    println("you chose beginner")
    val beginnerWords = wordAPI.getWordsByLevel("beginner")
    for (word in beginnerWords) {
        println(word.givenWord)
    }
}

fun intermediateQuiz() {
    println("you chose intermediate")
}

fun advancedQuiz() {
    println("you chose advanced")
}