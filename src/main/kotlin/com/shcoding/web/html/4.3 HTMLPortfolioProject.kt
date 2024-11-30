package com.shcoding.web.html

import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

class HTMLPortfolioProject : Template<HTML> {
    override fun HTML.apply() {
        head {
            meta { charset = "utf-8" }
            title { text("Portfolio") }

        }
        body {
            h1 { text("My Portfolio") }
            h2 { text("I'm a Web Developer") }
            hr()
            h3 {
                a {
                    href = "/movie"
                    text("Movie Ranking Project")
                }
            }
            img {
                src = "/img/project/movie-ranking.png"
                alt = "Movie Ranking Project"
            }
            h3 {
                a {
                    href = "/birthday"
                    text("Birthday Invite Project")
                }
            }
            img {
                src = "/img/project/birthday-invite.png"
                alt = "Birthday Invite Project"
            }
            hr()
            a {
                href = "/about"
                text("About Me ")
            }
            a {
                href = "/contact"
                text("Contact Me")
            }

        }
    }

}

fun Routing.htmlPortfolioProject() {
    get(
        path = "/portfolio",
        body = {
            call.respondHtmlTemplate(
                template = HTMLPortfolioProject(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}