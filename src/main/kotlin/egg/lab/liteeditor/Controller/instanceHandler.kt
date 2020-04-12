package egg.lab.liteeditor.Controller

import egg.lab.liteeditor.Entity.Instance
import egg.lab.liteeditor.Constant
import egg.lab.liteeditor.Entity.User
import org.apache.logging.log4j.util.Base64Util
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse
import kotlin.random.Random

@Controller
@RequestMapping("/instance")
class instanceHandler {

    var instance = Constant.instance

    @ResponseBody
    @CrossOrigin
    @GetMapping("createInstance")
    fun createInstance() : Any{
        var id = Random.nextInt(1000,8000)
        var code = Base64Util.encode(id.toString()).replace('=','E')
        var list = mutableMapOf<String,String>()
        list["ID"] = id.toString()
        list["CODE"] = code
        instance.create(instance = Instance(id, User(code)))
        return list
    }

    @RequestMapping("newInstance")
    fun newIns(response : HttpServletResponse) : Any{
        return "newInstance"
    }


    @RequestMapping("userInstance")
    fun userInstance(@RequestParam("id") id : String,
                     @RequestParam("code") code : String) : Any {
        return "redirect:userInstance.html?id=$id&code=$code"
    }

}