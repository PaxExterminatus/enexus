package app.web.message

import base.web.context.PageContext
import freemarker.template.*
import java.io.File
import java.io.StringWriter
import java.nio.file.Paths

class MessageController {
    private var pageContext = PageContext()

    val UNIT_NAME = "message"
    val UNIT_ROUTES = arrayOf(
            "/$UNIT_NAME",
            "/$UNIT_NAME/preview",
            "/$UNIT_NAME/send",
            "/$UNIT_NAME/task"
    )
    val MESSAGE = UNIT_ROUTES[0]
    val MESSAGE_PREVIEW = UNIT_ROUTES[1]
    val MESSAGE_SEND = UNIT_ROUTES[2]
    val MESSAGE_TASK = UNIT_ROUTES[3]

    var vCfg: Configuration = Configuration(Configuration.VERSION_2_3_25);

    init {
        val dir = Paths.get(".").toAbsolutePath().normalize().toString()
        vCfg.setDirectoryForTemplateLoading(File(dir.plus("/webapps/enexus/view/$UNIT_NAME/"))) //d:/devlib/tomcat8/webapps/enexus/view/message/
        vCfg.defaultEncoding = "utf-8"
    }

    private fun actionMessage() {
        pageContext.title = "Доступные темы сообщения"
        pageContext.body.add("<h1>Доступные темы сообщений</h1>")
    }

    private fun actionPreview() {
        val vOut = StringWriter()
        pageContext.title = "Предпросмотр соощений"
        pageContext.body.add("<h1>Предпросмотр потока сообщений</h1>")


        val vData = mutableMapOf<String, String>()
        vData["clientId"] = "2333"
        vData["totalPrice"] = "22"
        val tmp = vCfg.getTemplate("preview.ftlh")
        tmp.process(vData,vOut)
        pageContext.body.add(vOut.toString())

        //var model = MessageData()
        //var data = model.billCourse()
    }

    private fun elseAction(action: String) {
        pageContext.title = "Message Exception"
        pageContext.body.add("<h1>Function not found for action $action</h1>")
    }
    fun controllerAction(action:String):PageContext{
        /*todo заменить рефликсией и вынести в Servlet*/
        when(action){
            "actionMessage" -> actionMessage()
            "actionPreview" -> actionPreview()
            else -> elseAction(action)
        }
        return pageContext
    }
}