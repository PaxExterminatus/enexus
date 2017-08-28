package app.db

import java.sql.Connection
import java.sql.DriverManager

enum class DbSeed(private var driver: String, private var url: String, private var user: String, private var password: String) {
    sas("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@host:1521:victory", "Revelation", "fduecn");

    fun getConnection(): Connection {
        Class.forName(driver)
        return DriverManager.getConnection(url,user,password)
    }
}