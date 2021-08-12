package com.example.superheores.modelo


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Connections(
        @SerializedName("group-affiliation")
        val groupAffiliation: String,
        @SerializedName("relatives")
        val relatives: String,
        @SerializedName("super-affiliation")
        val superAffiliation: String?
) : Serializable{

        override fun toString(): String {
                return "Connections(groupAffiliation='$groupAffiliation', relatives='$relatives', superAffiliation=$superAffiliation)"
        }
}