package kredit

data class Kredit(
    val id: Int,
    val name: String,
    val ownerFirstname: String,
    val ownerSurname: String,
    val balance: Double,
    val currency: String,
    val iban: String
)