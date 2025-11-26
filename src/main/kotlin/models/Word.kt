package ie.setu.models

/**
 * Used for each word which can be quized on
 *
 * @property wordId unique identifier for the word
 * @property givenWord the Spanish word
 * @property translatedWord the correct translation into English
 * @property level difficulty level (e.g- "beginner")
 * @property category type of word (e.g- "noun")
 * @property isIncluded whether this word is currently included in quizzes
 */
data class Word(
    val wordId: Int,
    val givenWord: String,
    val translatedWord: String,
    val level: String,
    val category: String,
    val isIncluded: Boolean,
)
