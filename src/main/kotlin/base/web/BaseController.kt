package base.web

import app.*
import base.web.context.PageContent
import freemarker.template.Configuration
import java.io.File
import java.io.StringWriter

open class BaseController {
    val unitName: String = Regex("(^.+)(?:controller)").matchEntire(this.javaClass.simpleName.toLowerCase())!!.groups[1]!!.value
    var unitAction: String = ""
    var pageContent = PageContent()

    var out = StringWriter()

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
        return pageContent
    }

    private fun unitActionException(action: String) {
        pageContent.title = "Controller Exception"
        pageContent.add("<h1>Function not found for action $action</h1>")
    }

    fun viewAddContext(viewName: String, viewData: Any){
        viewConfig.getTemplate("$viewPathContext/$viewName.ftlh").process(viewData, out)
        pageContent.add(out.toString())
        out = StringWriter()
    }

    fun viewRender() {
        var file = File("$PATH_VIEW/$unitName/$unitAction/action.ftlh")
        pageContent.viewActions = if (file.exists()) "$viewPathAction/action.ftlh" else ""

        file = File("$PATH_VIEW/$unitName/$unitAction/context.ftlh")
        pageContent.viewMain = if (file.exists()) "$viewPathAction/context.ftlh" else ""

        if (pageContent.layoutUse) {
            viewConfig.getTemplate("/layout/default/page.ftlh").process(pageContent, out)
            pageContent.content = out.toString()
        }
        out = StringWriter()
    }
}