package com.example.submission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var rvProduct: RecyclerView
    private var list: ArrayList<Product> = arrayListOf()
    private var title: String = "Home"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvProduct = findViewById(R.id.rv_sell)
        rvProduct.setHasFixedSize(true)

        list.addAll(Seller_Data.listData)
        showRecyclerList()
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showRecyclerList() {
        rvProduct.layoutManager = LinearLayoutManager(this)
        val listProductAdapter = ListProductAdapter(list)
        rvProduct.adapter = listProductAdapter

        listProductAdapter.setOnItemClickCallback(object : ListProductAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Product) {
                val move = Intent (this@MainActivity ,DetailProduct::class.java)
                val nameProductMove = data.nameProduct
                val productDescMove = data.productDesc
                val productImg = data.photo
                val priceProduct = data.priceProduct
                val contentSpecDisplay = data.contentSpecDisplay
                val contentSpecSize = data.contentSpecSize
                val contentSpecBattery = data.contentSpecBattery

                move.putExtra(DetailProduct.ExtraName, nameProductMove)
                move.putExtra(DetailProduct.ExtraDesc, productDescMove)
                move.putExtra(DetailProduct.ExtraImg,productImg)
                move.putExtra(DetailProduct.ExtraPrice,priceProduct)
                move.putExtra(DetailProduct.ExtraDisp,contentSpecDisplay)
                move.putExtra(DetailProduct.ExtraSize,contentSpecSize)
                move.putExtra(DetailProduct.ExtraBatt,contentSpecBattery)
                startActivity(move)
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.home -> {
                title = "Home"
                val intentHome = Intent(this,MainActivity::class.java)
                startActivity(intentHome)
            }
            R.id.profile -> {
                title = "Profile"
                val intentProfile = Intent(this, ProfileActivity::class.java)
                startActivity(intentProfile)
            }
        }
        setActionBarTitle(title)
    }


}
