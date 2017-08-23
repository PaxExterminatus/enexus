package base.web

import base.web.context.PageContent
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

open class BaseServlet(): HttpServlet() {
    protected var unitName = ""
    protected var pageContent: PageContent = PageContent()
    protected var action: String = ""

    override fun service(req: HttpServletRequest, res: HttpServletResponse) {
        res.writer.println(pageContent.content);
        pageContent.clear()
    }

    protected fun requestProcessing(req: HttpServletRequest) {
        action = actionName(req.requestURL.toString())
    }

    protected fun responseProcessing(res: HttpServletResponse) {
        res.contentType = pageContent.contentType
    }

    private fun actionName(url: String): String {
        val pattern = "(?:$unitName)/(\\w+)"
        var _action = Regex(pattern).find(url)?.groupValues?.get(1) ?: "$unitName"
        return "action${_action.capitalize()}"
    }


}