package extension

fun String?.getNotEmptyString(): String {
    var input = this
    while (input.isNullOrBlank()) {
        println("Please enter valid value.")
        input = readLine()
    }
    return input.trim()
}

fun String?.getNotEmptyInt(): Int {
    var input = this?.trim()
    while (input.isNullOrEmpty() || input.toIntOrNull() == null) {
        println("Please enter valid value.")
        input = readLine()
    }
    return input.toInt()
}