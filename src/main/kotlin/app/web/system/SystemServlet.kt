package app.web.system

import base.web.BaseServlet
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "MessageServlet",
        urlPatterns = arrayOf("/message", "/message/preview/*","/message/send/*", "/message/task", "/message/report/*")
)
class MessageServlet : BaseServlet(SystemController()) {
    override fun service(req: HttpServletRequest, res: HttpServletResponse) {
        requestProcessing(req)
        responseProcessing(res)
        super.service(req, res)
    }
}