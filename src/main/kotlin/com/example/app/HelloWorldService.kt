package com.example.app

import org.koin.core.annotation.Single

@Single
class HelloWorldService {

    fun sayHello(input: String): String {
        return "Hello $input"
    }

}