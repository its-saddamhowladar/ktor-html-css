package com.shcoding.web.html

import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

class HeadingElement : Template<HTML> {
    override fun HTML.apply() {
        body {
            h1 { text("Book") }
            h2 { text("Chapter 1") }
            h3 { text("Section 1") }
            h3 { text("Section 2") }
            h2 { text("Chapter 2") }
            h3 { text("Section 1") }
            h4 { text("Diagram 1") }
            h2 { text("Chapter 3") }
            h3 { text("Section 1") }
            h3 { text("Section 2") }

        }
    }

}

fun Routing.headingElement() {
    get("/heading") {
        call.respondHtmlTemplate(template = HeadingElement(), status = HttpStatusCode.OK) {}
    }
}