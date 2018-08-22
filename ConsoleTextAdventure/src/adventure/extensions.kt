package adventure

import adventure.data.Maybe
import adventure.enums.Direction

val VALID_NORTH = setOf("north", "n")
val VALID_SOUTH = setOf("south", "s")
val VALID_EAST = setOf("east", "e")
val VALID_WEST = setOf("west", "w")

fun String.toDirection(): Maybe<Direction> =
        when {
            this in VALID_NORTH -> Maybe(Direction.North)
            this in VALID_SOUTH -> Maybe(Direction.South)
            this in VALID_EAST -> Maybe(Direction.East)
            this in VALID_WEST -> Maybe(Direction.West)
            else -> Maybe()
        }
