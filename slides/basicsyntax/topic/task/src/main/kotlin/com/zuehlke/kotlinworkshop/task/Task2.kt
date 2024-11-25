package com.zuehlke.kotlinworkshop.task

/* Class.html - Task 2
    Define UserState's:
    - Active
    - Inactive
    - Suspended
 */
sealed class OrderState {
    data object Pending : OrderState()
    data object Confirmed : OrderState()
    data class Shipped(val trackingNumber: String) : OrderState()
    data object Delivered : OrderState()
    data class Cancelled(val reason: String) : OrderState()
}

fun describeOrderState(state: OrderState): String {
    return when (state) {
        is OrderState.Pending -> "The order is pending."
        is OrderState.Confirmed -> "The order is confirmed."
        is OrderState.Shipped -> "The order has been shipped. Tracking number: ${state.trackingNumber}."
        is OrderState.Delivered -> "The order has been delivered."
        is OrderState.Cancelled -> "The order was cancelled. Reason: ${state.reason}."
    }
}

fun main() {
    val pending = OrderState.Pending
    val confirmed = OrderState.Confirmed
    val shipped = OrderState.Shipped("TRACK12345")
    val delivered = OrderState.Delivered
    val cancelled = OrderState.Cancelled("Payment failed")

    println(describeOrderState(pending)) // Output: The order is pending.
    println(describeOrderState(confirmed)) // Output: The order is confirmed.
    println(describeOrderState(shipped)) // Output: The order has been shipped. Tracking number: TRACK12345.
    println(describeOrderState(delivered)) // Output: The order has been delivered.
    println(describeOrderState(cancelled)) // Output: The order was cancelled. Reason: Payment failed.
}
