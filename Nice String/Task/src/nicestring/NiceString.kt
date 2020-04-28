package nicestring

fun String.isNice(): Boolean {
    val noSubStrings = !any { contains("bu") || contains("ba") || contains("be") }

    val atLeast3Vowels = filter { char ->
        val vowels = listOf('a', 'e', 'i', 'o', 'u')
        (char in vowels)
    }.count() >= 3

    val hasDoubleLetters = zipWithNext().any { it.first == it.second }

    return noSubStrings && (atLeast3Vowels || hasDoubleLetters) || (atLeast3Vowels && hasDoubleLetters)
}