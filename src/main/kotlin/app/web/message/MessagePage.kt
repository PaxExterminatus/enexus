package app.web.message

import base.web.page.BasePage
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "MessagePage", value = "/message")
class MessagePage: BasePage() {
    override fun doGet(req: HttpServletRequest?, res: HttpServletResponse?) {
        pageContext.title = "ESCC Nexus Messages"
        super.doGet(req, res)
    }
}