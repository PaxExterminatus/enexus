package app.web.main

import base.web.BaseController
import base.web.BaseServlet
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "MainServlet", value = "")
class MainServlet : BaseServlet(MainController()) {
    override fun service(req: HttpServletRequest, res: HttpServletResponse) {
        requestProcessing(req)
        responseProcessing(res)
        super.service(req, res)
    }
}