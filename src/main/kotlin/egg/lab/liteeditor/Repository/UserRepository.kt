package egg.lab.liteeditor.Repository

import egg.lab.liteeditor.Entity.User


// This is a Repository for User
interface UserRepository {

    fun get(userCode : String) : User?
    fun update(user: User)
    fun delete()
    fun add(userCode: String)
}