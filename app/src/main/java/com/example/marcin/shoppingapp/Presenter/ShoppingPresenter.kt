package com.example.marcin.shoppingapp.Presenter

import com.example.marcin.shoppingapp.Model.BonusesManager
import com.example.marcin.shoppingapp.Model.ProductsManager

/**
 * Created by Marcin on 19.09.2017.
 */
class ShoppingPresenter(val view: Contracts.MainLayout, val productsManager: ProductsManager,
                        val bonusesManager: BonusesManager): Contracts.ShoppingPresenter {

    /*private val productsManager : ProductsManager = ProductsManager()
    private val bonusesManager : BonusesManager = BonusesManager()*/

    override fun onViewCreate() {
        view.setProductsTextViews(productsManager.productsList)
        view.setBonusTextViews(bonusesManager.bonusesList)
    }

    override fun onButtonClicked(list: ArrayList<Int>, bonusesList: ArrayList<Boolean>) {
        setProductsNumbers(list)
        view.setCost(productsManager.calProductsCost(bonusesList))
    }

    private fun setProductsNumbers(list: ArrayList<Int>){
        var index = 0
        for(item in productsManager.productsList){
            item.number = list[index]
            index++
        }
    }





}