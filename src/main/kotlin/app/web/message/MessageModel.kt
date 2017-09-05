package app.web.message

import base.web.BaseModel

class MessageModel: BaseModel() {

    fun billCourse(queryString: String): MutableMap<String, Any> {
        var data: MutableMap<String, Any> = mutableMapOf()
        data.plus(Pair("clientId",0))
        data.plus(Pair("clientName",""))
        data.plus(Pair("clientEmail",""))
        data.plus(Pair("itemName",""))
        data.plus(Pair("totalPrice",0f))
        data.plus(Pair("userName",""))

        var rs = callSas("billCourse",queryString)
        while (rs.next()) {
            data["clientId"] = rs.getInt("CLIENT_ID")
            data["clientName"] = rs.getString("CLIENT_NAME").toLowerCase().capitalize()
            data["clientEmail"] = rs.getString("CLIENT_EMAIL")
            data["itemName"] = rs.getString("PRODUCT_NAME")
            data["totalPrice"] = rs.getFloat("TOTAL_PRICE")
            data["userName"] = rs.getString("USER_NAME")
        }
        return data
    }
}