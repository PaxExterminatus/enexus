package base.web.page

import base.web.context.PageContext
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

open class BasePage: HttpServlet() {
    protected var pageContext: PageContext = PageContext()
    protected var action: String = ""

    override fun doGet(req: HttpServletRequest?, res: HttpServletResponse?) {
        /*Обработка Запроса*/
        requestProcessing(req)
        pageContext.body.add("<h1>$action</h1>")

        /*Создание Ответа*/
        res?.writer?.println(pageContext.content);
        pageContext.clear()
    }

    private fun requestProcessing(req: HttpServletRequest?) {
        action = buildAction(req?.requestURL.toString())
    }

    private fun buildAction(url: String): String {
        return Regex("\\w+\$").find(url)?.value ?: ""
    }
}