package com.example.superheores.modelo


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Biography(
    @SerializedName("aliases")
    val aliases: List<String>,
    @SerializedName("alignment")
    val alignment: String,
    @SerializedName("alter-egos")
    val alterEgos: String,
    @SerializedName("first-appearance")
    val firstAppearance: String,
    @SerializedName("full-name")
    val fullName: String,
    @SerializedName("place-of-birth")
    val placeOfBirth: String,
    @SerializedName("publisher")
    val publisher: String
) : Serializable{

    override fun toString(): String {
        return "Biography(aliases=$aliases, alignment='$alignment', alterEgos='$alterEgos', firstAppearance='$firstAppearance', fullName='$fullName', placeOfBirth='$placeOfBirth', publisher='$publisher')"
    }
}