package base.web.context

open class PageContext {
    var charset: String = "utf-8"
    var mimeSupertype: String = "text"
    var mimeSubtype: String = "html"
    var languages: Array<String> = arrayOf("ru","en")

    var title: String = ""
    var body: String = ""
    var head: String = ""
    var html: String = ""

    open val context: String get() = buildContext()

    private fun buildContext(): String {
        title = "<title>$title</title>"
        head = "<head>$title</head>"
        body  = "<body>$body</body>"
        html = "<!doctype html>$head $body</html>"
        return html
    }
}