package app.web.message

import base.web.BaseController
import java.io.StringWriter



class MessageController: BaseController() {

    fun actionMessage() {
        pageContent.title = "Доступные темы сообщения"
        pageContent.add("<h1>${pageContent.title}</h1>")
    }

    fun actionPreview() {
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



}