package com.plenium.ecommerce

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Simular carga inicial y verificación de sesión
        Handler(Looper.getMainLooper()).postDelayed({
            // Por ahora, siempre va al MainActivity (Home)
            // Aquí se puede agregar lógica de verificación de sesión más adelante
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000) // 3 segundos de splash
    }
}
