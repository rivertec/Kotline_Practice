package screen

import LINE_DIVIDER
import data.CartItems
import data.Product
import extension.getNotEmptyInt
import extension.getNotEmptyString

class ShoppingProductList(private val selectedCategory: String) : Screen() {

    private val products = arrayOf(
        Product("Fashion", "Sweaters"),
        Product("Fashion", "Pants"),
        Product("Electronics", "Bluetooth"),
        Product("Electronics", "Monitors"),
        Product("Electronics", "Lights"),
        Product("Pet Supplies", "Kibble"),
        Product("Pet Supplies", "Canned Food"),
        Product("Pet Supplies", "Treats"),
        Product("Pet Supplies", "Tooth Paste"),
        )

    private val categories: Map<String, List<Product>> = products.groupBy {
        product -> product.categoryLabel
    }

    fun showProducts() {

        ScreenStack.push(this)

        val categoryProducts = categories[selectedCategory]
        if (!categoryProducts.isNullOrEmpty()) {
            println("""
                $LINE_DIVIDER
                Selected [$selectedCategory] products.
            """.trimIndent())

            categoryProducts.forEachIndexed { index, product ->
                println("${index + 1}. ${product.name}")
            }
            showCartOption(categoryProducts, )
        } else {
            showEmptyProductMsg(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts: List<Product>) {
        println(
            """
            $LINE_DIVIDER
            Please enter product number to put in cart.
            """.trimIndent()
        )

        val selectedIndex = readLine().getNotEmptyInt() - 1
        categoryProducts.getOrNull(selectedIndex)?.let { product ->
            CartItems.addProduct(product)
            println("=> Enter # to view your cart, * to keep shopping")
            val answer = readLine().getNotEmptyString()
            if (answer == "#"){

                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()

            } else if (answer == "*"){

                showProducts()

            } else {
                //TODO ??? ??? ?????? ????????? ??????
            }
        } ?: kotlin.run {
            println("$selectedIndex does not exist, please enter again.")
            showProducts()
        }
    }

    private fun showEmptyProductMsg(selectedCategory: String) {
        println("[$selectedCategory] is not prepared yet.")
    }
}

