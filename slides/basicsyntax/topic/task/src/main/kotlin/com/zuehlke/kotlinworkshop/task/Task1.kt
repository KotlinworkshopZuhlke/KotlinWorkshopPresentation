package com.zuehlke.kotlinworkshop.task

/* Class.html - Task 1
        Create a User that contains the following properties:
        - Int id
        - String name
        - String email
        - Boolean (default to true) isActive
 */

class UserTaskOneExampleOne(
    val id: Int,
    val name: String,
    val email: String,
    val isActive: Boolean = true,
)

open class UserTaskOneExampleTwo(
    open val id: Int,
    open val name: String,
    open val email: String,
    open val isActive: Boolean  = true,
)

data class UserTaskOneExampleThree(
    val id: Int,
    val name: String,
    val email: String,
    val isActive:Boolean = true,
)