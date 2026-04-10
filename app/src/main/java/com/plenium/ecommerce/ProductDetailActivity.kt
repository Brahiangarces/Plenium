package com.plenium.ecommerce

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val product = intent.getSerializableExtra("product") as? Product
        product?.let {
            setupProductDetails(it)
        }
        
        setupBackButton()
    }

    private fun setupProductDetails(product: Product) {
        findViewById<TextView>(R.id.productName).text = product.name
        findViewById<TextView>(R.id.productPrice).text = "$${product.price} COP"
        findViewById<TextView>(R.id.productDescription).text = product.description
        findViewById<TextView>(R.id.productStock).text = "Stock: ${product.stock} unidades"
        
        // Aquí se puede configurar la imagen del producto
        // findViewById<ImageView>(R.id.productImage).setImageResource(getImageResource(product.imageKey))
    }

    private fun setupBackButton() {
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }
}
