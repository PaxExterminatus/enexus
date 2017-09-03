package base.web.context

import app.CONTENT_CHARSET

open class PageContent {
    var charset = CONTENT_CHARSET
    var mimeSupertype = "text"
    var mimeSubtype = "html"
    val contentType = "$mimeSupertype/$mimeSubtype;charset=$charset"
    var languages = arrayOf("ru","en")

    var title = ""
    var body: Context = Context()

    var head: Context = Context()

    var layoutUse = true

    var viewMain = ""
    var viewActions = ""

    var content = ""

    fun add(str: String) {
        body.add(str)
    }

    class Context{
        var value: String = ""
        fun add(str: String){
            value = value.plus(str).plus("<br>")
        }
    }
}