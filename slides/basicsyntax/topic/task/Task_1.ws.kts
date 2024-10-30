/*
    Task 1
        Create a User that contains the following properties:
        - Int id
        - String name
        - String email
        - Boolean (default to true) isActive
 */

class UserExampleOne(
    val id: Int,
    val name: String,
    val email: String,
    val isActive: Boolean,
)

open UserExampleOne(
    open val id: Int,
    open val name: String,
    open val email: String,
    open val isActive: Boolean,
)

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val isActive: Boolean,
)

fun main() {
    val userOne = UserExampleOne(1, "Bob", "bob.alice@zuehlke.com", false)
    val userTwo = User(1, "Alice", "bob.alice@zuehlke.com", false)

    println(userOne)
    println(userTwo)
}
main()
