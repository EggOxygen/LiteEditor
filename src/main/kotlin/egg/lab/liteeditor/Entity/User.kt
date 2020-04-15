package egg.lab.liteeditor.Entity

import egg.lab.liteeditor.enum.Status
import java.io.Serializable

data class User(
        var userCode : String,
        var userStatus : String? = Status.OFFLINE.name,
        var userContent : String? = null
) : Serializable