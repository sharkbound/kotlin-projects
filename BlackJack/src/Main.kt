fun main(args: Array<String>) {
    play()
}

fun play() {
    val player = Deck(input("what is your name? "))
    val dealer = Deck("Dealer")
    val draw = Deck("drawpile").fill()
}
