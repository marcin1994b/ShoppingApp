package com.example.marcin.shoppingapp.Presenter

import com.example.marcin.shoppingapp.Model.Product

/**
 * Created by Marcin on 19.09.2017.
 */
interface Contracts {

    interface MainLayout{
        fun setProductsTextViews(list: ArrayList<Product>)
        fun setBonusTextViews(list: ArrayList<String>)
        fun setCost(cost: Double)
    }

    interface ShoppingPresenter{
        fun onViewCreate()
        fun onButtonClicked(list: ArrayList<Int>, bonusesList: ArrayList<Boolean>)
    }
}