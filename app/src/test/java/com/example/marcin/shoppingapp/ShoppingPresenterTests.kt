package com.example.marcin.shoppingapp

import com.example.marcin.shoppingapp.Model.BonusesManager
import com.example.marcin.shoppingapp.Model.ProductsManager
import com.example.marcin.shoppingapp.Presenter.Contracts
import com.example.marcin.shoppingapp.Presenter.ShoppingPresenter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Marcin on 19.09.2017.
 */
@RunWith(MockitoJUnitRunner::class)
class ShoppingPresenterTests {

    @Mock lateinit var view: Contracts.MainLayout
    @Mock lateinit var productManager: ProductsManager
    @Mock lateinit var bonusesManager: BonusesManager

    lateinit var shoppingPresenter: ShoppingPresenter

    @Before
    fun setUp(){
        shoppingPresenter = ShoppingPresenter(view, productManager, bonusesManager)
    }

    @Test
    fun test(){

    }

}