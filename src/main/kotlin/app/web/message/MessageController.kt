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
        var data = model.billCoursePreview()
        pageContent.add(viewBuild("bill_course", data))
    }
    fun actionSend() {
        pageContent.title = "Отправка соощений"
        var model = MessageModel()
        var data = model.billCoursePreview()
        pageContent.add(viewBuild("bill_course", data))

        var emailContent = EmailContent()
            emailContent.body.add(viewBuild("bill_course", data));

        var out = StringWriter()
        if (emailContent.layoutUse) {
            viewConfig.getTemplate("/layout/default/email.ftlh").process(emailContent, out)
            emailContent.content = out.toString()
        }
        emailContent.recipient = "paxexterminatus@gmail.com"
        EmailSender().send(emailContent)
    }
}