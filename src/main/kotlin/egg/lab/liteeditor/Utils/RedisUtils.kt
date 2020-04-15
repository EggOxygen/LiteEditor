package egg.lab.liteeditor.Utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class RedisUtils {


    @Autowired
    @Qualifier("eggRedisTemplate")
    lateinit var redisTemplate: RedisTemplate<String, Any>


    /*
    * Date: 2020/4/13
    * Author: EggOxygen
    * Desc: 用于创建更新一个实例
    */
    fun setOrUpdate(key: String, value: Any) {
        redisTemplate.opsForValue().set(key, value)
    }

    /*
    * Date: 2020/4/14
    * Author: EggOxygen
    * Desc: 用于获取一个实例
    */
    fun get(key: String) : Any? {
        return redisTemplate.opsForValue().get(key)
    }


}