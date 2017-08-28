package base.web

import app.CONTENT_CHARSET
import app.PATH_VIEW
import base.web.context.PageContent
import freemarker.template.Configuration
import java.io.File

open class BaseController {
    val UNIT_NAME: String
    lateinit var actions: Array<String>
    //var UNIT_ROUTES = arrayOf("")
    protected var pageContent = PageContent()
    protected var viewConfig = Configuration(Configuration.VERSION_2_3_25);
    init {
        UNIT_NAME = Regex("(^.+)(?:controller)").matchEntire(this.javaClass.simpleName.toLowerCase())!!.groups[1]!!.value
        viewConfig.setDirectoryForTemplateLoading(File("$PATH_VIEW/$UNIT_NAME/"))
        viewConfig.defaultEncoding = CONTENT_CHARSET
    }
}