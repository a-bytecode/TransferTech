package bankacc

    data class TurnoverAcc(
        val id: String,
        val account_id: Int,
        val amount: Double,
        val sender_name: String,
        val sender_iban: String,
        val reference: String,
        val date: String
        )