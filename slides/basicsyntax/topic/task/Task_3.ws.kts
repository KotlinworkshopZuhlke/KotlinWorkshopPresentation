/*
    Implement an AdminUser and a GuestUser - default activeState to true
    Following operations can be run on a User:
    - activate
    - deactivate
    - getUserInfo
 */

open class User(
    open val id: Int,
    open val name: String,
    open val email: String,
    open var isActive: Boolean,
): Operation {
    override fun activate() {
        this.isActive = true
    }
    override fun deactivate() {
        this.isActive = false
    }
    override fun getUserInfo(): String {
        return this.toString()
    }
}

sealed class UserState {
    object Active : UserState()
    object Inactive : UserState()
    object Suspended : UserState()
}

interface Operation {
    fun activate()
    fun deactivate()
    fun getUserInfo() : String
}

data class Admin(
    override val id: Int,
    override val name: String,
    override val email: String,
    override var isActive: Boolean,
) : User(id,name,email,isActive)

data class Guest(
    override val id: Int,
    override val name: String,
    override val email: String,
    override var isActive: Boolean = true,
) : User(id,name,email,isActive)

fun main() {
    val admin = Admin(1, "Alice", "", true)
    val guest = Guest(1, "Bob", "", isActive = false)
    println(admin.getUserInfo())
    println(guest.getUserInfo())
}
main()