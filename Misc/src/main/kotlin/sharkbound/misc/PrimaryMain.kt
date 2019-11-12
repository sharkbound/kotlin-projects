package sharkbound.misc


fun main() {
    val odometer = Odometer(FuelGauge(50)).apply {
        gauge.fill(gauge.capacity)
        while (nonEmpty) {
            println("checking the gauge you see its currently at ${check()}")
        }
    }
}

