package app.web.main

import base.web.BaseController
import base.web.BaseServlet
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "MainServlet", value = "")
class MainServlet : BaseServlet(BaseController()) {
    override fun doGet(req: HttpServletRequest?, res: HttpServletResponse?) {
        super.doGet(req, res)
    }
}