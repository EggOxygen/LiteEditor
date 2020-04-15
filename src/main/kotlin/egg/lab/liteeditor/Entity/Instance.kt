package egg.lab.liteeditor.Entity

import java.io.Serializable

data class Instance(
        var instanceID: Int,
        var user: User
) : Serializable