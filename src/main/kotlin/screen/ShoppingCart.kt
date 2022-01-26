package screen

import data.CartItems

class ShoppingCart {

    private val products = CartItems.products

    fun showCartItems() {
        if (products.isNotEmpty()) {
            println(
                products.keys.joinToString(
                    separator = ", \n",
                    prefix = """
                        ***====================================***
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
