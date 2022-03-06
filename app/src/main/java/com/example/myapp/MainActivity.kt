package com.example.myapp
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("testlogs", "in onCreate")
        setContentView(R.layout.activity_main)

        val registerbutton = findViewById<Button>(R.id.main_activity_button_input)
        registerbutton.setOnClickListener {
            Log.d("testlogs", "ClickRegister")
            Toast.makeText(this@MainActivity, "Registration complete.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        val loginbutton = findViewById<TextView>(R.id.simpleTextView)
            loginbutton.setOnClickListener {
                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
            }
        }

        }

    }



