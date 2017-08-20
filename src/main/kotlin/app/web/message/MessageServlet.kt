package app.web.message

import base.web.servlet.BasePage
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(name = "MessagePage",
        urlPatterns = arrayOf(
            "/message",
            "/message/preview/*",
            "/message/send/*",
            "/message/task",
            "/message/report/*"
    )
)
class MessagePage: BasePage() {
    override fun service(req: HttpServletRequest, res: HttpServletResponse) {
        requestProcessing(req)
        responseProcessing(res)
        pageContext = controllerAction(action)
        unitName = app.web.message.unitName
        super.service(req, res)
    }
}
