package com.shcoding.web.css

import com.shcoding.plugins.respondCss
import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.html.*

class ColorVocabProject : Template<HTML> {
    override fun HTML.apply() {
        head {
            meta {
                charset = "utf-8"
            }
            title {
                text("Spanish Vocabulary")
            }
            link {
                rel = "stylesheet"
                href = "/color/style.css"
                type = "text/css"
            }

        }
        body {
            h1 {
                text("Colors")

            }
            h2 {
                text("Learn the colors in Spanish!")
            }
            h2 {
                classes = setOf("title-color")
                id = "red"
                text("Rojo")
            }
            img {
                src = "/img/color/red.png"
                alt = "red"
            }
            h2 {
                classes = setOf("title-color")
                id = "blue"
                text("Azul")
            }
            img {
                src = "/img/color/blue.png"
                alt = "blue"
            }
            h2 {
                classes = setOf("title-color")
                id = "orange"
                text("Anaranjado")
            }
            img {
                src = "/img/color/orange.png"
                alt = "orange"
            }
            h2 {
                classes = setOf("title-color")
                id = "green"
                text("Verde")
            }
            img {
                src = "/img/color/green.png"
                alt = "green"
            }
            h2 {
                classes = setOf("title-color")
                id = "yellow"
                text("Amarillo")
            }
            img {
                src = "/img/color/yellow.png"
                alt = "yellow"
            }


        }
    }

}

fun Route.colorVocabProject() {
    get(
        path = "/color/style.css",
        body = {
            call.respondCss {

                img {
                    height = 200.px
                    width = 200.px
                }
                rule(
                    selector = ".title-color",
                    block =
                        {
                            fontWeight = FontWeight.normal
                        }
                )
                rule(
                    selector = "#red", block = {
                        color = Color.red
                    }
                )
                rule(
                    selector = "#blue",
                    block = {
                        color = Color.blue
                    }
                )
                rule(
                    selector = "#orange",
                    block = {
                        color = Color.orange
                    }
                )
                rule(
                    selector = "#green",
                    block = {
                        color = Color.green
                    }
                )
                rule(
                    selector = "#yellow",
                    block = {
                        color = Color.yellow
                    }
                )

            }
        }
    )
    get(
        path = "/colorvocab",
        body = {
            call.respondHtmlTemplate(
                template = ColorVocabProject(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}