package com.example.app

import io.github.oshai.kotlinlogging.KotlinLogging

private val logger = KotlinLogging.logger {  }

fun main() {
    logger.info { "Application started" }
}