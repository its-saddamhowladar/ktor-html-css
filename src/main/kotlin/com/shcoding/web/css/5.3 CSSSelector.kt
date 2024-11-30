package com.shcoding.web.css

import com.shcoding.plugins.respondCss
import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.html.*

class CSSSelecctors : Template<HTML> {
    override fun HTML.apply() {
        head {
            meta {
                charset = "utf-8"
            }
            title { text("CSS Selectors") }
            link {
                rel = "stylesheet"
                href = "/cssselectors/style.css"
                type = "text/css"
            }
        }
        body {
            h1 { +"CSS Selectors" }
            h2 { +"Apply CSS to Different Parts of " }
            p {
                classes = setOf("note")
                +"1. The element selector targets elements based on their HTML tag name."
            }
            ol {
                li {
                    classes = setOf("note")
                    value = "2"
                    +"Class selectors target elements based on the value of the class attribute."
                }
                li {
                    classes = setOf("note")
                    id = "id-selector"
                    +"ID selectors target elements based on the value of the id attribute."
                }
                li {
                    classes = setOf("note")
                    value = "4"
                    +"Attribute selectors target elements based on their attributes and values."
                }
                li {
                    classes = setOf("note")
                    value = "5"
                    +"The universal selector targets all elements."
                }
            }
        }
    }

}

fun Routing.cssSelectors() {
    get(
        path = "/cssselectors/style.css",
        body = {
            call.respondCss {
                ol {
                    marginLeft = 40.px
                    marginTop = 20.px
                    listStylePosition = ListStylePosition.inside
                }
                p {
                    color = Color.red
                }
                rule(".note") {
                    fontSize = 20.px
                }
                rule("#id-selector") {
                    color = Color.green
                }
                "li[value=\"4\"]" {
                    color = Color.blue
                }
                rule("*") {
                    textAlign = TextAlign.center
                }
            }
        }
    )

    get(
        path = "/cssselectors",
        body = {
            call.respondHtmlTemplate(
                template = CSSSelecctors(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}