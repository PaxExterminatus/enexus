package base.web.context

import app.*

open class HtmlContent {
    //Настройки
    var layoutUse = true
    //Значения
    var charset = CONTENT_CHARSET
    var mimeType = "text"
    var mimeSubType = "html"
    //Заголовки
    val contentType = "$mimeType/$mimeSubType;charset=$charset"
    var languages = arrayOf("ru")
    //Содержание
    var title = ""
    var body: Context = Context()

    var content = ""

    fun add(str: String) {
        body.add(str)
    }

    class Context {
        var value: String = ""
        fun add(str: String){
            value = value.plus(str).plus("\n")
        }
    }
}