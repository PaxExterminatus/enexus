package app.web.message

import base.web.BaseController


class MessageController: BaseController() {

    fun actionMessage() {
        pageContent.title = "Доступные темы сообщения"
        pageContent.add("<h1>${pageContent.title}</h1>")
    }

    fun actionPreview() {
        pageContent.title = "Предпросмотр соощений"
        pageContent.add("<h1>Предпросмотр потока сообщений</h1>")

        val viewData: Any = object {
            var clientId = 2335
            var totalPrice = 35.0f
        }
        render("preview.ftlh", viewData)

        //var model = MessageData()
        //var data = model.billCourse()
    }



}