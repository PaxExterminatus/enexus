package app.web.message

import app.db.DbSeed
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Types.*

class MessageData{
    private val db: Connection = DbSeed.sas.getConnection()

    fun billCourse(): BillCourse {
        var data = BillCourse()

        var call = db.prepareCall("{call MESSAGE_BUILD.PREVIEW(?,?,?)}")
        call.setString("prFLOW_CAUSE", "bill_course")
        call.setInt("prCLIENT_ID", 2333)
        call.registerOutParameter("TEMPLATE", CLOB)
        call.registerOutParameter("DATA", REF_CURSOR)
        call.executeUpdate()
        var resultData: ResultSet = call.getObject(4) as ResultSet
        while (resultData.next()){
            data.clientId = resultData.getInt("CLIENT_ID")
            data.totalPrice = resultData.getFloat("TOTAL_PRICE")
        }
        data.template = call.getString("PREVIEW_DATA")
        return data
    }
}

class BillCourse{
    var clientId = 0
    var totalPrice = 0.0f
    var template = ""
}