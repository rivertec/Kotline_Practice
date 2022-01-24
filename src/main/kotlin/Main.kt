fun main(args: Array<String>) {

    println("Welcome, to the App")
    println("Please enter your name")

    val name = readLine()
    println("""
        Thank you, $name
        Please select a category.
        ***====================================***
    """.trimIndent())

    val categories = arrayOf("Fashion", "Electronics", "Pet Supplies")

    for (category in categories) {
        println(category)
    }
    println("=> Enter # to view cart")

    var selectedCategory = readLine()

    while (selectedCategory.isNullOrBlank()) {
        println("Please select a category")
        selectedCategory = readLine()
    }

    if(selectedCategory == "#") {
        //TODO 1. move to the cart
    } else {
        //TODO 2. Show selected category

    }



}