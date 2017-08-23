package app

import java.nio.file.Paths

val CONTENT_CHARSET = "utf-8"
val DIR_SERVER = Paths.get(".").toAbsolutePath().normalize().toString()
val DIR_APP = DIR_SERVER.plus("/webapps/enexus")
val DIR_VIEW = DIR_APP.plus("/view")