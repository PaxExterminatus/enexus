package app.web.message

import base.web.context.PageContext

var messagePageContext = PageContext()
/*Собития*/
fun actionMessage() {
    messagePageContext.title = "Доступные темы сообщения"
    messagePageContext.body.add("<h1>Доступные темы сообщений</h1>")
}

fun actionPreview() {
    messagePageContext.title = "Предпросмотр соощений"
    messagePageContext.body.add("<h1>Предпросмотр потока сообщений</h1>")
}

fun elseAction(action: String) {
    messagePageContext.title = "Message Exception"
    messagePageContext.body.add("<h1>Function not found for action $action</h1>")
}
/*Управление*/
fun controllerAction(action:String):PageContext{
/*todo заменить рефликсией и вынести в Servlet*/
    when(action){
        "actionMessage" -> actionMessage()
        "actionPreview" -> actionPreview()
        else -> elseAction(action)
    }
    return messagePageContext
}

val unitName = "message"
val unitRoutes = arrayOf(
        "/$unitName",
        "/$unitName/preview",
        "/$unitName/send",
        "/$unitName/task"
)
val MESSAGE = unitRoutes[0]
val MESSAGE_PREVIEW = unitRoutes[1]
val MESSAGE_SEND = unitRoutes[2]
val MESSAGE_TASK = unitRoutes[3]