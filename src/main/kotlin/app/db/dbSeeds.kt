package app.db

import java.sql.Connection
import java.sql.DriverManager

enum class DbSeed(var driver: String, var url: String, var user: String, var password: String) {
    sas("oracle.jdbc.driver.OracleDriver", "", "", "");

    fun getConnection(): Connection {
        Class.forName(driver)
        return DriverManager.getConnection(url,user,password)
    }
}