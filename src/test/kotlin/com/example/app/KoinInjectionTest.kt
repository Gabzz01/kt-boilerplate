package com.example.app

import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.dsl.module
import org.koin.ksp.generated.module
import org.koin.test.verify.verify
import kotlin.test.Test

class KoinInjectionTest {

    /**
     * Ensures that the Koin dependency injection graph is correctly set up (e.g. all components are correctly injected).
     */
    @Test
    @OptIn(KoinExperimentalAPI::class)
    fun testDiGraph() {
        module {
            includes(
                AppModule().module
            )
        }.verify()

    }

}