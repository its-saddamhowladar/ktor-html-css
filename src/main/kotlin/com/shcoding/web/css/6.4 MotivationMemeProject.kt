package com.shcoding.web.css

import com.shcoding.plugins.respondCss
import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.html.*

class MotivationMemeProject : Template<HTML> {
    override fun HTML.apply() {
        head {
            meta {
                charset = "utf-8"
            }
            title { text("Motivation Meme") }
            link {
                href = "/motivation/style.css"
                rel = "stylesheet"
                type = "text/css"
            }
            link {
                href = "https://fonts.googleapis.com/css2?family=Libre+Baskerville&display=swap"
                rel = "stylesheet"
                type = "text/css"
            }
            link {
                rel = "preconnect"
                href = "https://fonts.googleapis.com"
            }
            link {
                rel = "preconnect"
                href = "https://fonts.gstatic.com"
            }
        }
        body {
            div {
                classes = setOf("poster")
                img {
                    classes = setOf("poster-image")
                    src = "/img/daenerys.jpeg"
                    alt = "daenerys"
                }
                h1 {
                    text("That Special Moment")
                }
                p {
                    text(
                        """
                            when you find the perfect avocado at the supermarket
                        """.trimIndent()
                    )
                }
            }

        }
    }

}

fun Routing.motivationMemeProject() {

    get(
        path = "/motivation/style.css",
        body = {
            call.respondCss {

                body {
                    backgroundColor = Color.black
                }
                h1 {
                    textTransform = TextTransform.uppercase
                    fontSize = 3.rem
                }
                rule(
                    selector = ".poster",
                    block = {
                        width = 50.pct
                        marginLeft = 25.pct
                        marginTop = 100.px
                        color = Color.white
                        fontFamily = "'Libre Baskerville',serif"
                        textAlign = TextAlign.center

                    }
                )
                rule(
                    selector = ".poster-image",
                    block = {
                        width = 100.pct
                        borderWidth = 5.px
                        borderStyle = BorderStyle.solid
                        borderColor = Color.white
                    }
                )

            }
        }
    )

    get(
        path = "/motivation",
        body = {
            call.respondHtmlTemplate(
                template = MotivationMemeProject(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}