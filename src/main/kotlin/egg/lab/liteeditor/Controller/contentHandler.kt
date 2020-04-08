package egg.lab.liteeditor.Controller

import egg.lab.liteeditor.Constant
import egg.lab.liteeditor.Entity.Instance
import egg.lab.liteeditor.Entity.User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/instance")
class contentHandler {

    var instance = Constant.instance

    @ResponseBody
    @CrossOrigin
    @GetMapping("getContentByID/{id}")
    fun getContentByID(@PathVariable("id") id : Int) : Any {
        return instance.get(id)
    }

    @ResponseBody
    @CrossOrigin
    @PostMapping("updateContentByID")
    fun updateContentByCode(@RequestBody body: Map<String, String>) : Any {
        return instance.update(Instance((body["id"] ?: error("")).toInt(), User(body["code"] ?: error(""),body["content"] ?: error(""))))
    }
}