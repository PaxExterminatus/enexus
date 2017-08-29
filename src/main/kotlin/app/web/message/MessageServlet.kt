package app.web.message

import base.web.BaseServlet
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "MessageServlet",
        urlPatterns = arrayOf("/message", "/message/preview/*","/message/send/*", "/message/task", "/message/report/*")
)
class MessageServlet : BaseServlet(MessageController()) {
    override fun service(req: HttpServletRequest, res: HttpServletResponse) {
        requestProcessing(req)
        responseProcessing(res)
        super.service(req, res)
    }
}
