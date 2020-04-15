package egg.lab.liteeditor.Config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import java.net.UnknownHostException

@Configuration
class RedisConfig {

    @Bean
    @Throws(UnknownHostException::class)
    fun eggRedisTemplate(redisConnectionFactory: RedisConnectionFactory?): RedisTemplate<String?, Any?>? {
        val template = RedisTemplate<String?, Any?>()
        template.setDefaultSerializer(Jackson2JsonRedisSerializer(Any::class.java))
        template.setConnectionFactory(redisConnectionFactory!!)
        template.afterPropertiesSet()
        return template
    }
}