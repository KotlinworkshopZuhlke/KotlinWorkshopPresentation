/*
    A) Adding Delegation to Manage User State and Logging
    - Define a Loggable interface with a function logAction(action: String) to log actions performed on the user.
    - Create a LoggingDelegate class that implements Loggable. It should log any actions passed to it with a timestamp.

    B) Use Property Delegation to Track User Property Changes
    - Modify the User class to use property delegation for the isActive property and log the change by using Loggable implementation
 */
// NOTE REQUIRED!
import kotlin.properties.Delegates // Import the Delegates package for property delegation

// ADDED
interface Loggable {
    fun logAction(action: String)
}

// ADDED
class LoggingDelegate : Loggable {
    override fun logAction(action: String) {
        println("${System.currentTimeMillis()}: $action")
    }
}

// ADDED
object LOGGER {
    val INSTANCE = LoggingDelegate()
}

// ADJUSTED
open class User(
    open val id: Int,
    open val name: String,
    open val email: String,
) : Operation {

    open var isActive: Boolean by Delegates.observable(true) { _, oldValue, newValue ->
        LOGGER.INSTANCE.logAction("$this isActive changed from '$oldValue' to '$newValue'")
    }
    override fun activate() {
        this.isActive = true
    }

    override fun deactivate() {
        this.isActive = false
    }

    override fun getUserInfo(): String {
        return "User(id=$id, name='$name', email='$email', isActive=$isActive)"
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
    fun getUserInfo(): String
}

// ADJUSTED
data class Admin(
    override val id: Int,
    override val name: String,
    override val email: String,
) : User(id, name, email) // Pass isActive to the User constructor

// ADJUSTED
data class Guest(
    override val id: Int,
    override val name: String,
    override val email: String,
) : User(id, name, email) // Pass isActive to the User constructor

fun main() {
    val admin = Admin(1, "Alice", "alice@example.com")
    val guest = Guest(2, "Bob", "bob@example.com")

    println(admin.getUserInfo())
    println(guest.getUserInfo())

    // Change isActive to see the logging in action
    admin.deactivate() // This should trigger logging
    guest.activate()    // This should also trigger logging
}
main()