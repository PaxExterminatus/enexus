package app

import java.nio.file.Paths

val CONTENT_CHARSET = "utf-8"
val PATH_SERVER = Paths.get(".").toAbsolutePath().normalize().toString()
val PATH_APP = PATH_SERVER.plus("/webapps/enexus")
val PATH_VIEW = PATH_APP.plus("/view")

val NDS = 0.2
val NDS_PRE = 20
