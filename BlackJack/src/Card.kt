class Card(val suit: Suit, val rank: Rank, private var altValue: Int? = null) {
    val value = altValue ?: rank.points

    override fun toString() = "${rank.name} of ${suit.name}"
}