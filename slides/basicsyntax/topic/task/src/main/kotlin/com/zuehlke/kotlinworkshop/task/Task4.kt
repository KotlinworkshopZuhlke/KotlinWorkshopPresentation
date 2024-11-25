package com.zuehlke.kotlinworkshop.task

/*
    A) Adding Delegation to Manage User State and Logging
    - Define a Loggable interface with a function logAction(action: String) to log actions performed on the user.
    - Create a LoggingDelegate class that implements Loggable. It should log any actions passed to it with a timestamp.

    B) Use Property Delegation to Track User Property Changes
    - Modify the User class to use property delegation for the isActive property and log the change by using Loggable implementation
 */
import kotlin.reflect.KProperty
import kotlin.properties.Delegates

open class UserTask4(
    open val id: Int,
    open val name: String,
    open val email: String,
) : Operation {

    open var isActive: Boolean by Delegates.observable(true) { property: KProperty<*>, oldValue, newValue ->
        LOGGER.INSTANCE.logAction("${property.name} changed from '$oldValue' to '$newValue'")
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

interface Loggable {
    fun logAction(action: String)
}

class LoggingDelegate : Loggable {
    override fun logAction(action: String) {
        println("${System.currentTimeMillis()}: $action")
    }
}
object LOGGER {
    val INSTANCE = LoggingDelegate()
}

interface Operation {
    fun activate()
    fun deactivate()
    fun getUserInfo(): String
}

data class Admin(
    override val id: Int,
    override val name: String,
    override val email: String,
) : UserTask4(id, name, email)

data class Guest(
    override val id: Int,
    override val name: String,
    override val email: String,
) : UserTask4(id, name, email)