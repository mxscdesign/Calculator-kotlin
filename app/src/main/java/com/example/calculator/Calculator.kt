package com.example.calculator

import kotlinx.android.synthetic.main.activity_main.*

class Calculator(private val context: MainActivity) {
    fun addDigit(str: String) {
        if (context.result_text.text != "") {
            context.math_operation.text = context.result_text.text
            context.result_text.text = ""
        }
        context.math_operation.append(str)
    }

    fun sqrt() {
        if (context.math_operation.text.isNotEmpty() && context.result_text.text.toString()
                .isEmpty()
        )
            context.math_operation.text =
                Math.sqrt(context.math_operation.text.toString().toDouble()).toString()
        else {
            context.math_operation.text =
                Math.sqrt(context.result_text.text.toString().toDouble()).toString()
            context.result_text.text = ""
        }
    }

    fun clear() {
        context.math_operation.text = ""
        context.result_text.text = ""
    }

    fun invert() {
        if (context.math_operation.text.isNotEmpty() && context.result_text.text.toString()
                .isEmpty()
        )
            context.math_operation.text =
                (context.math_operation.text.toString().toDouble() * (-1)).toString()
        else {
            context.math_operation.text =
                (context.result_text.text.toString().toDouble() * (-1)).toString()
            context.result_text.text = ""
        }
    }

    fun delete() {
        if (context.math_operation.text.isNotEmpty()) {
            val str = context.math_operation.text.toString()
            if (str.isNotEmpty()) {
                context.math_operation.text = str.substring(0, str.length - 1)
                context.result_text.text = ""
            }
        }
    }

    private fun calculate(num1: Double, num2: Double, operation: String) {
        when (operation) {
            "minus" -> context.result_text.text = (num1 - num2).toString()
            "plus" -> context.result_text.text = (num1 + num2).toString()
            "mult" -> context.result_text.text = (num1 * num2).toString()
            "div" -> context.result_text.text = (num1 / num2).toString()
        }
    }

    fun result() {
        for (char in context.math_operation.text.indices - 0)
            when {
                context.math_operation.text[char] == '-' -> {
                    if (context.math_operation.text[0] != '-') {
                        val first = context.math_operation.text.toString().substringBefore('-')
                        val second = context.math_operation.text.toString().substringAfter('-')
                        calculate(first.toDouble(), second.toDouble(), "minus")
                    } else {
                        val first = context.math_operation.text.toString().substringAfter('-')
                            .substringBefore('-')
                        val second = context.math_operation.text.toString().substringAfter('-')
                            .substringAfter('-')
                        calculate("-$first".toDouble(), second.toDouble(), "minus")
                    }
                }
                context.math_operation.text[char] == '+' -> {
                    val first = context.math_operation.text.toString().substringBefore('+')
                    val second = context.math_operation.text.toString().substringAfter('+')
                    calculate(first.toDouble(), second.toDouble(), "plus")
                }
                context.math_operation.text[char] == '*' -> {
                    val first = context.math_operation.text.toString().substringBefore('*')
                    val second = context.math_operation.text.toString().substringAfter('*')
                    calculate(first.toDouble(), second.toDouble(), "mult")
                }
                context.math_operation.text[char] == '/' -> {
                    val first = context.math_operation.text.toString().substringBefore('/')
                    val second = context.math_operation.text.toString().substringAfter('/')
                    calculate(first.toDouble(), second.toDouble(), "div")
                }
            }
    }
}