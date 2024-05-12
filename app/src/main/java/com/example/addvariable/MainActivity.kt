package com.example.addvariable

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("variable_prefs", Context.MODE_PRIVATE)

        val editTextVar1 = findViewById<EditText>(R.id.edit_text_var1)
        val editTextVar2 = findViewById<EditText>(R.id.edit_text_var2)
        val buttonStoreVars = findViewById<Button>(R.id.button_store_vars)

        buttonStoreVars.setOnClickListener {
            val var1 = editTextVar1.text.toString().toIntOrNull() ?: 0
            val var2 = editTextVar2.text.toString().toIntOrNull() ?: 0
            storeVariables(var1, var2)
            startActivity(DisplayActivity.newIntent(this))
        }
    }

    private fun storeVariables(var1: Int, var2: Int) {
        sharedPreferences.edit().apply {
            putInt("var1", var1)
            putInt("var2", var2)
            apply()
        }
    }
}