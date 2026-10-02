package com.example.lifehackmyth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    data class Q(val text: String, val answer: Boolean)

    private val questions = listOf(
        Q("You can charge your phone in the microwave for 10 secs?", false),
        Q("Onions make you cry because of gas?", true)
    )
    private var current = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_quiz)
        val tvQ = findViewById<TextView>(R.id.tvQuestion)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)

        fun showQuestion() {
            if (current < questions.size) {
                tvQ.text = questions[current].text
            } else {
                val i = Intent(
                    this,
                    ScoreActivity::class.java
                )
                i.putExtra("score", score)
                i.putExtra("total", questions.size)
                startActivity(i)
                finish()
            }
        }
        btnTrue.setOnClickListener {
            if (questions[current].answer == true) score++
            current++
            showQuestion()
        }
        btnFalse.setOnClickListener {
            if (questions[current].answer == false) score++
            current++
            showQuestion()
        }

        showQuestion()
        }
    }
