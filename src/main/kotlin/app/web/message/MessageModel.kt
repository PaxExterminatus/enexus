package app.web.message

import app.db.DbSeeds
import oracle.jdbc.OracleTypes
import java.sql.Connection
import java.sql.ResultSet



class MessageModel {

    fun billCoursePreview(): Any {
        var db = DbSeeds.sas.getConnection()
        var call = db.prepareCall("{call MESSAGE_BUILD.PREVIEW(?,?,?)}")
        var data = object {
            var clientId: Int = 0
            var totalPrice: Float = 0f
        }

        call.setString("FLOW_CAUSE", "bill_course")
        call.setInt("CLIENT_ID", 2333)
        call.registerOutParameter("DATA_CURSOR", OracleTypes.CURSOR)
        call.executeUpdate()
        var rs = call.getObject("DATA_CURSOR") as ResultSet
        while (rs.next()) {
            data.clientId = rs.getInt("CLIENT_ID")
            data.totalPrice = rs.getFloat("TOTAL_PRICE")
        }
        return data
    }
}