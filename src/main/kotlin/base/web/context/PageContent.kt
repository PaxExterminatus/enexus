package base.web.context

import app.*

class PageContent: HtmlContent() {

    var head: Context = Context()
    var base: String = HOST_NAME

    var viewMain = ""
    var viewActions = ""

}

