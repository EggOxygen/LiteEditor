package egg.lab.liteeditor.Controller

import egg.lab.liteeditor.Entity.Instance
import egg.lab.liteeditor.PLACE_VARS
import org.apache.logging.log4j.util.Base64Util
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import kotlin.random.Random

@Controller
@RequestMapping("/instance")
class instanceHandler {

    var user = PLACE_VARS.user
    var instance = PLACE_VARS.instance

    @ResponseBody
    @CrossOrigin
    @GetMapping("createInstance")
    fun createInstance() : Any{
        var id = Random.nextInt(1000,4000).toString()
        var code = Base64Util.encode(Random.nextDouble(1.0, 10000.0).toString()).toString().replace('=','E')
        var list = mutableMapOf<String,String>()
        list["ID"] = id
        list["CODE"] = code
        instance.create(Instance(id.toInt(),code))
        // Also Add a empty user
        user.add(code)
        return list
    }

    @RequestMapping("newInstance")
    fun newIns() : Any{
        return "newInstance"
    }



    @RequestMapping("userInstance")
    fun userInstance(@RequestParam("id") id : String,model: Model) : Any {
        return "redirect:userInstance.html?id=" + id
    }

}