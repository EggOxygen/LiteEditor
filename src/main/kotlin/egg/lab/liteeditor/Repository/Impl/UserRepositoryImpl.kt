package egg.lab.liteeditor.Repository.Impl

import egg.lab.liteeditor.Entity.User
import egg.lab.liteeditor.Repository.UserRepository

class UserRepositoryImpl : UserRepository {

    var user = mutableMapOf<String,User>()

    override fun get(userCode : String): User? {
        return user[userCode]
    }

    override fun update(user: User) {
        this.user.put(user.userCode,user)
    }


    override fun delete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(userCode: String) {
        user.put(userCode,User(userCode,""))
    }
}