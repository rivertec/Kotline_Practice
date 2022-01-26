package screen;

import extension.getNotEmptyString

class ShoppingCategory : Screen(){

    fun showCategories() {

        ScreenStack.push(this)

        val categories = arrayOf("Fashion", "Electronics", "Pet Supplies")

        for (category in categories) {
            println(category)
        }
        println("=> Enter # to view cart")

        val selectedCategory = readLine().getNotEmptyString()

//        while (selectedCategory.isNullOrBlank()) {
//            println("Please select a category")
//            selectedCategory = readLine()
//        }

        if (selectedCategory == "#") {

            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()

        } else {

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