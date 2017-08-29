package app.web.main

import base.web.BaseController

class MainController: BaseController() {

    fun actionMain(){
        pageContent.title = "E-Nexus"
        pageContent.add("<h1>${pageContent.title}</h1>")
    }
}