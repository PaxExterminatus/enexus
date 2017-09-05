package base.web.context

import app.*
import java.util.Date

class EmailContent: HtmlContent() {
    var sender = DEFAULT_EMAIL_FROM
    var recipient: String? = null

    val sendDate
        get() = Date()
}