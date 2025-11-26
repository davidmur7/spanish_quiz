package ie.setu.models

/**
 * Keeps a record of every word answered in every game
 *
 * @property gameWordId unique identifier
 * @property gameId id of the game in which the word was shown
 * @property wordId id of the word
 * @property givenWord the Spanish word
 * @property answer the user's answer
 * @property isCorrect true or false depending on wheter the user got it right
 */

data class GameWord(
    val gameWordId: Int,
    val gameId: Int,
    val wordId: Int,
    val givenWord: String,
    val answer: String,
    val isCorrect: Boolean,
)
