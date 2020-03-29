package egg.lab.liteeditor.Controller

import egg.lab.liteeditor.Entity.User
import egg.lab.liteeditor.PLACE_VARS
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/instance")
class contentHandler {

    var user = PLACE_VARS.user

    @ResponseBody
    @CrossOrigin
    @RequestMapping("getContentByCode/{code}")
    fun getContentByID(@PathVariable("code") code : String) : Any {
        var user = user.get(code)
        var list = mutableListOf<User>()
        if (user != null) {
            list.add(0,user)
        }
        return list
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping("updateContentByCode/{code}")
    fun updateContentByCode(@PathVariable("code") code : String, @RequestBody body: Map<String, String>) : Any {
        user.update(User(code, body["content"].toString()))
        return body
    }
}