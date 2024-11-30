package com.shcoding.web.html

import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

class FilePaths : Template<HTML> {
    override fun HTML.apply() {
        head {
            title { text("Paths") }
        }
        body {
            h1 { text("All the Animals") }
            h2 { text("Rabbit:") }
            img {
                src = "/img/Folder0/rabbit.png"
                alt = "Rabbit"
            }
            h2 { text("Cat:") }
            img {
                src = "/img/Folder0/Folder3/cat.png"
                alt = "Cat"
            }
            h2 { text("Dogs:") }
            img {
                src = "/img/dog.png"
                alt = "Dogs"
            }
            h2 { text("Fish:") }
            img {
                src = "/img/Folder1/fish.png"
                alt = "Fish"
            }
            h2 { text("Bird") }
            img {
                src = "/img/Folder1/Folder2/bird.png"
                alt = "Bird"
            }
        }
    }

}

fun Routing.filePaths() {
    get(
        path = "/paths",
        body = {
            call.respondHtmlTemplate(
                template = FilePaths(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}