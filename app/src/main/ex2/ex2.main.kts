#!/usr/bin/env kotlin

package com.example.savestateapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Déclaration des vues
    private lateinit var editTextName: EditText
    private lateinit var buttonWelcome: Button
    private lateinit var textViewWelcome: TextView

    // Clé pour la sauvegarde de l'état
    private val KEY_WELCOME_MESSAGE = "welcome_message"
    private var currentWelcomeMessage: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation des vues
        editTextName = findViewById(R.id.editTextName)
        buttonWelcome = findViewById(R.id.buttonWelcome)
        textViewWelcome = findViewById(R.id.textViewWelcome)

        // Action du bouton
        buttonWelcome.setOnClickListener {
            val name = editTextName.text.toString().trim()
            if (name.isNotEmpty()) {
                currentWelcomeMessage = "Bienvenue, $name !"
                textViewWelcome.text = currentWelcomeMessage
            } else {
                editTextName.error = "Veuillez entrer un nom"
            }
        }
    }

    // 1. Sauvegarde de l'état avant la destruction de l'activité (rotation)
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // On sauvegarde le message actuellement affiché
        outState.putString(KEY_WELCOME_MESSAGE, currentWelcomeMessage)
    }

    // 2. Restauration de l'état après la recréation de l'activité
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // On récupère le message sauvegardé
        currentWelcomeMessage = savedInstanceState.getString(KEY_WELCOME_MESSAGE, "")
        // On réaffiche le message dans le TextView
        textViewWelcome.text = currentWelcomeMessage
    }
}
