package screen

import LINE_DIVIDER
import extension.getNotEmptyString

class ShoppingHome {

    fun start() {

        showWelcomeMessage()
        showCategories()

    }

    private fun showWelcomeMessage() {
        println("Welcome, to the App")
        println("Please enter your name")

        val name = readLine().getNotEmptyString()
        println(
            """
            Thank you, $name
            Please select a category.
            $LINE_DIVIDER
        """.trimIndent()
        )
    }

    private fun showCategories() {
        val shoppingCategory = ShoppingCategory()
        shoppingCategory.showCategories()
    }


}