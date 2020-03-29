package egg.lab.liteeditor.Repository.Impl

import egg.lab.liteeditor.Entity.Instance
import egg.lab.liteeditor.Repository.InstanceRepository

class InstanceRepositoryImpl : InstanceRepository{

    var list = ArrayList<Instance>()

    override fun create(instance: Instance) {
        list.add(instance)
    }

    override fun get(instanceID: Int): Instance {
        return list.get(instanceID)
    }


    override fun del() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}