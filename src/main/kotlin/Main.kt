package ie.setu

import ie.setu.controllers.GameAPI
import ie.setu.controllers.GameWordAPI
import ie.setu.controllers.WordAPI
import ie.setu.utils.readNextInt
import ie.setu.utils.readNextLine
/**
 * The API which stores all the words in the quiz
 */
val wordAPI = WordAPI()
/**
 * API used for creating and storing game sessions
 */
val gameAPI = GameAPI()
/**
 * API used for storing records of particular words
 */
val gameWord = GameWordAPI()
/**
 * Displays the main menu to the user and reads their option
 *
 * @return an int chosen by the user
 */
fun main() {
    wordAPI.loadWords()
    runMenu(wordAPI, gameAPI)
}

fun menu(): Int {
    print(
        """
        |    Spanish Quiz
        |      1. Start game
        |      2. Search word records
        |      3. List words by level
        |      0. Exit
        |
        """.trimMargin()
    )
    return readNextInt("Choose an option: ")
}


fun runMenu(
    wordAPI: WordAPI,
    gameAPI: GameAPI,
) {
    do {
        val option = menu()
        when (option) {
            1 -> startQuiz(wordAPI, gameAPI)
            0 -> {
                println("exiting")
                return
            }
            2 -> {
                val word = readNextLine("Enter the Spanish word to search for: ").trim().lowercase()
                gameWord.wordStats(word)
            }
            3 -> {
                val chosenLevel = readNextLine("Enter level to list (beginner, intermediate, advanced): ").trim().lowercase()
                println(wordAPI.listWordsByLevel(chosenLevel))
            }
            else -> println("Invalid option entered: $option")
        }
    }
    while (true)
}

val niveles = listOf("beginner", "intermediate", "advanced") // levels
val categorias = listOf("noun", "verb", "adjective") // categories

fun startQuiz(
    wordAPI: WordAPI,
    gameAPI: GameAPI,
) {
    val userName = readNextLine("Enter your username: ").trim()

    for (i in niveles) {
        print(i + " ")
    }
    var chosenLevel = readNextLine("\nChoose level: ").trim().lowercase()
    while (chosenLevel !in niveles) {
        println("$chosenLevel is not a valid option")
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
        println("$chosenCategory is not a valid option")
        for (i in categorias) {
            print(i + " ")
        }
        chosenCategory = readNextLine("\nEnter the category: ").trim().lowercase()
    }

    var numberOfWords = readNextInt("How many words would you like to be quized on? ")
    while (numberOfWords > 10 || numberOfWords < 1) {
        print("10 is the maximum number of words you can choose")
        numberOfWords = readNextInt("\nHow many words would you like to be quized on? ")
    }

    val game = gameAPI.createGame(userName, chosenLevel, chosenCategory, numberOfWords)

    val palabras = wordAPI.getWordsByLevelAndCategory(chosenLevel, chosenCategory) // words

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
            isCorrect = isCorrect,
        )
    }

    println("\nGame over! $userName")
    println("Level: $chosenLevel \nCategory: $chosenCategory")
    println("Score: $score out of ${quizWords.size}\n")
}
