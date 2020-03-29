package egg.lab.liteeditor.Repository

import egg.lab.liteeditor.Entity.Instance

// This is a Repository for Instance ID Manager
interface InstanceRepository {

    fun create(instance: Instance)
    fun get(instanceID : Int) : Instance
    fun del()
}