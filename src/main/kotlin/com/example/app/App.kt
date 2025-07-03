package com.example.app

import com.example.app.core.CoreModule
import com.example.app.core.HelloWorldService
import io.github.oshai.kotlinlogging.KotlinLogging
import io.opentelemetry.instrumentation.logback.appender.v1_0.OpenTelemetryAppender
import io.opentelemetry.sdk.autoconfigure.AutoConfiguredOpenTelemetrySdk
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.module

private val logger = KotlinLogging.logger { }

fun main() {
    // Init Otel
    val sdk = AutoConfiguredOpenTelemetrySdk
        .builder()
        .setResultAsGlobal()
        .build()
        .openTelemetrySdk
    OpenTelemetryAppender.install(sdk)

    val koin = startKoin {
        modules(
            CoreModule().module,
            // module {
            //  properties(config.flatten())
            // },
        )
    }
    val service: HelloWorldService = koin.koin.get()
    logger.info { service.sayHello("World") }
}