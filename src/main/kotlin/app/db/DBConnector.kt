package app.db

import java.sql.DriverManager
import java.sql.Connection

class DBConnector(dbmsType: Int = 1, paramsType: Int = 1) {
    var connection: Connection?
    init {
        connection = when (dbmsType) {
            1 -> dbmsOracle(paramsType)
            else -> { null }
        }
    }

    private fun dbmsOracle(paramsType: Int): Connection {
        Class.forName("oracle.jdbc.driver.OracleDriver")
        var url = ""
        var user = ""
        var password = ""

        when (paramsType) {
            1 -> {
                url = REV_URL
                user = REV_USER
                password = REV_PASS
            }
        }

        return DriverManager.getConnection(url,user,password)

    }

}