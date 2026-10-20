package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            val bundle = Bundle()

            bundle.putString("USER_NAME", name)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}
