package egg.lab.liteeditor.Entity

import java.io.Serializable

data class User(
        var userCode : String,
        var userContent : String? = null
) : Serializable