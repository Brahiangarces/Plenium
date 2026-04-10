package com.plenium.ecommerce

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val category = intent.getStringExtra("category") ?: "coffee"
        val searchQuery = intent.getStringExtra("search")
        
        setupProducts(category, searchQuery)
        setupFilters()
    }

    private fun setupProducts(category: String, searchQuery: String?) {
        val productsRecyclerView = findViewById<RecyclerView>(R.id.productsRecyclerView)
        val products = getProductsByCategory(category, searchQuery)
        
        productsRecyclerView.layoutManager = GridLayoutManager(this, 2)
        productsRecyclerView.adapter = ProductAdapter(products) { product ->
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("product", product)
            startActivity(intent)
        }
    }

    private fun setupFilters() {
        val spinnerSort = findViewById<Spinner>(R.id.spinnerSort)
        val sortOptions = arrayOf("Ordenar por", "Precio: Menor a Mayor", "Precio: Mayor a Menor", "Popularidad")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sortOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSort.adapter = adapter
    }

    private fun getProductsByCategory(category: String, searchQuery: String?): List<Product> {
        return when (category) {
            "coffee" -> getCoffeeProducts()
            "accessories" -> getAccessoryProducts()
            else -> emptyList()
        }
    }

    private fun getCoffeeProducts(): List<Product> {
        return listOf(
            // Café en grano
            Product("Pergamino Antioquia", 45000, "Café en grano 500g - Medellín", "coffee_bean", 10),
            Product("Devoción Toro", 38000, "Café en grano 340g", "coffee_bean", 15),
            Product("Amor Perfecto Origen Huila", 42000, "Café en grano 250g", "coffee_bean", 8),
            Product("Juan Valdez Origen Sierra Nevada", 48000, "Café en grano 500g", "coffee_bean", 12),
            
            // Café molido
            Product("Sello Rojo Tradicional", 28000, "Café molido 500g", "coffee_ground", 20),
            Product("Colcafé Tradicional", 18000, "Café molido 250g", "coffee_ground", 25),
            Product("Juan Valdez Volcán Molido", 32000, "Café molido 340g", "coffee_ground", 18),
            Product("Café Quindío Molido", 26000, "Café molido 500g", "coffee_ground", 22),
            
            // Café especial
            Product("San Alberto Geisha", 85000, "Café especial 250g", "coffee_special", 5),
            Product("Amor Perfecto Bourbon Rosado", 78000, "Café especial 250g", "coffee_special", 6),
            Product("Devoción Honey Process", 72000, "Café especial 250g", "coffee_special", 4),
            Product("Matiz Café Especial", 68000, "Café especial 250g", "coffee_special", 7)
        )
    }

    private fun getAccessoryProducts(): List<Product> {
        return listOf(
            // Molinos
            Product("Molino manual Hario Skerton", 350000, "Molino manual de cerámica", "grinder_manual", 8),
            Product("Molino manual Timemore C2", 420000, "Molino manual precision", "grinder_manual", 6),
            Product("Molino manual Porlex Mini", 280000, "Molino manual compacto", "grinder_manual", 10),
            Product("Molino eléctrico Oster café", 180000, "Molino eléctrico automático", "grinder_electric", 15),
            
            // Básculas
            Product("Báscula Hario V60 Drip Scale", 220000, "Báscula precisa para café", "scale", 12),
            Product("Báscula Timemore Black Mirror", 280000, "Báscula digital profesional", "scale", 9),
            
            // Termómetros
            Product("Termómetro barista acero inoxidable", 45000, "Termómetro profesional", "thermometer", 20),
            Product("Termómetro digital café", 35000, "Termómetro digital preciso", "thermometer", 25),
            
            // Hervidores
            Product("Hervidor cuello de ganso eléctrico", 150000, "Hervidor eléctrico precision", "kettle_electric", 14),
            Product("Hervidor acero inoxidable barista", 120000, "Hervidor tradicional", "kettle_stove", 18)
        )
    }
}
