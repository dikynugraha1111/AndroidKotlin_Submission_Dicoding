package com.example.submission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailProduct : AppCompatActivity() {
    private var list: ArrayList<Product> = arrayListOf()

    companion object{
        const val ExtraName = "Name"
        const val ExtraDesc = "Desc"
        const val ExtraPrice= "Null"
        const val ExtraImg = "ExtraImg"
        const val ExtraDisp = "Display"
        const val ExtraSize = "Size"
        const val ExtraBatt = "Battery"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        val extraImgMove : ImageView = findViewById(R.id.img_move)
        val extraNameMove: TextView = findViewById(R.id.product_name)
        val extraPriceMove: TextView = findViewById(R.id.priceProduct)
        val extraDescMove : TextView = findViewById(R.id.productDesc)
        val extraDispMove : TextView = findViewById(R.id.contentSpecDisplay)
        val extraSizeMove : TextView = findViewById(R.id.contentSpecSize)
        val extraBattMove : TextView = findViewById(R.id.contentSpecBaterry)

        val image = intent.getIntExtra(ExtraImg,0)
        val name = intent.getStringExtra(ExtraName)
        val price= intent.getStringExtra(ExtraPrice)
        val desc = intent.getStringExtra(ExtraDesc)
        val disp = intent.getStringExtra(ExtraDisp)
        val size = intent.getStringExtra(ExtraSize)
        val batt = intent.getStringExtra(ExtraBatt)

        extraImgMove.setImageResource(image)
        extraNameMove.text = name
        extraPriceMove.text = price
        extraDescMove.text = desc
        extraDispMove.text = disp
        extraSizeMove.text = size
        extraBattMove.text = batt
    }
}
