package app.web.message

import app.NDS
import base.web.BaseModel

class MessageModel: BaseModel() {

    fun billCoursePreview(): Any {
        var rs = callSas("actionPreview","cause=bill_course&course=1081564&usr=323")

        var data = object {
            var itemId: Int = 0
            var totalPrice: Float = 0f
            var userName: String = ""
            var nds = NDS
            var count = 1
            var name = ""
            var billDate = java.util.Date()
        }
        while (rs.next()) {
            data.itemId = rs.getInt("ITEM_ID")
            data.totalPrice = rs.getFloat("TOTAL_PRICE")
            data.userName = rs.getString("USER_NAME")
            data.name = rs.getString("PRODUCT_NAME")
        }
        return data
    }
}