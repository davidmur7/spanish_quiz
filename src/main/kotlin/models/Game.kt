package ie.setu.models

data class Game(
    val gameId: Int,
    val userName: String,
    val chosenLevel: String,
    val chosenCategory: String,
    val numberOfWords: Int
)