package com.shcoding.web.css

import com.shcoding.plugins.respondCss
import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.html.*

class CSSCascade : Template<HTML> {
    override fun HTML.apply() {
        head {
            meta {
                charset = "utf-8"
            }
            title {
                text("CSS Cascade")
            }
            link {
                href = "/csscascade/style.css"
                rel = "stylesheet"
                type = "text/css"
            }
        }
        body {
            div {
                id = "outer-box"
                classes = setOf("box")
                div {
                    classes = setOf("box")
                    p { text("Yellow Text") }
                    div {
                        classes = setOf("box inner-box")
                        p {
                            classes = setOf("white-text")
                            text("white Text")
                        }
                    }
                }


                div {
                    classes = setOf("box")
                    p { text("Yellow Text") }
                    div {
                        classes = setOf("box inner-box")
                        p {
                            classes = setOf("white-text")
                            text("white Text")
                        }
                    }
                }
            }
        }
    }

}

fun Routing.cssCascade() {
    get(
        path = "/csscascade/style.css",
        body = {
            call.respondCss {

                rule(
                    selector = "#outer-box",
                    block = {
                        backgroundColor = Color.purple
                    }
                )

                rule(
                    selector = ".box",
                    block = {
                        backgroundColor = Color.blue
                        padding = Padding(10.px)
                    }
                )

                rule(
                    selector = ".inner-box",
                    block = {
                        backgroundColor = Color.red

                    }
                )
                p {
                    color = Color.yellow
                    margin = Margin(0.px)
                    padding = Padding(0.px)
                }
                rule(
                    selector = ".white-text",
                    block = {
                        color = Color.white
                    }
                )

            }
        }
    )
    get(
        path = "/csscascade",
        body = {
            call.respondHtmlTemplate(
                template = CSSCascade(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}