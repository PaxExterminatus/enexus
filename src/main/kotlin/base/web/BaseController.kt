package base.web

import app.CONTENT_CHARSET
import app.PATH_VIEW
import base.web.context.PageContent
import freemarker.template.Configuration
import java.io.File

open class BaseController {
    val unitName: String = Regex("(^.+)(?:controller)").matchEntire(this.javaClass.simpleName.toLowerCase())!!.groups[1]!!.value
    //var unitRouters: Array<String> = arrayOf("/$unitName")
    protected var pageContent = PageContent()
    protected var viewConfig = Configuration(Configuration.VERSION_2_3_25);
    init {
//        this::class.members.forEach{
//           val action = Regex("(?:action)(.+)").matchEntire(it.name.toLowerCase())?.groups?.get(1)?.value ?: ""
//            if (action != "" && action != unitName) {
//                unitRouters = unitRouters.plus("/$unitName/$action/* ")
//            }
//        }
        viewConfig.setDirectoryForTemplateLoading(File("$PATH_VIEW/$unitName/"))
        viewConfig.defaultEncoding = CONTENT_CHARSET
    }

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
        pageContent.title = "Message Exception"
        pageContent.add("<h1>Function not found for action $action</h1>")
    }
}