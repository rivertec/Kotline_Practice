package screen

import LINE_DIVIDER
import data.CartItems

class ShoppingCart {

    private val products = CartItems.products

    fun showCartItems() {
        if (products.isNotEmpty()) {
            println(
                products.keys.joinToString(
                    separator = ", \n",
                    prefix = """
                        $LINE_DIVIDER
                        Your Cart
                        
                    """.trimIndent()
                ) { product ->
                    "Category: ${product.categoryLabel} / Product: ${product.name} / Amt: ${products[product]}"
                }
            )
        } else {
            println("""
                It is empty.
            """.trimIndent())
        }
    }
}
