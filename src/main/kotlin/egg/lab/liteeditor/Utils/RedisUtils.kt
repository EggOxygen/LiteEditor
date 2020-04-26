package egg.lab.liteeditor.Utils

import egg.lab.liteeditor.Entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.util.*

@Component
class RedisUtils {


    @Autowired
    @Qualifier("eggRedisTemplate")
    lateinit var redisTemplate: RedisTemplate<String, Any>


    /*
    * Date: 2020/4/24
    * Author: EggOxygen
    * Desc: 用于创建或者更新一个实例 Hash
    */
    fun setOrUpdate(key: String, value: User) {
        redisTemplate.opsForHash<String, User>().put("EDITOR", key, value)
    }

    /*
    * Date: 2020/4/14
    * Author: EggOxygen
    * Desc: 用于获取一个实例 Hash
    */
    fun get(key: String): Any? {
        return redisTemplate.opsForHash<String, User>().get("EDITOR", key)
    }


}