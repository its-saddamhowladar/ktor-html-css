package com.shcoding.plugins

import com.shcoding.web.css.*
import com.shcoding.web.html.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.html.*

fun Application.configureTemplating() {
    routing {
        get(
            path = "/",
            body = {
                call.respondHtml {
                    head {
                        title { text("HTML") }
                    }
                    body {
                        h1 { text("Ktor Web Development") }
                        h2 { text("Basic HTML") }
                        ul {
                            li {
                                a(
                                    href = "/heading"
                                ) {
                                    h3 { text("Heading Elements") }
                                }
                            }
                            li {
                                a(
                                    href = "/paragraph"
                                ) {
                                    h3 { text("Paragraph Elements") }
                                }
                            }
                            li {
                                a(
                                    href = "/void"
                                ) {
                                    h3 { text("Void Elements") }
                                }
                            }
                            li {
                                a(
                                    href = "/movie"
                                ) {
                                    h3 { text("Movie Ranking Project") }
                                }
                            }


                        }
                        h2 { text("Intermediate HTML") }
                        ul {
                            li {
                                a(
                                    href = "/list"
                                ) {
                                    h3 { text("List Elements") }
                                }
                            }

                            li {
                                a(
                                    href = "/nesting"
                                ) {
                                    h3 { text("Nesting And Indentation") }
                                }
                            }
                            li {
                                a(
                                    href = "/anchor"
                                ) {
                                    h3 { text("Anchor Element") }
                                }
                            }
                            li {
                                a(
                                    href = "/image"
                                ) {
                                    h3 { text("Image Element") }
                                }
                            }
                            li {
                                a(
                                    href = "/birthday"
                                ) {
                                    h3 { text("Birthday Invite Project") }
                                }
                            }
                        }
                        h2 { text("Multi-Page Websites") }
                        ul {
                            li {
                                a {
                                    href = "/paths"
                                    h3 { text("File Paths") }
                                }
                            }

                            li {
                                a {
                                    href = "/pages"
                                    h3 { text("Web Pages") }
                                }
                            }
                            li {
                                a {
                                    href = "/portfolio"
                                    h3 { text("HTML Portfolio Project") }
                                }
                            }
                        }
                        h2 { text("Basic CSS") }
                        ul {
                            li {
                                a {
                                    href = "/addcss"
                                    h3 { text("Add CSS") }
                                }
                            }
                            li {
                                a {
                                    href = "/cssselectors"
                                    h3 { text("CSS Selectors") }
                                }
                            }
                            li {
                                a {
                                    href = "/colorvocab"
                                    h3 { text("Color Vocab Project") }
                                }
                            }
                        }
                        h2 { text("CSS Properties") }
                        ul {
                            li {
                                a {
                                    href = "/csscolors"
                                    h3 { text("CSS Colors") }
                                }
                            }
                            li {
                                a {
                                    href = "/fontproperties"
                                    h3 { text("Font Properties") }
                                }
                            }
                            li {
                                a {
                                    href = "/cssboxmodel"
                                    h3 { text("CSS Box Model") }
                                }
                            }
                            li {
                                a {
                                    href = "/motivation"
                                    h3 { text("Motivation Meme Project") }
                                }
                            }
                        }
                        h2 { text("CSS Intermediate") }
                        ul {
                            li {
                                a {
                                    href = "/csscascade"
                                    h3 { text("CSS Cascade") }
                                }
                            }
                        }
                    }
                }
            }
        )
        headingElement()
        paragraphElement()
        voidElement()
        movieRankingProject()
        listElement()
        nestingAndIndentation()
        anchorElement()
        imageElement()
        birthdayInviteProject()
        filePaths()
        webPages()
        htmlPortfolioProject()
        addingCSS()
        cssSelectors()
        colorVocabProject()
        cssColors()
        fontProperties()
        cssBoxModel()
        motivationMemeProject()
        cssCascade()

    }
}

suspend inline fun ApplicationCall.respondCss(builder: CssBuilder.() -> Unit) {
    this.respondText(CssBuilder().apply(builder).toString(), ContentType.Text.CSS)
}

inline fun inlineCss(block: CssBuilder.() -> Unit): String {
    return CssBuilder().apply(block).toString()
}

inline fun internalCss(block: CssBuilder.() -> Unit): String {
    return """${CssBuilder().apply(block)}"""
}
