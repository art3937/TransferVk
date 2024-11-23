import kotlin.math.max

fun main() {
    val userMoney = 60_000
    val card = "Visa"
    val amountOfPreviousTransfers = 16_000
    val result = transferMoney(card, amountOfPreviousTransfers, userMoney)
    println(result)
}

fun transferMoney(
    card: String = "Мир",
    amountOfPreviousTransfers: Int = 0,
    transferAmount: Int
): Int {
    val limitMouth = 600_000
    val dailyLimit = 150_000
    var commissionSize = 0
    if (transferAmount >= limitMouth + amountOfPreviousTransfers ||
        transferAmount >= dailyLimit
    ) {
        return -1
    } else {
        commissionSize = when (card) {
            "Maestro" ->   toMastercard(transferAmount,amountOfPreviousTransfers)
            "Mastercard" -> toMastercard(transferAmount,amountOfPreviousTransfers)
            "Мир" -> max(35, (transferAmount / 100 * 0.75).toInt())
            "Visa" -> max(35, (transferAmount / 100 * 0.75).toInt())
            "VK Pay" -> if (amountOfPreviousTransfers + transferAmount < 40_000 && transferAmount < 15000 ) 0 else -1
            else -> -1
        }
        return commissionSize
    }
}
fun toMastercard(transferAmount: Int,amountOfPreviousTransfers: Int): Int{
    return when{
        (amountOfPreviousTransfers + transferAmount in 75001 downTo 300)
            -> 0
        else -> (transferAmount / 100 * 0.6 + 20).toInt()
    }
}