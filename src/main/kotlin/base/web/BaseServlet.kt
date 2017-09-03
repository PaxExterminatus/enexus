package base.web

import app.CONTENT_CHARSET
import freemarker.template.Configuration
import java.io.File
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

open class BaseServlet(controller: BaseController): HttpServlet() {
    private var controller: BaseController = controller
    private var action: String = ""

    override fun service(req: HttpServletRequest, res: HttpServletResponse) {
        res.writer.println(controller.unitRouter(action).content);
    }

    protected fun requestProcessing(req: HttpServletRequest) {
        action = actionName(req.requestURL.toString())
    }

    protected fun responseProcessing(res: HttpServletResponse) {
        res.contentType = controller.pageContent.contentType
    }

    private fun actionName(url: String): String {
        val pattern = "(?:${controller.unitName})/(\\w+)"
        var _action = Regex(pattern).find(url)?.groupValues?.get(1) ?: "${controller.unitName}"
        return "action${_action.capitalize()}"
    }


}