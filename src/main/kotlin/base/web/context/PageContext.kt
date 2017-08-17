package base.web.context

open class PageContext {
    var charset = "utf-8"
    var mimeSupertype = "text"
    var mimeSubtype = "html"
    var languages = arrayOf("ru","en")

    var title = ""
    var body  = ""
    var head  = ""

    var layoutUse = true
    var layoutName = "default"

    var context = ""
        get() = buildContext()

    private fun buildContext(): String {
        val layout: LayoutContext? = if (layoutUse) LayoutContext(layoutName) else null

        var _bodyTop = layout?.bodyTop ?: ""
        var _bodyBottom = layout?.bodyBottom ?: ""
        var _headBottom = layout?.headBottom ?: ""

        var _title = "<title>$title</title>"
        var _head =  "<head>$_title$head$_headBottom</head>"
        var _body =  "<body>$_bodyTop$body$_bodyBottom</body>"
        var _html =  "<!doctype html>$_head$_body</html>"
        return _html
    }

}