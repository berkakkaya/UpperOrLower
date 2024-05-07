package com.berkakkaya.upperorlower

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var chosen: Int = (1..100).random()
    var guess: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun restartGame(view: View) {
        chosen = (1..100).random()
        guess = null

        val textView: TextView = findViewById(R.id.textView)
        textView.text = "1 ile 100 arasında sayı tuttum, haydi bul!"

        val inputLayout: TextInputLayout = findViewById(R.id.inputLayout)
    }

    fun checkGuess(view: View) {
        val inputLayout: TextInputLayout = findViewById(R.id.inputLayout)

        try {
            guess = inputLayout.editText?.text.toString().toInt()
        } catch (e: NumberFormatException) {
            return
        }

        val textView: TextView = findViewById(R.id.textView)
        textView.text = when {
            guess!! > chosen -> "Tahmin tutmadı, daha küçük bir sayı giriniz"
            guess!! < chosen -> "Tahmin tutmadı, daha büyük bir sayı giriniz"
            else -> "Sayıyı buldunuz!"
        }
    }
}
