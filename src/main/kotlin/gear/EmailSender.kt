package gear

import base.web.context.EmailContent
import java.util.*

import javax.mail.*
import javax.mail.internet.*

class EmailSender {
    fun send(email: EmailContent) {
        var properties: Properties = Properties()
        properties.put("mail.smtp.host", "smtp.eshko.by")
        properties.put("mail.smtp.port", 25);
        properties.put("mail.smtp.auth", true)
        properties.put("mail.smtp.starttls.enable", false);

        var smtpAuth: Authenticator = SMTPAuthenticator()
        var session: Session = Session.getInstance(properties, smtpAuth)

        var message = MimeMessage(session)
        message.contentLanguage = email.languages
        message.setFrom(InternetAddress(email.sender," ЕШКО "))
        message.setRecipients(Message.RecipientType.TO, email.recipient)
        message.sentDate = email.sendDate
        message.subject = email.title
        message.setText(email.content, email.charset, email.mimeSubType)

        Transport.send(message)

        var store: Store = session.getStore("imap")
        store.connect("imap.eshko.by",143,"vitaliy.voronin@eshko.by","C9Ask2YalzpDzvkTAarAMirA0k54MXw")
        var folder = store.getFolder("sent")

        if (!folder.exists()) {
            folder.create(Folder.HOLDS_MESSAGES)
        }
        folder.open(Folder.READ_WRITE)
        var messages = Array(1) {message}
        folder.appendMessages(messages)
        store.close()
    }

    private class SMTPAuthenticator: Authenticator() {
        override fun getPasswordAuthentication(): PasswordAuthentication {
            return PasswordAuthentication("vitaliy.voronin@eshko.by","C9Ask2YalzpDzvkTAarAMirA0k54MXw")
        }
    }
}
