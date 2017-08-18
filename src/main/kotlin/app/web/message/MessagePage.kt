package app.web.message

import base.web.page.BasePage
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "MessagePage", urlPatterns = arrayOf("/message","/message/preview"))
class MessagePage: BasePage() {
    override fun doGet(req: HttpServletRequest?, res: HttpServletResponse?) {
        pageContext.title = "ESCC Nexus Messages"
        pageContext.body.add("<h1>$action</h1>")
        super.doGet(req, res)
    }


    fun messageAction() {
        pageContext.body.add("Message Start Page 1")
    }

    fun previewAction() {
        pageContext.body.add("Message Preview")
    }

}