package app.web.message

import base.web.BaseModel

class MessageModel: BaseModel() {

    fun billCoursePreview(): Any {
        var data = object {
            var clientId: Int = 0
            var clientName = ""
            var itemName = ""
            var totalPrice: Float = 0f
            var userName: String = ""
        }
        var rs = callSas("actionPreview","cause=bill_course&course=1081564&usr=323")
        while (rs.next()) {
            data.clientId = rs.getInt("CLIENT_ID")
            data.clientName = rs.getString("CLIENT_NAME").capitalize()
            data.itemName = rs.getString("PRODUCT_NAME")
            data.totalPrice = rs.getFloat("TOTAL_PRICE")
            data.userName = rs.getString("USER_NAME")
        }
        return data
    }
}