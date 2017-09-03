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

    fun unitRouter(action: String): PageContent {
        pageContent = PageContent()
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

    fun render(viewName: String, viewData: Any) {

        var vConfig = Configuration(Configuration.VERSION_2_3_26)
        vConfig.defaultEncoding = CONTENT_CHARSET
        vConfig.setDirectoryForTemplateLoading(File(PATH_VIEW))
        var out = StringWriter()

        var file = File("$PATH_VIEW/$unitName/$unitAction/action.ftlh")
        pageContent.viewActions = if (file.exists()) "/$unitName/$unitAction/action.ftlh" else ""

        file = File("$PATH_VIEW/$unitName/$unitAction/context.ftlh")
        pageContent.viewMain = if (file.exists()) "/$unitName/$unitAction/context.ftlh" else ""

        vConfig.getTemplate("/$unitName/context/$viewName.ftlh").process(viewData, out)
        pageContent.add(out.toString())
        out = StringWriter()

        if (pageContent.layoutUse) {
            vConfig.getTemplate("/layout/default/page.ftlh").process(pageContent, out)
            pageContent.content = out.toString()
        }


//        vConfig.setDirectoryForTemplateLoading(File(viewPath))


        //vConfig.getTemplate(viewName).process(viewData, out)
       // pageContent.add(out.toString())
    }

}