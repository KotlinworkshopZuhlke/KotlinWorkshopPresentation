package com.zuehlke.kotlinworkshop.task

/* Class.html - Task 3
    Create `AdminUser` and `GuestUser` classes with:
       - Default active state set to true.
    Implement the following operations on a User:
    - activate
    - deactivate
    - getUserInfo

    field_property.html - Task 3
    Bonus:
    1) Add a read-only property `name` that combines firstname and lastname
    - What changes are required on the base Object
    - What is your strategy to provide the information

    2) Adjust the name property so that it can only be set with non-empty values.
    - If an attempt is made to retrieve the name when it is empty, it should return the first name and last name instead.
 */

open class UserTaskThreeExampleOne(
    open val id: Int,
    open val firstname: String,
    open val lastname: String,
    open val email: String,
    isActive: Boolean,
) : Operation {

    private var _isActive: Boolean = isActive
    var name: String = ""
        get() = field.ifEmpty {
            "$firstname $lastname"
        }
        set(value){
            require(value.isNotBlank())
            field = value
        }

    override fun activate() {
        this._isActive = true
    }

    override fun deactivate() {
        this._isActive = false
    }

    override fun getUserInfo(): String {
        return this.toString()
    }
}

data class AdminTaskThreeExampleOne(
    override val id: Int,
    override val firstname: String,
    override val lastname: String,
    override val email: String,
    private val isActive: Boolean = false,
) : UserTaskThreeExampleOne(id, firstname, lastname, email, isActive)

data class GuestTaskThreeExampleOne(
    override val id: Int,
    override val firstname: String,
    override val lastname: String,
    override val email: String,
    private val isActive: Boolean,
) : UserTaskThreeExampleOne(id, firstname, lastname, email, isActive)
