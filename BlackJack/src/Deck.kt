class Deck(var owner: String) {
    val cards = arrayListOf<Card>()
    val totalValue get() = cards.sumBy { it.value }
    val hasBusted get() = totalValue > 21

    fun fill(): Deck {
        cards.clear()

        for (suit in allSuits) {
            for (rank in allRanks) {
                cards.add(Card(suit, rank))
            }
        }

        cards.shuffle()
        return this
    }

    fun pop(): Card = cards.pop()

    fun hit(drawDeck: Deck) {
        cards.add(drawDeck.pop())
    }

    fun show(skipLast: Boolean = true) {
        println(cards.joinToString(", "))
    }
}