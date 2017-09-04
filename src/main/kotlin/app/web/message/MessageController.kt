package app.web.message

import base.web.BaseController
import base.web.context.PageContent


class MessageController: BaseController() {

    fun actionMessage() {
        pageContent.title = "Доступные темы сообщения"
        pageContent.add("<h1>${pageContent.title}</h1>")
    }

    fun actionPreview() {
        pageContent.title = "Предпросмотр соощений"
        var model = MessageModel()
        var data = model.billCoursePreview()
        viewAddContext ("bill_course", data)
        viewRender()
    }
}