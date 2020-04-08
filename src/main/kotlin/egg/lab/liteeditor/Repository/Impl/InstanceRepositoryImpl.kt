package egg.lab.liteeditor.Repository.Impl

import egg.lab.liteeditor.Entity.Instance
import egg.lab.liteeditor.Entity.User
import egg.lab.liteeditor.Repository.InstanceRepository

class InstanceRepositoryImpl : InstanceRepository{

    var list = HashMap<Int,User>()

    override fun create(instance: Instance) {
        list[instance.instanceID] = instance.user
    }

    override fun get(instanceID: Int): User {
        return list[instanceID]!!
    }

    override fun update(instance: Instance) {
        list[instance.instanceID] = instance.user
    }
}