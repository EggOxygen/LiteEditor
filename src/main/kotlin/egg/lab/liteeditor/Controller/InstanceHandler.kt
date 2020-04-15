package egg.lab.liteeditor.Controller

import egg.lab.liteeditor.Entity.Instance
import egg.lab.liteeditor.Entity.User
import egg.lab.liteeditor.Utils.RedisUtils
import org.apache.logging.log4j.util.Base64Util
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse
import kotlin.random.Random

@Controller
@RequestMapping("/instance")
class InstanceHandler {

    @Autowired
    lateinit var redisUtils : RedisUtils

    @ResponseBody
    @CrossOrigin
    @GetMapping("createInstance")
    /*
    * Date: 2020/4/14
    * Author: EggOxygen
    * Desc: 创建一个实例
    */
    fun createInstance() : Any{
        var id = Random.nextInt(1000,8000)
        var code = Base64Util.encode(id.toString()).replace('=','E')
        var list = mutableMapOf<String,String>()
        list["ID"] = id.toString()
        list["CODE"] = code
        list["STATUS"] = "离线状态"
        redisUtils.set(id.toString(), User(code))
        return list
    }

    /*
    * Date: 2020/4/14
    * Author: EggOxygen
    * Desc: View 跳转页面
    */
    @RequestMapping("newInstance")
    fun newIns() : Any{
        return "newInstance"
    }


    /*
    * Date: 2020/4/14
    * Author: EggOxygen
    * Desc: 返回一个用户实例
    */
    @RequestMapping("userInstance")
    fun userInstance(@RequestParam("id") id : String,
                     @RequestParam("code") code : String) : Any {
        return "redirect:userInstance.html?id=$id&code=$code"
    }

}