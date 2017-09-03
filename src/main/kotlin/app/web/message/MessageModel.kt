package app.web.message

import app.NDS
import base.web.BaseModel

class MessageModel: BaseModel() {

    fun billCoursePreview(): Any {


        var data = object {
            var itemId: Int = 32262
            var totalPrice: Float = 35f
            var userName: String = "Воронин Виталий"
            var nds = NDS
            var count = 1
            var courseName = "Английский для нацистов"
            var billDate = java.util.Date()
        }
//        var rs = callSas("actionPreview","cause=bill_course&course=1081564&usr=323")
//        while (rs.next()) {
//            data.itemId = rs.getInt("ITEM_ID")
//            data.totalPrice = rs.getFloat("TOTAL_PRICE")
//            data.userName = rs.getString("USER_NAME")
//            data.name = rs.getString("PRODUCT_NAME")
//        }
        return data
    }
}