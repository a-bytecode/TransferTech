package bankacc

    data class TurnoverAcc(
        val id: String,
        val accountId: Int,
        val amount: Double,
        val senderName: String,
        val senderIban: String,
        val reference: String,
        val date: String
        )

