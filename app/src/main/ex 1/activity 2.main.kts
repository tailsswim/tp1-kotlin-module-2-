
package com.example.myfirstapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textViewWelcome = findViewById<TextView>(R.id.textViewWelcome)
        val bundle = intent.extras

        if (bundle != null) {
            val name = bundle.getString("USER_NAME", "")
            textViewWelcome.text = "Bienvenue, $name !"
        }
    }
}
