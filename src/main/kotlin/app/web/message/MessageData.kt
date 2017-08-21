package app.web.message

import app.db.DBConnector
import java.sql.DriverManager
import java.sql.Connection

class MessageData{
    val db: Connection = DBConnector().connection!!
}