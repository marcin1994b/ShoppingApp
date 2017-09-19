package com.example.marcin.shoppingapp.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.marcin.shoppingapp.Model.BonusesManager
import com.example.marcin.shoppingapp.Model.Product
import com.example.marcin.shoppingapp.Model.ProductsManager
import com.example.marcin.shoppingapp.Presenter.Contracts
import com.example.marcin.shoppingapp.Presenter.ShoppingPresenter
import com.example.marcin.shoppingapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contracts.MainLayout {

    lateinit var presenter : ShoppingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = ShoppingPresenter(this, ProductsManager(), BonusesManager())
        presenter.onViewCreate()

        init()
    }

    override fun setProductsTextViews(list: ArrayList<Product>) {
        firstProductTextView.text = list[0].name
        secondProductTextView.text = list[1].name
        thirdProductTextView.text = list[2].name
        fourthProductTextView.text = list[3].name
        fifthProductTextView.text = list[4].name
    }

    override fun setBonusTextViews(list: ArrayList<String>) {
        firstBonusTextView.text = list[0]
        secondBonusTextView.text = list[1]
        thirdBonusTextView.text = list[2]
    }

    override fun setCost(cost: Double) {
        costTextView.text = cost.toString()
    }

    fun init(){
        costTextView.text = "0.00"
        initButton()
    }

    private fun initButton(){
        button.setOnClickListener {
            presenter.onButtonClicked(getNumbersOfProducts(), getBonusesChecked())
        }
    }

    private fun getBonusesChecked(): ArrayList<Boolean>{
        return ArrayList(listOf(firstBonusCheckBox.isChecked,
                secondBonusCheckBox.isChecked, thirdBonusCheckBox.isChecked))
    }

    private fun getNumbersOfProducts() : ArrayList<Int>{
        return ArrayList(listOf(
                getProductNumberFromString(firstProductEditText.text.toString()),
                getProductNumberFromString(secondProductEditText.text.toString()),
                getProductNumberFromString(thirdProductEditText.text.toString()),
                getProductNumberFromString(fourthProductEditText.text.toString()),
                getProductNumberFromString(fifthProductEditText.text.toString())
        ))
    }

    private fun getProductNumberFromString(str: String): Int{
        if(str.isBlank()){
            return 0
        }
        return str.toInt()
    }




}
