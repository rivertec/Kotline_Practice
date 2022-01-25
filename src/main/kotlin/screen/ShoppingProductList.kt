package screen

import data.Product

class ShoppingProductList {
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
        product ->
        product.categoryLabel
    }

    fun showProducts(selectedCategory: String) {
        val categoryProducts = categories[selectedCategory]
        if (!categoryProducts.isNullOrEmpty()) {
            println("""
                ***====================================***
                Selected [$selectedCategory] products.
            """.trimIndent())
            val productSize = categoryProducts.size
            for (index in 0 until productSize) {
                println("${index + 1}. ${categoryProducts[index].name}")
            }
        } else {
            showEmptyProductMsg(selectedCategory)
        }
    }

    private fun showEmptyProductMsg(selectedCategory: String) {
        println("[$selectedCategory] is not prepared yet.")
    }
}