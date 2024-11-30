package com.shcoding.web.css

import com.shcoding.plugins.internalCss
import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.html.*

class FontProperties : Template<HTML> {
    private val cssStyle = internalCss {
        html {
            fontSize = 30.px
        }
        body {
            color = Color.white
            backgroundColor = Color.cornflowerBlue
            fontSize = 18.px
        }
        rule(
            selector = "#color",
            block = {
                color = Color.coral
            }
        )
        rule(
            selector = "#size",
            block = {
                fontSize = 2.rem
            }
        )
        rule(
            selector = "#weight",
            block = {
                fontWeight = FontWeight("900")
            }
        )
        rule(
            selector = "#family",
            block = {
                fontFamily = "'Caveat', cursive"
            }
        )
        rule(
            selector = "#align",
            block = {
                textAlign = TextAlign.right
            }
        )
    }

    override fun HTML.apply() {
        head {
            meta {
                charset = "utf-8"
            }
            title {
                text("Font Properties")

            }
            style {
                unsafe {
                    raw(cssStyle)
                }
            }
            link {
                rel = "preconnect"
                href = "https://fonts.googleapis.com"
            }
            link {
                rel = "preconnect"
                href = "https://fonts.gstatic.com"
            }
            link {
                rel = "stylesheet"
                href = "https://fonts.googleapis.com/css2?family=Caveat&display=swap"
            }

        }
        body {
            h1 { text("Important CSS Properties") }
            p {
                id = "color"
                text("Color")
            }
            p {
                id = "size"
                text("Font Size")
            }
            p {
                id = "weight"
                text("Font Weight")
            }
            p {
                id = "family"
                text("Font Family")
            }
            p {
                id = "align"
                text("Text Align")
            }
        }
    }
}

fun Routing.fontProperties() {
    get(
        path = "/fontproperties",
        body = {
            call.respondHtmlTemplate(
                template = FontProperties(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}