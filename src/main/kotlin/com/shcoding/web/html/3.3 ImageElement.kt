package com.shcoding.web.html

import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

class ImageElement : Template<HTML> {
    override fun HTML.apply() {
        head {
            title { text("Image") }
        }
        body {
            h1 { text("I am a Cat Person") }

            img {
                src = "https://raw.githubusercontent.com/appbrewery/webdev/main/kitten.jpeg"
                alt = "kitten held in hand"
            }
            h1 { text("I am a Dog Person") }

            img {
                src = "https://raw.githubusercontent.com/appbrewery/webdev/main/puppy.gif"
                alt = "puppy digging int the sand"
            }
        }
    }

}

fun Route.imageElement() {
    get(
        path = "/image",
        body = {
            call.respondHtmlTemplate(
                template = ImageElement(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}