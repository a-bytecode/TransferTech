package kredit

import com.squareup.moshi.Json

data class BankAcc( // TODO: Annotation hinzufügen.

    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "owner_firstname")
    val owner_firstname: String,

    @Json(name = "owner_surname")
    val owner_surname: String,

    @Json(name = "balance")
    val balance: String,

    @Json(name = "currency")
    val currency: String,

    @Json(name = "iban")
    val iban: String
)