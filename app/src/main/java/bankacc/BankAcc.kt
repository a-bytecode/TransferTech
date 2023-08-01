package kredit

data class BankAcc(
    val id: Int,
    val name: String,
    val owner_firstname: String,
    val owner_surname: String,
    val balance: String,
    val currency: String,
    val iban: String
)