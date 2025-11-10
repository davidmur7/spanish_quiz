package ie.setu

import ie.setu.controllers.WordAPI
import ie.setu.models.Word



fun main() {

}


fun menu(): Int {
    println("    Spanish Quiz  ")
    println("1. Start beginner game")
    println("2. Start intermediate game")
    println("3. Start advanced game")
    println("0. Exit")
    return readlnOrNull()?.toIntOrNull() ?: -1
}


fun runMenu() {

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
}

fun intermediateQuiz() {
    println("you chose intermediate")
}

fun advancedQuiz() {
    println("you chose advanced")
}