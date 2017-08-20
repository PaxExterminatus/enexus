package app.web.main

import base.web.servlet.BasePage
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "MainPage", value = "")
class MainPage: BasePage() {
    override fun doGet(req: HttpServletRequest?, res: HttpServletResponse?) {
        pageContext.title = "ESCC Nexus"
        super.doGet(req, res)
    }
}