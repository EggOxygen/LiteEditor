package egg.lab.liteeditor.Repository

import egg.lab.liteeditor.Entity.Instance
import egg.lab.liteeditor.Entity.User

// This is a Repository for Instance ID Manager
interface InstanceRepository {

    fun create(instance: Instance)
    fun get(instanceID : Int) : User
    fun update(instance: Instance)
}