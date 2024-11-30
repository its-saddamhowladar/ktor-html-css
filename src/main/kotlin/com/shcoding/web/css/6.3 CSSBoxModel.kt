package com.shcoding.web.css

import com.shcoding.plugins.internalCss
import io.github.allangomes.kotlinwind.css.core.BORDER_WIDTH
import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.html.*

class CSSBoxModel : Template<HTML> {

    private val cssStyle = internalCss {

        div {
            height = 200.px
            width = 200.px
        }
        p {
            margin = Margin(0.px)
        }
        rule(
            selector = "#first",
            block = {
                backgroundColor = Color.cadetBlue
                padding = Padding(20.px)
                border = Border(
                    width = 10.px,
                    style = BorderStyle.solid,
                    color = Color.black
                )
            }
        )
        rule(
            selector = "#second",
            block = {
                backgroundColor = Color.gold
                borderStyle = BorderStyle.solid
                borderColor = Color.black
                borderTopWidth = 20.px
                borderBottomWidth = 20.px
                borderLeftWidth = 10.px
                borderRightWidth = 10.px
                marginLeft = 260.px
            }
        )
        rule(
            selector = "#third",
            block = {
                backgroundColor = Color.indianRed
                borderStyle = BorderStyle.solid
                borderColor = Color.black
                borderWidth = 10.px
                marginLeft = 40.px
            }
        )

    }

    override fun HTML.apply() {
        head {
            meta {
                charset = "utf-8"
            }
            title {
                text("CSSBox")
            }
            style {
                unsafe {
                    raw(cssStyle)
                }
            }
        }
        body {

            div {
                id = "first"
                p {
                    text(
                        """
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at sapien porttitor urna elementum lacinia. In
  id magna pulvinar, ultricies lorem id, vehicula elit. Aliquam eu luctus nisl, vitae pellentesque magna. Phasellus
  dolor metus, laoreet ac convallis sit amet, efficitur sed dolor.
                    """.trimIndent()
                    )
                }
            }
            div {
                id = "second"
            }
            div {
                id = "third"
            }

        }
    }

}

fun Routing.cssBoxModel() {
    get(
        path = "/cssboxmodel",
        body = {
            call.respondHtmlTemplate(
                template = CSSBoxModel(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}