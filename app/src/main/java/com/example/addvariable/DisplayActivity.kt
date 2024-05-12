package com.example.addvariable

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        sharedPreferences = getSharedPreferences("variable_prefs", Context.MODE_PRIVATE)

        val textViewVar1 = findViewById<TextView>(R.id.text_view_var1)
        val textViewVar2 = findViewById<TextView>(R.id.text_view_var2)
        val textViewSum = findViewById<TextView>(R.id.text_view_sum)

        val var1 = sharedPreferences.getInt("var1", 0)
        val var2 = sharedPreferences.getInt("var2", 0)

        textViewVar1.text = "Variable 1: $var1"
        textViewVar2.text = "Variable 2: $var2"
        textViewSum.text = "Sum: ${var1 + var2}"
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, DisplayActivity::class.java)
        }
    }
}