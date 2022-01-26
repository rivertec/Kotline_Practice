package screen

import LINE_DIVIDER
import data.CartItems
import extension.getNotEmptyString

class ShoppingCart : Screen() {

    private val products = CartItems.products

    fun showCartItems() {

        ScreenStack.push(this)

        if (products.isNotEmpty()) {
            println(
                products.keys.joinToString(
                    separator = ", \n",
                    prefix = """
                        $LINE_DIVIDER
                        Your Cart
                        
                    """.trimIndent()
                ) { product ->
                    "Category: ${product.categoryLabel} / Product: ${product.name} / Amount: ${products[product]}"
                }
            )
        } else {
            println("""
                It is empty.
            """.trimIndent()
            )
        }

        showPreviousScreenOption()

    }

    private fun showPreviousScreenOption() {
        println(
            """
                
                $LINE_DIVIDER
                Move back to previous page? (y/n)
            """.trimIndent()
        )
        when (readLine().getNotEmptyString()) {
            "y" -> {
                moveToPreviousScreen()
            }
            "n" -> {
                showCartItems()
            }
            else -> {
                // TODO 재입력 요청
            }
        }
    }

    private fun moveToPreviousScreen() {
        ScreenStack.pop()
        when (val previousScreen = ScreenStack.peek()) {
            is ShoppingCategory -> {
                previousScreen.showCategories()
            }
            is ShoppingProductList -> {
                previousScreen.showProducts()
            }
            is ShoppingCart, is ShoppingHome -> {

            }
        }
    }
}
