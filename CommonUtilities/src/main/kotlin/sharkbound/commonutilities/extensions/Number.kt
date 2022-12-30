package sharkbound.commonutilities.extensions

import kotlin.math.pow

infix fun Byte.pow(power: Int) = toDouble().pow(power).toInt().toByte()

@ExperimentalUnsignedTypes
infix fun UByte.pow(power: Int) = toDouble().pow(power).toUInt().toUByte()


infix fun Short.pow(power: Int) = toDouble().pow(power).toInt().toShort()

@ExperimentalUnsignedTypes
infix fun UShort.pow(power: Int) = toDouble().pow(power).toUInt().toUShort()

infix fun Int.pow(power: Int) = toDouble().pow(power).toInt()

@ExperimentalUnsignedTypes
infix fun UInt.pow(power: Int) = toDouble().pow(power).toUInt()

infix fun Long.pow(power: Int) = toDouble().pow(power).toLong()

@ExperimentalUnsignedTypes
infix fun ULong.pow(power: Int) = toDouble().pow(power).toULong()

infix fun Float.pow(power: Int) = pow(power)

infix fun Double.pow(power: Int) = pow(power)