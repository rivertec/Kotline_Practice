package screen

class ShoppingHome {

    fun start() {

        showWelcomeMessage()
        showCategories()

    }

    private fun showWelcomeMessage() {
        println("Welcome, to the App")
        println("Please enter your name")

        val name = readLine()
        println(
            """
            Thank you, $name
            Please select a category.
            ***====================================***
        """.trimIndent()
        )
    }

    private fun showCategories() {
        val shoppingCategory = ShoppingCategory()
        shoppingCategory.showCategories()
    }


}