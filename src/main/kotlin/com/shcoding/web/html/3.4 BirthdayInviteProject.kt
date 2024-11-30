package com.shcoding.web.html

import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

class BirthdayInviteProject : Template<HTML> {
    override fun HTML.apply() {
        head {
            title { text("Birthday Invite") }
        }
        body {
            h1 { text("It's My Birthday!") }
            h2 { text("On the 12th May") }
            img {
                src = "https://raw.githubusercontent.com/appbrewery/webdev/main/birthday-cake3.4.jpeg"
                alt = "purple birthday cake with candles"
            }
            h3 { text("What to bring") }
            ul {
                li { text("Baloons (I love baloons)") }
                li { text("Cake (I'm really good at eating)") }
                li { text("An appetite (There will be lots of food)") }

            }

            h3 { text("This is where you need to go:") }
            a {
                href =
                    "https://www.google.com/maps/@35.7040744,139.5577317,3a,75y,289.6h,87.01t,0.72r/data=!3m6!1e1!3m4!1sgT28ssf0BB2LxZ63JNcL1w!2e0!7i13312!8i6656"
                text("Google map link")
            }
        }
    }

}

fun Routing.birthdayInviteProject() {
    get(
        path = "/birthday",
        body = {
            call.respondHtmlTemplate(
                template = BirthdayInviteProject(),
                status = HttpStatusCode.OK,
                body = {

                }
            )
        }
    )
}