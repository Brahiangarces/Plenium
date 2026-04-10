package com.plenium.ecommerce

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar categorías
        setupCategories()
        setupSearchBar()
    }

    private fun setupCategories() {
        val categoriesRecyclerView = findViewById<RecyclerView>(R.id.categoriesRecyclerView)
        val categories = listOf(
            Category("Café", "coffee_main"),
            Category("Accesorios cafeteros", "accessories")
        )
        
        categoriesRecyclerView.layoutManager = GridLayoutManager(this, 2)
        categoriesRecyclerView.adapter = CategoryAdapter(categories) { category ->
            when (category.name) {
                "Café" -> {
                    val intent = Intent(this, ProductListActivity::class.java)
                    intent.putExtra("category", "coffee")
                    startActivity(intent)
                }
                "Accesorios cafeteros" -> {
                    val intent = Intent(this, ProductListActivity::class.java)
                    intent.putExtra("category", "accessories")
                    startActivity(intent)
                }
            }
        }
    }

    private fun setupSearchBar() {
        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    val intent = Intent(this@MainActivity, ProductListActivity::class.java)
                    intent.putExtra("search", it)
                    startActivity(intent)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }
}

data class Category(val name: String, val imageKey: String)
