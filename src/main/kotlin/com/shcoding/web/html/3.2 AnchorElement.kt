package com.shcoding.web.html

import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

class AnchorElement : Template<HTML> {
    override fun HTML.apply() {
        head {
            title { text("Anchor") }
        }
        body {
            h1 { text("My top 5 Favorite Websites") }
            ol {
                li {
                    a(href = "https://www.producthunt.com") {
                        text("Product hunt")
                    }
                }
                li {
                    a(href = "https://smashthewalls.com") {
                        text("Smash the Walls")
                    }
                }
                li {
                    a(href = "https://www.nytimes.com/games/wordle") {
                        text("Wordle")
                    }
                }
                li {
                    a(href = "https://hackertyper.com") {
                        text("Hacker Typer")
                    }
                }
                li {
                    a(href = "https://stellarium-web.org") {
                        text("Stellarium")
                    }
                }
            }


        }
    }

}

fun Routing.anchorElement() {
    get(
        path = "/anchor",
        body = {
            call.respondHtmlTemplate(
                template = AnchorElement(),
                status = HttpStatusCode.OK,
                body = {

                }
            )
        }
    )
}