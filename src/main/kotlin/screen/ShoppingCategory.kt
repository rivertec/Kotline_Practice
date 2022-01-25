package screen;

class ShoppingCategory {

    fun showCategories() {
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

        if (selectedCategory == "#") {
            //TODO 1. move to the cart
        } else {
            //TODO 2. Show selected category
            if (categories.contains(selectedCategory)) {
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)
            } else {
                showErrorMsg(selectedCategory)
            }

        }
    }

    private fun showErrorMsg(selectedCategory: String?) {
        println("[$selectedCategory] does not exist. Please enter again.")
        showCategories()
    }
}