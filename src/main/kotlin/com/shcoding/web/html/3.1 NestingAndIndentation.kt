package com.shcoding.web.html

import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

class NestingAndIndentation : Template<HTML> {

    override fun HTML.apply() {
        head {
            title { text("Nesting") }
        }
        body {
            ul {
                li { text("A") }
                li { text("B") }
                ol {
                    li { text("B1") }
                    li { text("B2") }
                    ul {
                        li { text("B2a") }
                        ul {
                            li { text("B2aa") }
                            li { text("B2ab") }
                        }
                        li { text("B2b") }
                        li { text("B2c") }
                    }
                    li { text("B3") }
                    ol {
                        li { text("B31") }
                        li { text("B32") }
                    }
                }
                li { text("C") }
            }
        }
    }

}

fun Routing.nestingAndIndentation() {
    get(
        path = "/nesting",
        body = {
            call.respondHtmlTemplate(
                template = NestingAndIndentation(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}
