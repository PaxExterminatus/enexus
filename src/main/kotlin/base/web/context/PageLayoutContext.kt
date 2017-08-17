package base.web.context

class PageLayoutContext(pageContext: PageContext, layoutName: String = "default"): PageContext() {
    var bodyTop : String = ""
    var bodyBottom : String = ""
    var headBottom: String = ""

    init {
        title = "<title>${pageContext.title}</title>"
        head = "<head>$head $title $headBottom</head>"
        body = "<body>$bodyTop ${pageContext.body} $bodyBottom</body>"
        html = "<html>$head $body</html>"
    }

    override val context: String get() = html

}