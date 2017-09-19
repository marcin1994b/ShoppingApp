package com.example.marcin.shoppingapp.Model

/**
 * Created by Marcin on 19.09.2017.
 */
open class ProductsManager {

    var productsList : ArrayList<Product> = ArrayList(listOf(Product("Mleko", 1.25, 0),
            Product("Chleb", 2.00, 0), Product("Jajko", 0.25, 0), Product("Maslo", 4.50, 0), Product("Ser", 4.00, 0)))

    fun setNumberOfProduct(product: Int, number: Int){
        productsList[product].number = number
    }

    fun calProductsCost(bonusesList: ArrayList<Boolean>) : Double{
        var cost = 0.00
        for(item in productsList){
            cost += (item.number * item.price)
        }
        if(shouldApplyFirstDiscount(bonusesList)){
            cost -= productsList[0].price
        }
        if(shouldApplySecondDiscount(bonusesList)){
            cost = cost - (cost*0.1)
        }
        return cost
    }

    // buy 3 milk get one free
    fun shouldApplyFirstDiscount(list: ArrayList<Boolean>): Boolean{
        if(productsList[0].number >= 3 && list[0] ){
            return true
        }
        return false
    }

    //buy 3 different products, get 10% discount
    fun shouldApplySecondDiscount(list: ArrayList<Boolean>) : Boolean{
        if(countingDifferentProducts() >= 3 && list[1]){
            return true
        }
        return false
    }

    private fun countingDifferentProducts(): Int{
        var counter = 0
        for(item in productsList){
            if(item.number > 0){
                counter++
            }
        }
        return counter
    }
}