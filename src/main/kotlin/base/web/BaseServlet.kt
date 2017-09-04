package base.web

import base.web.context.PageContent
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

open class BaseServlet(controller: BaseController): HttpServlet() {
    private var controller: BaseController = controller
    private var action: String = ""

    protected fun requestProcessing(req: HttpServletRequest) {
        action = actionName(req.requestURL.toString())
    }

    protected fun responseProcessing(res: HttpServletResponse) {
        res.contentType = controller.pageContent.contentType
    }

    override fun service(req: HttpServletRequest, res: HttpServletResponse) {
        res.writer.println(controller.unitRouter(action).content);
        controller.pageContent = PageContent()
    }

    private fun actionName(url: String): String {
        val pattern = "(?:${controller.unitName})/(\\w+)"
        var _action = Regex(pattern).find(url)?.groupValues?.get(1) ?: controller.unitName
        return _action
    }
}