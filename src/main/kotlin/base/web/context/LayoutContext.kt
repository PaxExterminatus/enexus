package base.web.context

class LayoutContext(layoutName: String = "default") {
    var headBottom: String = ""
    var bodyTop: String = ""
    var bodyBottom: String = ""
    init {
        when (layoutName) {
            "default" -> {
                headBottom = headBottom
                .plus("<link rel=\"stylesheet\" href=\"/enexus/source/design/style.css\">")

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