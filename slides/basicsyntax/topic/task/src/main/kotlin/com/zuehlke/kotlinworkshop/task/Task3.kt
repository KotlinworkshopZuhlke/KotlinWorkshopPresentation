import com.zuehlke.kotlinworkshop.task.OrderState
import com.zuehlke.kotlinworkshop.task.User
import java.io.File

class OrderManager {
    private val orders = mutableMapOf<User, MutableList<OrderState>>()

    fun addOrder(user: User, orderState: OrderState) {
        orders.computeIfAbsent(user) { mutableListOf() }.add(orderState)
    }

    fun getOrderStates(user: User): List<OrderState> {
        return orders[user] ?: emptyList()
    }

    fun describeOrders(user: User) {
        val userOrders = getOrderStates(user)
        if (userOrders.isEmpty()) {
            println("${user.name} has no orders.")
        } else {
            println("Orders for ${user.name}:")
            userOrders.forEach { println(describeOrderState(it)) }
        }
    }
}

fun describeOrderState(state: OrderState): String {
    return when (state) {
        is OrderState.Pending -> "Order is pending."
        is OrderState.Confirmed -> "Order is confirmed."
        is OrderState.Shipped -> "Order shipped (Tracking: ${state.trackingNumber})."
        is OrderState.Delivered -> "Order is delivered."
        is OrderState.Cancelled -> "Order cancelled (Reason: ${state.reason})."
    }
}