package base.web

import app.CONTENT_CHARSET
import app.PATH_VIEW
import base.web.context.PageContent
import freemarker.template.Configuration
import java.io.File
import java.io.StringWriter

open class BaseController {
    val unitName: String = Regex("(^.+)(?:controller)").matchEntire(this.javaClass.simpleName.toLowerCase())!!.groups[1]!!.value
    var pageContent = PageContent()

    fun unitRouter(action: String): PageContent {
        pageContent = PageContent()
        try {
            val cl = this.javaClass.getMethod(action).invoke(this)
        } catch (ex: NoSuchMethodException){
            unitActionException(action)
        }
        return pageContent
    }

    private fun unitActionException(action: String) {
        pageContent.title = "Controller Exception"
        pageContent.add("<h1>Function not found for action $action</h1>")
    }

    fun render(viewName: String, viewData: Any, viewPath: String = "$PATH_VIEW/$unitName/") {
        var vConfig = Configuration(Configuration.VERSION_2_3_25)
        vConfig.setDirectoryForTemplateLoading(File(viewPath))
        vConfig.defaultEncoding = CONTENT_CHARSET
        var out = StringWriter()
        vConfig.getTemplate(viewName).process(viewData, out)
        pageContent.add(out.toString())
    }

}