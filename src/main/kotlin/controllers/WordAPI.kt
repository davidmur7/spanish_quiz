package ie.setu.controllers
import ie.setu.models.Word
import jdk.jfr.Category
import kotlin.text.category


class WordAPI () {

    val words = ArrayList<Word>()

    fun loadWords() {
        words.add(Word(1, "caminar", "to walk", "beginner", "verb", true))
        words.add(Word(2, "comer", "to eat", "beginner", "verb", true))
        words.add(Word(3, "manzana", "apple", "beginner", "noun", true))
        words.add(Word(4, "fuerte", "strong", "intermediate", "adjective", true))
        words.add(Word(5, "madera", "wood", "intermediate", "noun", true))
        words.add(Word(6, "entender", "to understand", "beginner", "verb", true))
        words.add(Word(7, "mesa", "table", "beginner", "noun", true))
        words.add(Word(8, "iglesia", "church", "intermediate", "noun", true))
        words.add(Word(9, "barbilla", "chin", "beginner", "noun", true))
        words.add(Word(10, "verter", "to pour", "intermediate", "verb", true))
        words.add(Word(11, "patear", "to kick", "beginner", "verb", true))
        words.add(Word(12, "brazo", "arm", "beginner", "noun", true))
        words.add(Word(13, "gusano", "worm", "beginner", "noun", true))
        words.add(Word(14, "afilar", "to sharpen", "intermediate", "verb", true))
        words.add(Word(15, "taladrar", "to drill", "intermediate", "verb", true))
        words.add(Word(16, "comparar", "to compare", "beginner", "verb", true))
        words.add(Word(17, "divertido", "fun", "beginner", "adjective", true))
        words.add(Word(18, "interesante", "interesting", "beginner", "adjective", true))
        words.add(Word(19, "mentiroso", "liar", "intermediate", "noun", true))
        words.add(Word(20, "sudadera", "hoodie", "beginner", "noun", true))
        words.add(Word(21, "vaso", "glass", "beginner", "noun", true))
        words.add(Word(22, "frontera", "border", "intermediate", "noun", true))
        words.add(Word(23, "piedra", "stone", "beginner", "noun", true))
        words.add(Word(24, "fachada", "facade", "advanced", "noun", true))
        words.add(Word(25, "inversor", "investor", "advanced", "noun", true))
        words.add(Word(26, "policía", "police officer", "beginner", "noun", true))
        words.add(Word(27, "gato", "cat", "beginner", "noun", true))
        words.add(Word(28, "desenlace", "outcome", "advanced", "noun", true))
        words.add(Word(29, "trama", "plot", "advanced", "noun", true))
        words.add(Word(30, "aparato", "device", "intermediate", "noun", true))
        words.add(Word(31, "triste", "sad", "beginner", "adjective", true))
        words.add(Word(32, "teclado", "keyboard", "intermediate", "noun", true))
        words.add(Word(33, "gorra", "cap/hat", "beginner", "noun", true))
        words.add(Word(34, "visitar", "to visit", "beginner", "verb", true))
        words.add(Word(35, "delgado", "thin", "beginner", "adjective", true))
        words.add(Word(36, "alto", "tall", "beginner", "adjective", true))
        words.add(Word(37, "gafas", "glasses", "beginner", "noun", true))
        words.add(Word(38, "listo", "clever", "beginner", "adjective", true))
        words.add(Word(39, "majo", "nice/kind", "beginner", "adjective", true))
        words.add(Word(40, "moneda", "coin", "beginner", "noun", true))
        words.add(Word(41, "perro", "dog", "beginner", "noun", true))
        words.add(Word(42, "casa", "house", "beginner", "noun", true))
        words.add(Word(43, "camisa", "shirt", "beginner", "noun", true))
        words.add(Word(44, "coche", "car", "beginner", "noun", true))
        words.add(Word(45, "libro", "book", "beginner", "noun", true))
        words.add(Word(46, "beber", "to drink", "beginner", "verb", true))
        words.add(Word(47, "leer", "to read", "beginner", "verb", true))
        words.add(Word(48, "correr", "to run", "beginner", "verb", true))
        words.add(Word(49, "abrir", "to open", "beginner", "verb", true))
        words.add(Word(50, "cerrar", "to close", "beginner", "verb", true))
        words.add(Word(51, "rápido", "fast", "beginner", "adjective", true))
        words.add(Word(52, "lento", "slow", "beginner", "adjective", true))
        words.add(Word(53, "frío", "cold", "beginner", "adjective", true))
        words.add(Word(54, "caliente", "hot", "beginner", "adjective", true))
        words.add(Word(55, "feliz", "happy", "beginner", "adjective", true))
        words.add(Word(56, "cuadro", "painting", "intermediate", "noun", true))
        words.add(Word(57, "carretera", "road", "intermediate", "noun", true))
        words.add(Word(58, "colina", "hill", "intermediate", "noun", true))
        words.add(Word(59, "pantalla", "screen", "intermediate", "noun", true))
        words.add(Word(60, "maleta", "suitcase", "intermediate", "noun", true))
        words.add(Word(61, "lograr", "to achieve", "intermediate", "verb", true))
        words.add(Word(62, "sugerir", "to suggest", "intermediate", "verb", true))
        words.add(Word(63, "evitar", "to avoid", "intermediate", "verb", true))
        words.add(Word(64, "fallar", "to fail", "intermediate", "verb", true))
        words.add(Word(65, "reparar", "to fix", "intermediate", "verb", true))
        words.add(Word(66, "tímido", "shy", "intermediate", "adjective", true))
        words.add(Word(67, "valiente", "brave", "intermediate", "adjective", true))
        words.add(Word(68, "oscuro", "dark", "intermediate", "adjective", true))
        words.add(Word(69, "amargo", "bitter", "intermediate", "adjective", true))
        words.add(Word(70, "asombroso", "amazing", "intermediate", "adjective", true))
        words.add(Word(71, "patrón", "pattern", "advanced", "noun", true))
        words.add(Word(72, "hechizo", "spell", "advanced", "noun", true))
        words.add(Word(73, "desdén", "disdain", "advanced", "noun", true))
        words.add(Word(74, "juicio", "judgement", "advanced", "noun", true))
        words.add(Word(75, "paradoja", "paradox", "advanced", "noun", true))
        words.add(Word(76, "manifestar", "to manifest", "advanced", "verb", true))
        words.add(Word(77, "renunciar", "to resign", "advanced", "verb", true))
        words.add(Word(78, "desplegar", "to unfold", "advanced", "verb", true))
        words.add(Word(79, "provenir", "to come from", "advanced", "verb", true))
        words.add(Word(80, "suponer", "to suppose", "advanced", "verb", true))
        words.add(Word(81, "sutil", "subtle", "advanced", "adjective", true))
        words.add(Word(82, "preciso", "precise", "advanced", "adjective", true))
        words.add(Word(83, "agudo", "sharp", "advanced", "adjective", true))
        words.add(Word(84, "prematuro", "premature", "advanced", "adjective", true))
        words.add(Word(85, "riguroso", "rigorous", "advanced", "adjective", true))
    }

    fun getWordsByLevelAndCategory(level: String, category: String): List<Word> {
        return words.filter { it.level == level && it.category == category }
    }

    fun listWordsByLevel(level: String): String {
        val matchedWords = words.filter { it.level.equals(level) }
        if (matchedWords.isEmpty()) {
            return "No words found for level: $level"
        } else {
            var listOfWords = ""
            for (word in matchedWords) {
                listOfWords += " ${word.givenWord} = (${word.translatedWord})\n"
            }
            return listOfWords
        }
    }





}
