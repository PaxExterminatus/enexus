package app.web.message

import base.web.BaseController
import base.web.context.PageContent
import java.io.StringWriter

class MessageController: BaseController() {


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

    fun controllerAction(action:String): PageContent {
        /*todo заменить рефликсией и вынести в Servlet*/
        var cl = this.javaClass
        var mt = cl.getMethod(action)
        mt.invoke(this)




                //        when(action){
//            "actionMessage" -> actionMessage()
//            "actionPreview" -> actionPreview()
//            else -> elseAction(action)
//        }
        return pageContent
    }

    fun actionMessage() {
        pageContent.add("gogogog");
    }

    private fun actionPreview() {
        val vOut = StringWriter()
        pageContent.title = "Предпросмотр соощений"
        pageContent.add("<h1>Предпросмотр потока сообщений</h1>")

        val vData = mutableMapOf<String, Any>()
        vData["clientId"] = 2333
        vData["totalPrice"] = 22.0f
        val tmp = viewConfig.getTemplate("preview.ftlh")
        tmp.process(vData,vOut)
        pageContent.add(vOut.toString())

        //var model = MessageData()
        //var data = model.billCourse()
    }

    private fun elseAction(action: String) {
        pageContent.title = "Message Exception"
        pageContent.add("<h1>Function not found for action $action</h1>")
    }

}