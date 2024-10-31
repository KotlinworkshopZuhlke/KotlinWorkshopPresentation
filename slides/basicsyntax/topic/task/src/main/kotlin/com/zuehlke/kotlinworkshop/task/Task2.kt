package com.zuehlke.kotlinworkshop.task

/* Class.html - Task 2
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
    `Active USER`,
    `Inactive USER`,
    `Suspended USER`
}

sealed class UserStateExampleThree {
    data object Active : UserStateExampleThree()
    data object Inactive : UserStateExampleThree()
    data object Suspended : UserStateExampleThree()
}


/*EXAMPLE*/
fun one(state: UserStateExampleOne) {
    when (state) {
        UserStateExampleOne.Active -> println("ONE: $state")
        UserStateExampleOne.Inactive -> println("ONE: $state")
        UserStateExampleOne.Suspended -> println("ONE: $state")
    }
}

fun two(state: UserStateExampleTwo) {
    when (state) {
        UserStateExampleTwo.`Active USER`,
        UserStateExampleTwo.`Inactive USER`,
        UserStateExampleTwo.`Suspended USER` ->
            println("TWO: $state")
    }
}

fun three(state: UserStateExampleThree) {
    when (state) {
        is UserStateExampleThree.Active,
        is UserStateExampleThree.Inactive -> println("THREE: $state")
        else -> println("Not Implemented")
    }
}