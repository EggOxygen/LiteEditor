package egg.lab.liteeditor

import egg.lab.liteeditor.Entity.Instance
import egg.lab.liteeditor.Entity.User
import egg.lab.liteeditor.Utils.RedisUtils
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate
import kotlin.reflect.jvm.jvmName
import kotlin.reflect.typeOf

@SpringBootTest
class LiteEditorApplicationTests {

    @Test
    fun contextLoads() {
    }

}
