package app.web.message

import base.web.BaseModel

class MessageModel: BaseModel() {

    fun billCourse(queryString: String): MutableMap<String, Any> {
        var data: MutableMap<String, Any> = mutableMapOf()
        data["clientId"] = 0
        data["clientName"] = "client"
        data["clientEmail"] = "paxexterminatus@gmail.com"
        data["itemName"] = "item"
        data["totalPrice"] = 0f
        data["userName"] = "user"

//        var rs = callSas("billCourse",queryString)
//        while (rs.next()) {
//            data["clientId"] = rs.getInt("CLIENT_ID")
//            data["clientName"] = rs.getString("CLIENT_NAME").toLowerCase().capitalize()
//            data["clientEmail"] = rs.getString("CLIENT_EMAIL")
//            data["itemName"] = rs.getString("PRODUCT_NAME")
//            data["totalPrice"] = rs.getFloat("TOTAL_PRICE")
//            data["userName"] = rs.getString("USER_NAME")
//        }

        return data
    }
}