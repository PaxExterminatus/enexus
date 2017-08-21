package app.web.message

import base.web.context.PageContext
import freemarker.template.*
import java.io.StringReader
import java.io.StringWriter

class MessageController{
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

    private fun actionMessage() {
        pageContext.title = "Доступные темы сообщения"
        pageContext.body.add("<h1>Доступные темы сообщений</h1>")
    }

    private fun actionPreview() {
        pageContext.title = "Предпросмотр соощений"
        pageContext.body.add("<h1>Предпросмотр потока сообщений</h1>")

        var model = MessageData()
        var data = model.billCourse()

        val template = Template("name", StringReader(data.template), Configuration(Configuration.VERSION_2_3_26))
        val out = StringWriter()
        template.process(data,out)
        val str = out.toString()

        pageContext.body.add(str)
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