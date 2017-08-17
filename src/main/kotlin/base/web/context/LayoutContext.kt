package base.web.context

class LayoutContext(layoutName: String = "default") {
    lateinit var headBottom: String
    lateinit var bodyTop: String
    lateinit var bodyBottom: String
    init {
        when (layoutName) {
            "default" -> {
                headBottom = ""
                bodyTop    = ""
                bodyBottom = ""
            } else -> {
                headBottom = ""
                bodyTop    = ""
                bodyBottom = ""
            }
        }
    }
}