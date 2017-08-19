package app.web.message

import base.web.page.BasePage
import javax.servlet.annotation.WebServlet
import javax.servlet.annotation.WebInitParam
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

val urlPatterns: Array<String> = arrayOf()

@WebServlet(name = "MessagePage",
        urlPatterns = arrayOf(
            "/message",
            "/message/preview/*",
            "/message/send/*",
            "/message/tasks",
            "/message/task/*",
            "/message/reports",
            "/message/report/*"
    ),
        //kotlin
        initParams = arrayOf(
                WebInitParam(name = "title", value = "Messages Title")
        )
)
class MessagePage: BasePage() {
    override fun service(req: HttpServletRequest, res: HttpServletResponse) {

        pageContext.title = getInitParameter("title")
        pageContext.body.add("<h1>$action</h1>")
        super.service(req, res)
    }

    fun messageAction() {
        pageContext.body.add("Message Start Page")
    }

    fun previewAction() {
        pageContext.body.add("Message Preview")
    }
}
