package base.web

import app.db.DbSeeds
import java.sql.CallableStatement
import java.sql.Connection
import oracle.jdbc.OracleTypes
import java.sql.ResultSet

open class BaseModel {
    fun callSas(action: String, params: String): ResultSet {
        var db: Connection = DbSeeds.sas.getConnection()
        var stat: CallableStatement = db.prepareCall("{? = call SYSTEM_NEXUS.getData(?,?)}")
        stat.registerOutParameter(1,OracleTypes.CURSOR)
        stat.setString(2, action)
        stat.setString(3, params)
        stat.executeUpdate()

        var dataSet: ResultSet = stat.getObject(1) as ResultSet
        return dataSet;
    }
}