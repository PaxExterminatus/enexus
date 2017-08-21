package base.source

import java.sql.DriverManager
import java.sql.Connection

class DbConnector(private val seed: DbSeed) {

    fun createConnection(): Connection {
        Class.forName(seed.driver)
        return DriverManager.getConnection(seed.url,seed.user,seed.password)
    }

}

class DbSeed(var driver: String, var url: String, var user: String, var password: String)
