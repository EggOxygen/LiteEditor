package egg.lab.liteeditor.Controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class indexHandler{

    // Get Version from Config
    @Value("\${liteeditor.version}")
    lateinit var version : String

    @RequestMapping(value = [""])
    fun index(model: Model) : Any{
        model.addAttribute("version",version)
        return "index"
    }
}