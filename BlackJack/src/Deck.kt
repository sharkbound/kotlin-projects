class Deck(var owner: String) {
    val cards = arrayListOf<Card>()
    val totalValue get() = cards.sumBy { it.value }
    val busted get() = totalValue > 21

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

    fun hit(drawDeck: Deck) {
        cards.add(drawDeck.cards.pop())
    }

    fun show(skipLast: Boolean = true) {
        val printingCards = if (skipLast) cards.take(cards.lastIndex) else cards
        println(printingCards.joinToString(", "))
    }
}