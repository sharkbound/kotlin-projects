fun main(args: Array<String>) {
    play()
}

fun play() {
    val player = Deck("player")
    val dealer = Deck("Dealer")
    val draw = Deck("drawpile").fill()

    while (!player.busted && !dealer.busted) {
        if (doRound(draw, player) || doRound(draw, dealer)) {
            return
        }
    }
}

fun doRound(drawDeck: Deck, deck: Deck): Boolean {
    deck.hit(drawDeck)

    if (deck.busted) {
        println("${deck.owner} busted!")
        return true
    }

    if (deck.totalValue == 21) {
        println("${deck.owner} won!")
    }

    return false
}
