package com.shcoding.web.html

import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun HTML.about() {
    head {
        title { text("About") }
    }
    body {
        h1 { text("About Me") }
        p {
            text(
                """
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque sem tellus, sagittis non odio nec, interdum
  elementum lacus. Ut ac justo eget risus sollicitudin fringilla sed ut leo. Ut condimentum elit nec fermentum lobortis.
  Quisque tincidunt quam nec tincidunt ullamcorper. Integer vitae pretium justo. In placerat volutpat pellentesque.
  Etiam
  gravida quam vitae odio pulvinar imperdiet. Vivamus venenatis gravida purus sit amet aliquet. Ut in nibh sed quam
  laoreet lacinia. Cras cursus ut dui vitae posuere. Vivamus volutpat urna vitae odio fringilla placerat. Nulla vel
  rhoncus sapien. Phasellus at interdum enim.
                """.trimIndent()
            )
        }
        p {
            text(
                """
                    Curabitur elementum sagittis mollis. In porta nec quam ut semper. Nulla volutpat neque quis lacus mattis eleifend.
  Phasellus et congue odio. Mauris tristique, nisl quis porttitor porttitor, tortor ante mattis ex, at dictum tortor
  dolor
  ut sem. Nullam nec libero non ex porta vulputate a eu sapien. In nec bibendum mauris. Fusce iaculis lectus vel magna
  laoreet gravida.
                """.trimIndent()
            )
        }
        p {
            text(
                """
                Donec euismod vestibulum arcu, a blandit metus mattis ultrices. Integer quis hendrerit justo. Maecenas sed tempor mi.
  Fusce egestas urna leo. Mauris viverra sem sed libero egestas, volutpat aliquet magna porta. Quisque id diam sed ipsum
  interdum sollicitudin id quis augue. Donec congue nisl nec massa ornare imperdiet quis quis odio. Etiam ut volutpat
  nisl. Vestibulum hendrerit justo nibh, eget consequat magna fermentum finibus. Pellentesque et urna fringilla, rutrum
  neque in, varius leo. Vestibulum efficitur id massa eget pellentesque.
            """.trimIndent()
            )
        }
    }
}

fun HTML.contact() {
    head {
        title { text("Contact Me") }
    }
    body {
        h1 { text("Contact Me") }
        p { text("Tel: +123456789") }
        p { text("Email: me@gmail.com") }
        p { text("Address") }
        p {
            text("123 North Street")
            br()
            text("Some City")
            br()
            text("Some Country")
            br()
        }
    }
}

class WebPages : Template<HTML> {
    override fun HTML.apply() {
        head {
            title { text("Pages") }
        }
        body {
            h1 { text("Welcome to My Website!") }
            a {
                href = "/about"
                img {
                    src = "/img/dog.png"
                }
            }
            hr()
            a {
                href = "/contact"
                text("Contact Me")
            }

        }
    }

}

fun Routing.webPages() {
    get(
        path = "/pages",
        body = {
            call.respondHtmlTemplate(
                template = WebPages(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
    get(
        path = "/about",
        body = {
            call.respondHtml {
                about()
            }
        }
    )
    get(
        path = "/contact",
        body = {
            call.respondHtml {
                contact()
            }
        }
    )

}