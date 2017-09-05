package app

import java.nio.file.Paths

val CONTENT_CHARSET = "utf-8"
val CONTENT_LANG = "ru"
val PATH_SERVER = Paths.get(".").toAbsolutePath().normalize().toString()
val PATH_APP = PATH_SERVER.plus("/webapps/enexus")
val PATH_LAYOUT = PATH_APP.plus("/layout")
val PATH_VIEW = PATH_APP.plus("/view")

val LAYOUT_CURRENT = "default"

val NDS = 0.2
val NDS_PRE = 20

val DEFAULT_EMAIL_FROM = "hotline@eshko.by"