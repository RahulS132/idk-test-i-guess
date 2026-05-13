package com.example.a8testing

class Calculator(private val logger: Logger) {
    fun add(a: Int, b: Int): Int {
        val result = a + b
        logger.log("Adding $a and $b: $result")
        return result }
    fun subtract(a: Int, b: Int): Int {
        val result = a - b
        logger.log("Subtracting $a and $b: $result")
        return result }

    fun multiply(a: Int, b: Int): Int {
        val result = a * b
        logger.log("Multiplying $a and $b: $result")
        return result
    }

    fun divide(a: Int, b: Int): Int {
        if (b == 0) {
            logger.log("Error: Division by zero")
            throw IllegalArgumentException("Division by zero")
        }
        val result = a / b
        logger.log("Dividing $a by $b: $result")
        return result
    }
}
class Logger {
    fun log(message: String) {
// Imagine this logs to a file or console
        println(message)
    }
}