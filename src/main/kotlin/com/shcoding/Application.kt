package com.shcoding

import com.shcoding.plugins.configureHTTP
import com.shcoding.plugins.configureRouting
import com.shcoding.plugins.configureSerialization
import com.shcoding.plugins.configureTemplating
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureTemplating()
    configureSerialization()
    configureHTTP()
    configureRouting()
}
