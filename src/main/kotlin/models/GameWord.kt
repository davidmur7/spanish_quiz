package ie.setu.models

data class GameWord (
    val gameWordId: Int,
    val gameId: Int,
    val wordId: Int,
    val givenWord: String,
    val answer: String,
    val isCorrect: Boolean
)