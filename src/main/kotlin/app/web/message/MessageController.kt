package app.web.message

import base.web.BaseController


class MessageController: BaseController() {

    fun actionMessage() {
        pageContent.title = "Доступные темы сообщения"
        pageContent.add("<h1>${pageContent.title}</h1>")
    }

    fun actionPreview() {
        pageContent.title = "Предпросмотр соощений"
        pageContent.add("<h1>${pageContent.title}</h1>")
        var model = MessageModel()
        var data = model.billCoursePreview()
        render("bill_course.ftlh", data)
    }
}