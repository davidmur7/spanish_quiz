package ie.setu.models

data class GameWord (
    val id: Int,
    val gameId: Int,
    val wordId: Int,
    val answer: String,
    val isCorrect: Boolean

)