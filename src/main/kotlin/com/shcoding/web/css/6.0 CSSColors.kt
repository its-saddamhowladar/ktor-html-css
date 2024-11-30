package com.shcoding.web.css

import com.shcoding.plugins.internalCss
import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.html.*

class CSSColors : Template<HTML> {
    private val cssStyle = internalCss {
        body {
            backgroundColor = Color.antiqueWhite
        }
        h1 {
            color = Color.whiteSmoke
            backgroundColor = Color.darkSeaGreen
        }
        h2 {
            color = Color("#FAF8F1")
            backgroundColor = Color("#C58940")
        }
    }

    override fun HTML.apply() {
        head {
            meta {
                charset = "utf-8"
            }
            title {
                text("CSS Colors")
            }
            style {
                unsafe {
                    raw(cssStyle)
                }
            }
        }
        body {
            h1 {
                text("Hello")

            }
            h2 {
                text("World")
            }
        }
    }

}

fun Routing.cssColors() {
    get(
        path = "/csscolors", body = {
            call.respondHtmlTemplate(
                template = CSSColors(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}