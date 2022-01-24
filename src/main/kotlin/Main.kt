fun main(args: Array<String>) {

    println("Welcome, to the App")
    println("Please enter your name")

    val name = readLine()
    println("""
        Thank you, $name
        Please select a category.
        ***====================================***
    """.trimIndent())

}