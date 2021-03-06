package base.web

import app.*
import base.web.context.PageContent
import freemarker.template.Configuration
import java.io.File
import java.io.StringWriter

open class BaseController {
    val unitName: String = Regex("(^.+)(?:controller)").matchEntire(this.javaClass.simpleName.toLowerCase())!!.groups[1]!!.value
    var unitAction: String = ""
    var reqQueryString: String = ""
    var pageContent = PageContent()

    private var viewPathContext: String  = ""
    private var viewPathAction: String = ""
    var viewConfig = Configuration(Configuration.VERSION_2_3_26)
    init {
        viewConfig.defaultEncoding = CONTENT_CHARSET
        viewConfig.setDirectoryForTemplateLoading(File(PATH_VIEW))
    }

    fun unitRouter(action: String): PageContent {
        unitAction = action
        viewPathContext  = "/$unitName/context/"
        viewPathAction = "/$unitName/$unitAction/"

        try {
            val cl = this.javaClass.getMethod("action${action.capitalize()}").invoke(this)
        } catch (ex: NoSuchMethodException){
            unitActionException(action)
        }
        viewRender()
        return pageContent
    }

    private fun unitActionException(action: String) {
        pageContent.title = "Controller Exception"
        pageContent.add("<h1>Function not found for action $action</h1>")
    }

    fun viewBuild(viewName: String, viewData: Any): String {
        var out = StringWriter()
        viewConfig.getTemplate(viewName).process(viewData, out)
        return out.toString()
    }

    private fun viewRender() {
        var out = StringWriter()
        var file = File("$PATH_VIEW/$unitName/$unitAction/action.ftlh")
        if (file.exists()) {
            var data = object {
                var queryString = reqQueryString
            }
            viewConfig.getTemplate("$viewPathAction/action.ftlh").process(data, out)
            pageContent.viewActions = out.toString()
            out = StringWriter()
        }

        file = File("$PATH_VIEW/$unitName/$unitAction/context.ftlh")
        pageContent.viewMain = if (file.exists()) "$viewPathAction/context.ftlh" else ""

        if (pageContent.layoutUse) {
            viewConfig.getTemplate("/layout/default/page.ftlh").process(pageContent, out)
            pageContent.content = out.toString()
        }
    }
}