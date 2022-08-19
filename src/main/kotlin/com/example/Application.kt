package com.example

import io.ktor.server.application.*
import com.example.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.methodoverride.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(XHttpMethodOverride)
        configureSerialization()
        configureRouting()
    }.start(wait = true)
}

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(XHttpMethodOverride)
    configureSerialization()
    configureRouting()
}
