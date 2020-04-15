package egg.lab.liteeditor.Controller

import egg.lab.liteeditor.Entity.Instance
import egg.lab.liteeditor.Entity.User
import egg.lab.liteeditor.Utils.RedisUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/instance")
class contentHandler {

    @Autowired
    lateinit var redisUtils : RedisUtils

    @ResponseBody
    @CrossOrigin
    @GetMapping("getContentByID/{id}")
    /*
    * Date: 2020/4/14
    * Author: EggOxygen
    * Desc: 获取内容
    */
    fun getContentByID(@PathVariable("id") id : Int) : Any? {
        return redisUtils.get(id.toString())
    }

    @ResponseBody
    @CrossOrigin
    @PostMapping("updateContentByID")
    /*
    * Date: 2020/4/14
    * Author: EggOxygen
    * Desc: 更新内容
    */
    fun updateContentByCode(@RequestBody body: Map<String, String>) : Any {
        return  redisUtils.setOrUpdate(body["id"].toString(), User(body["code"]!!,body["content"]))
    }
}