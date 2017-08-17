package base.web.page

import base.web.context.PageContext
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

open class BasePage: HttpServlet() {
    protected var pageContext: PageContext = PageContext()

    override fun doGet(req: HttpServletRequest?, res: HttpServletResponse?) {
        res?.writer?.println(pageContext.context);
    }

}