package com.example.pr15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var questions: Array<String>
    private var currentQuestionIndex = 0
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questions = arrayOf(
            getString(R.string.a),
            getString(R.string.b),
            getString(R.string.c),
            getString(R.string.d),
            getString(R.string.h),
            getString(R.string.r),
            getString(R.string.j)
        )

        trueButton = findViewById<Button>(R.id.true_button)
        falseButton = findViewById<Button>(R.id.false_button)

        trueButton.setOnClickListener {
            checkAnswer(true)
            updateQuestion()
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
            updateQuestion()
        }

        updateQuestion()

    }

    private fun checkAnswer(isTrue: Boolean) {
        val correctAnswer = getCorrectAnswer()
        val isCorrect = (isTrue && correctAnswer) || (!isTrue && !correctAnswer)
        val messageResId = if (isCorrect) R.string.correct_toast else R.string.incorrect_toast
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
    private fun getCorrectAnswer(): Boolean {
        val correctAnswers = booleanArrayOf(
            false,
            true,  // ответ на второй вопрос
            true, // ответ на третий вопрос
            true,  // ответ на четвертый вопрос
            true,  // ответ на пятый вопрос
            true, // ответ на пятый вопрос
            true  // ответ на пятый вопрос
        )
        return correctAnswers[currentQuestionIndex]
    }

    private fun updateQuestion() {
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            val questionText = questions[currentQuestionIndex]
            val questionTextView = findViewById<TextView>(R.id.question_text_view)
            questionTextView.text = questionText
        } else {
            trueButton.isEnabled = false
            falseButton.isEnabled = false
            Toast.makeText(this, "Тест завершен", Toast.LENGTH_SHORT).show()
        }
    }
}
