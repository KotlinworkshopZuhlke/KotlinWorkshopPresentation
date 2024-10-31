import com.zuehlke.kotlinworkshop.task.*

fun task1() {
    val userOne = UserTaskOneExampleOne(id = 1, "Bob", "bob.alice@zuehlke.com")
    val userTwo = UserTaskOneExampleTwo(name = "Alice", email = "bob.alice@zuehlke.com", id = 2)
    val userThree = UserTaskOneExampleThree(1, "Alice", "bob.alice@zuehlke.com", isActive = false)

    println(userOne)
    println(userTwo)
    println(userThree)
}
task1()

fun task2() {
    one(UserStateExampleOne.Active)
    two(UserStateExampleTwo.`Inactive USER`)
    three(UserStateExampleThree.Suspended)
}
task2()

fun task3() {
    val admin = AdminTaskThreeExampleOne(1, "Alice", "Public", "")
    val guest = GuestTaskThreeExampleOne(1, "Bob", "Private", "", isActive = false)

    println(admin.getUserInfo())
    println(guest.getUserInfo())
}
task3()

fun task4() {
    val admin = Admin(1, "Alice", "alice@example.com")
    val guest = Guest(2, "Bob", "bob@example.com")

    println(admin.getUserInfo())
    println(guest.getUserInfo())

    // Change isActive to see the logging in action
    admin.deactivate() // This should trigger logging
    guest.activate()    // This should also trigger logging
}
task4()