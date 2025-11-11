package ie.setu.controllers
import ie.setu.models.Word



class WordAPI () {

    private val words = ArrayList<Word>()

    fun loadWords() {
        words.add(Word(1, "caminar", "walk", "beginner", "verb", true))
        words.add(Word(2, "comer", "eat", "beginner", "verb", true))
        words.add(Word(3, "manzana", "apple", "beginner", "noun", true))
        words.add(Word(4, "fuerte", "strong", "intermediate", "adjective", true))
    }

    fun getWordsByLevel(level: String): List<Word> {
        val wordsByLevel = ArrayList<Word>()
        for (word in words) {
            if (word.level.equals(level)) {
                wordsByLevel.add(word)
            }
        }
        return wordsByLevel
    }


}
