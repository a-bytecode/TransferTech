package bankacc

import com.squareup.moshi.Json

data class TurnoverAcc( // TODO: Vergessen die data class mit der @Json Annotation zu markieren.
// Hier verwende ich die Annotation um keine gleichnamigen Attribute zu verwenden wie in der JSON selbst.
        @Json(name = "id")
        val id: String,

        @Json(name = "account_id")
        val accIdentifier: Int, // bspw. -> hier!

        @Json(name = "amount")
        val amount: Double,

        @Json(name = "sender_name")
        val sender_name: String,

        @Json(name = "sender_iban")
        val sender_iban: String,

        @Json(name = "reference")
        val reference: String,

        @Json(name = "date")
        val date: String

        )