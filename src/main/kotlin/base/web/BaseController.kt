package base.web

import app.DIR_VIEW
import base.web.context.PageContext
import freemarker.template.Configuration
import java.io.File
import java.nio.file.Paths;

open class BaseController {
    var UNIT_NAME = ""
    var UNIT_ROUTES = arrayOf("")

    protected var pageContext = PageContext()

    private var viewConfig = Configuration(Configuration.VERSION_2_3_25);

    init {
        //UNIT_NAME = this.javaClass.simpleName
        viewConfig.setDirectoryForTemplateLoading(File("$DIR_VIEW/$UNIT_NAME/"))
    }
}