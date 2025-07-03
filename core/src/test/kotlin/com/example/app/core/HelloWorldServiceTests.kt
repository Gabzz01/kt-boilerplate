package com.example.app.core

import org.junit.Test

class HelloWorldServiceTests {

    @Test
    fun sayHelloTest() {
        // Given
        val name = "World"
        // When
        val result = HelloWorldService().sayHello(name)
        // Then
        assert(result == "Hello $name") { "Expected 'Hello $name' but got '$result'" }
    }

}