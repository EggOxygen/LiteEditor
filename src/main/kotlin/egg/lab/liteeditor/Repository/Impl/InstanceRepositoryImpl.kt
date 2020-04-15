//package egg.lab.liteeditor.Repository.Impl
//
//import egg.lab.liteeditor.Entity.Instance
//import egg.lab.liteeditor.Entity.User
//import egg.lab.liteeditor.Repository.InstanceRepository
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.beans.factory.annotation.Qualifier
//import org.springframework.data.redis.core.RedisTemplate
//import org.springframework.stereotype.Repository
//
//@Repository
//class InstanceRepositoryImpl : InstanceRepository{
//
//
//    @Autowired
//    @Qualifier("eggRedisTemplate")
//    lateinit var redisTemplate: RedisTemplate<String, Any>
//
////    var list = HashMap<Int,User>()
//
//    override fun setOrupdate(instance: Instance) {
//        redisTemplate.opsForValue().set(instance.instanceID.toString(),instance.user)
////        list[instance.instanceID] = instance.user
//    }
//
//    override fun get(instanceID: Int): User {
//        return redisTemplate.opsForValue().get(instanceID.toString()) as User
////        return list[instanceID]!!
//    }
//}