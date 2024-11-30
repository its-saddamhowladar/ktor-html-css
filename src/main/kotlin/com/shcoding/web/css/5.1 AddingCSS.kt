package com.shcoding.web.css

import com.shcoding.plugins.inlineCss
import com.shcoding.plugins.internalCss
import com.shcoding.plugins.respondCss
import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.css.Color
import kotlinx.css.color
import kotlinx.css.h1
import kotlinx.html.*

fun HTML.inline() {
    head {
        title { text("Inline") }
    }
    body {
        h1 {
            style = inlineCss { color = Color.blue }
            text("Style Me in Blue!")
        }
    }
}

fun HTML.internal() {
    val internalCSS = internalCss {
        h1 {
            color = Color.red
        }
    }
    head {
        style {
            unsafe {
                raw(internalCSS)
            }
        }
        title { text("Internal") }
    }
    body {
        h1 {
            text("Style Me in Red!")
        }
    }
}

fun HTML.external() {
    head {
        link {
            rel = "stylesheet"
            href = "/style.css"
            type = "text/css"
        }
        title { text("External") }
    }
    body {
        h1 {
            text("Style Me in Green!")
        }
    }
}

class AddingCSS : Template<HTML> {
    override fun HTML.apply() {
        head {

            title { text("Add CSS") }
        }
        body {
            h1 { text("Three Methods of Adding CSS") }
            a {
                href = "/inline"
                text("Inline ")
            }
            a {
                href = "/internal"
                text("Internal ")
            }
            a {
                href = "/external"
                text("External ")
            }
        }
    }

}

fun Routing.addingCSS() {
    get(
        path = "/inline",
        body = {
            call.respondHtml {
                inline()
            }
        }
    )
    get(
        path = "/internal",
        body = {
            call.respondHtml {
                internal()
            }
        }
    )
    get(
        path = "/external",
        body = {
            call.respondHtml {
                external()
            }
        }
    )
    get(
        path = "/style.css",
        body = {
            call.respondCss {
                h1 {
                    color = Color.green
                }
            }
        }
    )
    get(
        path = "/addcss",
        body = {
            call.respondHtmlTemplate(
                template = AddingCSS(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}