package com.shcoding.web.html

import io.ktor.http.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import kotlinx.html.*

class ListElement : Template<HTML> {
    override fun HTML.apply() {
        head {
            title { text("List") }
        }
        body {
            h1 {
                text("Angela's Cinnamon Roll Recipe")
            }
            h2 {
                text("Ingredients")

            }
            h3 {
                text("For the dough:")
            }
            ul {
                li { text("¾ cup warm milk") }
                li { text("2 ¼ teaspoons yeast") }
                li { text("¼ cup granulated sugar") }
                li { text("1 egg plus 1 egg yolk") }
                li { text("¼ cup butter") }
                li { text(" cups bread flour") }
            }
            h3 {
                text("For the filling:")
            }
            ul {
                li { text("2/3 cup dark brown sugar") }
                li { text("1 ½ tablespoons ground cinnamon") }
                li { text("¼ cup butter") }
            }
            h2 {
                text("Instructions")
            }
            ol {
                li { text("Mix the milk with the yeast, sugar, eggs.") }
                li { text("Melt the butter and add to the mixture.") }
                li { text("Add in the flour and mix until combined into a dough.") }
                li { text("Knead the dough for 10 minuites.") }
                li { text("Transfer the dough into a large bowl and cover with plastic wrap. Leave it somewhere to rise for 2 hours.") }
                li { text("Melt the butter for the filling and mix in the sugar and cinnamon.") }
                li { text("Spread the filling onto the dough then roll the dough into a swiss roll.") }
                li { text("Cut the roll into 3cm sections and place flat into a baking tray.") }
                li { text("Pre-heat the oven to 350F or 180C, then bake the rolls for 20-25min until lightly brown.") }
            }

        }
    }


}

fun Routing.listElement() {
    get(
        path = "/list",
        body = {
            call.respondHtmlTemplate(
                template = ListElement(),
                status = HttpStatusCode.OK,
                body = {}
            )
        }
    )
}