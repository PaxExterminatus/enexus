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

val UNIT_NAME = "message"
val UNIT_ROUTES = arrayOf(
        "/$UNIT_NAME",
        "/$UNIT_NAME/preview",
        "/$UNIT_NAME/send",
        "/$UNIT_NAME/task"
)
val MESSAGE = UNIT_ROUTES[0]
val MESSAGE_PREVIEW = UNIT_ROUTES[1]
val MESSAGE_SEND = UNIT_ROUTES[2]
val MESSAGE_TASK = UNIT_ROUTES[3]