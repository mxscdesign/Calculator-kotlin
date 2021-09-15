package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener { Calculator(this).addDigit("0") }
        btn_1.setOnClickListener { Calculator(this).addDigit("1") }
        btn_2.setOnClickListener { Calculator(this).addDigit("2") }
        btn_3.setOnClickListener { Calculator(this).addDigit("3") }
        btn_4.setOnClickListener { Calculator(this).addDigit("4") }
        btn_5.setOnClickListener { Calculator(this).addDigit("5") }
        btn_6.setOnClickListener { Calculator(this).addDigit("6") }
        btn_7.setOnClickListener { Calculator(this).addDigit("7") }
        btn_8.setOnClickListener { Calculator(this).addDigit("8") }
        btn_9.setOnClickListener { Calculator(this).addDigit("9") }

        dot_btn.setOnClickListener { Calculator(this).addDigit(".") }
        minus_btn.setOnClickListener { Calculator(this).addDigit("-") }
        plus_btn.setOnClickListener { Calculator(this).addDigit("+") }
        mult_btn.setOnClickListener { Calculator(this).addDigit("*") }
        division_btn.setOnClickListener { Calculator(this).addDigit("/") }

        sqrt_btn.setOnClickListener { Calculator(this).sqrt() }
        clear_btn.setOnClickListener { Calculator(this).clear() }
        invert_btn.setOnClickListener { Calculator(this).invert() }
        delete_btn.setOnClickListener { Calculator(this).delete() }

        equal_btn.setOnClickListener { Calculator(this).result() }
    }
}