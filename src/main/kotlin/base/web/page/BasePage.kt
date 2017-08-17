package base.web.page

import base.web.context.PageContext
import base.web.context.PageLayoutContext
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

open class BasePage(useLayout: Boolean = true): HttpServlet() {
    protected var useLayout: Boolean = useLayout
    var pageContext: PageContext = PageContext()

    override fun doGet(req: HttpServletRequest?, res: HttpServletResponse?) {
        if (useLayout) {
            var layoutContext = PageLayoutContext(pageContext)
            res?.writer?.println(layoutContext.context);
        } else {
            res?.writer?.println(pageContext.context);
        }
    }

}