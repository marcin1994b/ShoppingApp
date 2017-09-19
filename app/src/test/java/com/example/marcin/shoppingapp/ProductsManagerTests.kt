package com.example.marcin.shoppingapp

import com.example.marcin.shoppingapp.Model.ProductsManager
import junit.framework.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Marcin on 19.09.2017.
 */
class ProductsManagerTests {

    private lateinit var productsManager : ProductsManager
    private lateinit var bonusesList: ArrayList<Boolean>

    @Before
    fun setUp(){
        productsManager = ProductsManager()
        bonusesList = ArrayList(listOf(false, false, false))
    }

    @Test
    fun isNumberOfSecondProductsZero(){
        Assert.assertEquals(0, productsManager.productsList[1].number)
    }

    @Test
    fun isNumberOfFirstProducts3WhenSetItTo3(){
        productsManager.setNumberOfProduct(2,3)
        Assert.assertEquals(3, productsManager.productsList[2].number)
    }

    @Test
    fun isProductsCostGoodWhenThirdProductsCountIs5(){
        productsManager.setNumberOfProduct(2,5)
        Assert.assertEquals(5*productsManager.productsList[2].price, productsManager.calProductsCost(bonusesList))
    }

    @Test
    fun isProductsCostGoodWhenThirdProductsCountIs5AndSecondProductsCountIs10(){
        productsManager.setNumberOfProduct(2,5)
        productsManager.setNumberOfProduct(1,10)

        Assert.assertEquals(
                5*productsManager.productsList[2].price + 10*productsManager.productsList[1].price,
                productsManager.calProductsCost(bonusesList))
    }

    @Test
    fun testFirstDiscountWhenFirstProductsCountIs2AndFirstDiscountIsTrue(){
        productsManager.setNumberOfProduct(0, 2)
        bonusesList[0] = true
        Assert.assertEquals(2.5,
                productsManager.calProductsCost(bonusesList))
    }

    @Test
    fun testShouldApplyFirstDiscount(){
        productsManager.setNumberOfProduct(0, 3)
        bonusesList[0] = true
        Assert.assertTrue(productsManager.shouldApplyFirstDiscount(bonusesList))
    }

    @Test
    fun testFirstDiscountWhenFirstProductsCountIs3AndFirstDiscountIsTrue(){
        productsManager.setNumberOfProduct(0, 3)
        bonusesList[0] = true
        Assert.assertEquals(2.5, productsManager.calProductsCost(bonusesList))
    }

    @Test
    fun testFirstDiscountWhenSecondProductsCcuntIs3AndFirstDiscountIsTrue(){
        productsManager.setNumberOfProduct(1, 3)
        bonusesList[0] = true
        Assert.assertEquals(6.0, productsManager.calProductsCost(bonusesList))
    }

    @Test
    fun ifFor6FirstProductsApplyDiscountOnlyOneTime(){
        productsManager.setNumberOfProduct(0, 6)
        bonusesList[0] = true
        Assert.assertEquals(6.25, productsManager.calProductsCost(bonusesList))
    }

    @Test
    fun ifApplyFirstAndSecondDiscountForGoodConditions(){
        productsManager.setNumberOfProduct(0,3)
        productsManager.setNumberOfProduct(1,1)
        productsManager.setNumberOfProduct(2,1)
        bonusesList[0] = true
        bonusesList[1] = true
        Assert.assertEquals(4.275, productsManager.calProductsCost(bonusesList))
    }

    @Test
    fun ifApplyFirstAndSecondDiscountForBadConditions(){
        productsManager.setNumberOfProduct(0,2)
        productsManager.setNumberOfProduct(1,1)
        bonusesList[0] = true
        bonusesList[1] = true
        Assert.assertEquals(4.5, productsManager.calProductsCost(bonusesList))
    }
}