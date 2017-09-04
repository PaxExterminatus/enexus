package gear

import app.*
import java.util.*

import javax.mail.*
import javax.mail.internet.*

class EmailSender() {
    var properties: Properties = Properties()
    var smtpAuth: Authenticator = SMTPAuthenticator()
    var session: Session = Session.getInstance(properties,smtpAuth)
    var message: MimeMessage = MimeMessage(session)
    init {
        properties.put("mail.smtp.host", "host.eshko.by")
        properties.put("mail.smtp.port", 25);
        properties.put("mail.smtp.auth", true)
        properties.put("mail.smtp.starttls.enable", false);
    }
    fun send(messageContext: String, recipient: String, title: String) {
        message.contentLanguage = arrayOf(CONTENT_LANG)
        message.setFrom("hotline@eshko.by")
        message.setRecipients(Message.RecipientType.TO, recipient)
        message.sentDate = Date()
        message.setSubject(title, CONTENT_CHARSET)
        message.setText(messageContext, CONTENT_CHARSET)
        Transport.send(message)

        var store: Store = session.getStore("imap")
        store.connect("imap.host.by",143,"","")
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
            return PasswordAuthentication("","")

        }
    }



}
