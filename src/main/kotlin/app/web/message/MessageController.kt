package app.web.message

import base.web.BaseController
import base.web.context.EmailContent
import gear.EmailSender
import java.io.StringWriter


class MessageController: BaseController() {

    fun actionMessage() {
        pageContent.title = "Доступные темы сообщения"
        pageContent.add("<h1>${pageContent.title}</h1>")
    }

    fun actionPreview() {
        pageContent.title = "Предпросмотр соощений"
        var model = MessageModel()
        var data = model.billCourse(reqQueryString)
        pageContent.add(viewBuild("/layout/default/email.ftlh", data))
    }

    fun actionSend() {
        pageContent.title = "Отправка соощений"
        var model = MessageModel()
        var data = model.billCourse(reqQueryString)
        pageContent.add(viewBuild("/layout/default/email.ftlh", data))

        var emailContent = EmailContent()
        emailContent.title = "Регистрационный взнос: письмо-инструкция"

        var out = StringWriter()
        if (emailContent.layoutUse) {
            viewConfig.getTemplate("/layout/default/email.ftlh").process(data, out)
            emailContent.content = out.toString()
        }
        emailContent.recipient = data["clientEmail"] as String
        EmailSender().send(emailContent)
    }
}