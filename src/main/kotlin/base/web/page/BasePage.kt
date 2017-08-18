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
        /*Создание Ответа*/
        res?.writer?.println(pageContext.content);
        pageContext.clear()
    }

    protected fun requestProcessing(req: HttpServletRequest?) {
        action = actionNameGet(req?.requestURL.toString()).plus("Action")
    }

    private fun actionNameGet(url: String): String {
        return Regex("\\w+\$").find(url)?.value ?: ""
    }


}