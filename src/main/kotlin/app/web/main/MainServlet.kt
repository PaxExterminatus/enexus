package app.web.main

import base.web.servlet.BaseServlet
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "MainServlet", value = "")
class MainServlet : BaseServlet() {
    override fun doGet(req: HttpServletRequest?, res: HttpServletResponse?) {
        pageContext.title = "ESCC Nexus"
        super.doGet(req, res)
    }
}