package com.example.a8testing

import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CalculatorTest {
    private lateinit var calculator: Calculator
    private val mockLogger: Logger = mockk(relaxed = true)
    @Before
    fun setUp() {
        calculator = Calculator(mockLogger)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun add() {
        // Given
        val a = 5
        val b = 3
        // When
        val result = calculator.add(a, b)
        // Then
        assertEquals(8, result)
        // Verify the result is correct
        verify { mockLogger.log("Adding 5 and 3: 8") } // Verify the log message
    }

    @Test
    fun subtract() {
            // Given
            val a = 10
            val b = 4
            // When
            val result = calculator.subtract(a, b)
            // Then
            assertEquals(6, result)
            // Verify the result is correct
            verify { mockLogger.log("Subtracting 10 and 4: 6") } // Verify the log message
    }

    @Test
    fun multiply() {
        // Given
        val a = 4
        val b = 3
        // When
        val result = calculator.multiply(a, b)
        // Then
        assertEquals(12, result)
        // Verify the log message
        verify { mockLogger.log("Multiplying 4 and 3: 12") }
    }

    @Test
    fun divide() {
        // Given
        val a = 10
        val b = 2
        // When
        val result = calculator.divide(a, b)
        // Then
        assertEquals(5, result)
        // Verify the log message
        verify { mockLogger.log("Dividing 10 by 2: 5") }
    }

    @Test(expected = IllegalArgumentException::class)
    fun divideByZero() {
        // Given
        val a = 10
        val b = 0
        // When
        calculator.divide(a, b)
        // Then - Expected exception
        verify { mockLogger.log("Error: Division by zero") }
    }

}