package egg.lab.liteeditor

import egg.lab.liteeditor.Repository.Impl.InstanceRepositoryImpl
import egg.lab.liteeditor.Repository.Impl.UserRepositoryImpl

class PLACE_VARS {


    companion object{
        var user = UserRepositoryImpl()
        var instance = InstanceRepositoryImpl()

    }




}