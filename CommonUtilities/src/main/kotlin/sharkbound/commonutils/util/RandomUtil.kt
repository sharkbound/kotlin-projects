package sharkbound.commonutils.util

import sharkbound.commonutils.extensions.choice
import sharkbound.commonutils.extensions.choices
import sharkbound.commonutils.rand

/**
 * gets a random [Int] between [min] (inclusive) and [max] (inclusive)]
 *
 * @return random [Int] between [min] (inclusive) and [max] (inclusive)]
 * @throws IllegalArgumentException if min is greater than or equal to max
 */
fun randInt(min: Int, max: Int): Int = rand.nextInt(min, max + 1)

/**
 * gets a random boolean value, ether true or false
 *
 * @return a pseudorandom boolean value
 */
fun randBoolean(): Boolean = rand.nextBoolean()

/**
 * gets a random [Double] between [min](inclusive) and [max](inclusive)]
 *
 * @return random int between [min](inclusive) and [max](inclusive)]
 * @throws IllegalArgumentException if min is greater than or equal to max
 */
fun randDouble(min: Double, max: Double): Double = rand.nextDouble(min, max + 1)


/**
 * gets a random [Int] between 0(inclusive) and [max](exclusive)
 */
fun randRange(max: Int) = rand.nextInt(max)

/**
 * gets a random value from the array passed in
 */
fun <T> choice(vararg values: T): T =
    values.choice()


inline fun <reified T> choices(count: Int, vararg values: T): Array<out T> =
    values.choices(count)