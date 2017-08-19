package base.web.context

open class PageContext {
    var charset = "utf-8"
    var mimeSupertype = "text"
    var mimeSubtype = "html"
    val contentType = "$mimeSupertype/$mimeSubtype;charset=$charset"
    var languages = arrayOf("ru","en")

    var title = ""
    var body: Context = Context()

    var head: Context = Context()

    var layoutUse = true
    var layoutName = "default"

    var content = ""
        get() = buildContext()

    private fun buildContext(): String {
        val layout: LayoutContext? = if (layoutUse) LayoutContext(layoutName) else null

        var _bodyTop = layout?.bodyTop ?: ""
        var _bodyBottom = layout?.bodyBottom ?: ""
        var _headBottom = layout?.headBottom ?: ""

        var _title = "<title>$title</title>"
        var _head =  "<head>$_title${head.value}$_headBottom</head>"
        var _body =  "<body>$_bodyTop${body.value}$_bodyBottom</body>"
        var _html =  "<!doctype html>$_head$_body</html>"
        return _html
    }

    class Context{
        var value: String = ""
        fun add(str: String){
            value = value.plus(str).plus("<br>")
        }
    }

    fun clear() {
        body.value = ""
        head.value = ""
    }

}