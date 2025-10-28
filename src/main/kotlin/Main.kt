package ie.setu

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
   runMenu()

}

data class Word(
    val wordId: Int,
    val givenWord: String,
    val translatedWord: String,
    val level: Int,
    val category: String,
    var isIncluded: Boolean = true)

data class Game(
    val gameId: Int,
    val userName: String,
    val chosenLevel: Int,
    val chosenCategory: String,
    val numberOfWords: Int
)

fun menu(): Int {
    println("    Spanish Quiz  ")
    println("1. Start new game")
    println("0. Exit")
    return readlnOrNull()?.toIntOrNull() ?: -1
}


fun runMenu() {

    do {
        val option = menu()
        when (option) {
            1 -> println("Choose your level")
        }
    }
        while (true)
}

fun beginnerQuiz() {
    println("")
}

fun intermediateQuiz() {
    println("")
}

fun advancedQuiz() {
    println("")
}