package com.shcoding.web.html

import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

class MovieRankingProject : Template<HTML> {
    override fun HTML.apply() {

        head {
            title { text("Movie Ranking") }
        }
        body {
            h1 {
                text("The Best Movies According to Me")
            }
            h2 {
                text("My top 3 movies of all-time.")
            }
            hr()
            h3 {
                text("Spirited Away")
            }
            p {
                text("This is my favourite anime. I love the beautiful images.")
            }
            h3 {
                text("Ex Machina")
            }
            p {
                text("Really cool sci-fi movie.")
            }
            h3 {
                text("Drive")
            }
            p {
                text("Super beautiful film. Really artistic.")
            }
        }
    }

}

fun Routing.movieRankingProject() {
    get(
        path = "/movie",
        body = {

            call.respondHtmlTemplate(
                template = MovieRankingProject(),
                status = HttpStatusCode.OK,
                body = {}
            )

        }
    )
}