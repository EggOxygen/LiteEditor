package egg.lab.liteeditor.Utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class RedisUtils {


    @Autowired
    @Qualifier("eggRedisTemplate")
    lateinit var redisTemplate: RedisTemplate<String, Any>


    /*
    * Date: 2020/4/13
    * Author: EggOxygen
    * Desc: 用于创建一个实例
    */
    fun set(key: String, value: Any) {
        redisTemplate.opsForValue().set(key, value)
        // Egg:20200414: 默认六小时过期
        redisTemplate.expire(key, 6L, TimeUnit.HOURS)
    }

    /*
    * Date: 2020/4/15
    * Author: EggOxygen
    * Desc: 更新一个实例
    */
    fun update(key: String, value: Any) {
        redisTemplate.opsForValue().set(key, value)
    }

    /*
    * Date: 2020/4/14
    * Author: EggOxygen
    * Desc: 用于获取一个实例
    */
    fun get(key: String): Any? {
        return redisTemplate.opsForValue().get(key)
    }


}