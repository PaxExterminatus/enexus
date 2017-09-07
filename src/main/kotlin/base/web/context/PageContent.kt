package base.web.context

import app.*

class PageContent: HtmlContent() {

    var head: Context = Context()
    var base: String = HTML_BASE

    var viewMain = ""
    var viewActions = ""

}

