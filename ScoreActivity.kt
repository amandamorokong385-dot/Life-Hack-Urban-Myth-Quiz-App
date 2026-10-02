package com.example.lifehackmyth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_score)

        val score =
            intent.getIntExtra("score", 0)
        val total =
            intent. getIntExtra("total", 2)

        val tv =
            findViewById<TextView>(R.id.tvScore)
        tv.text = "You scored $score / $total"

        val btnRestart = findViewById<Button>(R.id.btnRestart)
        btnRestart.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}

