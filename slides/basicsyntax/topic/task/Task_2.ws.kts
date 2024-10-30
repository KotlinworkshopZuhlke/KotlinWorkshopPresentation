/*
    Define UserState's:
    - Active
    - Inactive
    - Suspended
 */

enum class UserStateExampleOne {
    Active,
    Inactive,
    Suspended
}

enum class UserStateExampleTwo {
    `Active`,
    `Inactive`,
    `Suspended`
}

sealed class UserStateExampleThree {
    object Active : UserStateExampleThree()
    object Inactive : UserStateExampleThree()
    object Suspended : UserStateExampleThree()
}

fun one(state: UserStateExampleOne) {
    when (state) {
        UserStateExampleOne.Active -> println("ONE: ${state}")
        else -> println("else")
    }
}

fun two(state: UserStateExampleTwo) {
    when (state) {
        UserStateExampleTwo.Inactive -> println("TWO: ${state}")
        else -> println("else")
    }
}

fun three(state: UserStateExampleThree) {
    when (state) {
        is UserStateExampleThree.Suspended -> println("THREE: ${state}")
        else -> println("else")
    }
}

fun main() {
    one(UserStateExampleOne.Active)
    two(UserStateExampleTwo.Inactive)
    three(UserStateExampleThree.Suspended)
}
main()