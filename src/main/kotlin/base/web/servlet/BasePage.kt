package base.web.servlet

import base.web.context.PageContext
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

open class BasePage(unitName:String): HttpServlet() {
    protected var unitName = unitName
    protected var pageContext: PageContext = PageContext()
    protected var action: String = ""

    override fun service(req: HttpServletRequest, res: HttpServletResponse) {
        res.writer.println(pageContext.content);
        pageContext.clear()
    }

    protected fun requestProcessing(req: HttpServletRequest) {
        action = actionName(req.requestURL.toString())
    }

    protected fun responseProcessing(res: HttpServletResponse) {
        res.contentType = pageContext.contentType
    }

    private fun actionName(url: String): String {
        val pattern = "(?:$unitName)/(\\w+)"
        var _action = Regex(pattern).find(url)?.groupValues?.get(1) ?: "$unitName"
        return "action${_action.substring(0,1).toUpperCase().plus(_action.substring(1))}"
    }


}