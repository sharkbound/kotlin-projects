package sharkbound.misc

import sharkbound.commonutils.extensions.min

interface Gauge {
    val capacity: Int
    val value: Int
    fun consume(amount: Int)
    fun fill(amount: Int)
}


class FuelGauge(override val capacity: Int) : Gauge {
    override var value: Int = 0
        private set

    override fun fill(amount: Int) {
        value = (value + amount) min capacity
    }

    override fun consume(amount: Int) {
        require(value - amount >= 0) { "consume amount cannot be greater than the current amount" }
        value -= amount
    }
}

class Odometer(val gauge: Gauge) {
    val nonEmpty get() = gauge.value > 0
    fun check() = gauge.apply { consume(1) }.value
}