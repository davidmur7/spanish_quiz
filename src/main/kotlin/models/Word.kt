package ie.setu.models


data class Word(
    val wordId: Int,
    val givenWord: String,
    val translatedWord: String,
    val level: String,
    val category: String,
    val isIncluded: Boolean
)