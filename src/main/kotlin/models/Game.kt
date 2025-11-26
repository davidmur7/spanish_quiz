package ie.setu.models

/**
 * Is used for every game round
 *
 * @property gameId unique id for the game (not chosen by user)
 * @property userName the player name
 * @property chosenLevel the difficulty level (e.g- "beginner")
 * @property chosenCategory the word category chosen (e.g- "verb")
 * @property numberOfWords how many words the game will give the user
 */
data class Game(
    val gameId: Int,
    val userName: String,
    val chosenLevel: String,
    val chosenCategory: String,
    val numberOfWords: Int,
)
