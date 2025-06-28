package com.example.app

import io.github.oshai.kotlinlogging.KotlinLogging
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
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
            AppModule().module,
            // module {
            //  properties(config.flatten())
            // },
        )
    }
    val service: HelloWorldService = koin.koin.get()
    logger.info { service.sayHello("World") }
}

@Module
@ComponentScan
class AppModule