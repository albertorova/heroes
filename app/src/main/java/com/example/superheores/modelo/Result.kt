package com.example.superheores.modelo


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Result(
        @SerializedName("appearance")
        val appearance: Appearance,
        @SerializedName("biography")
        val biography: Biography,
        @SerializedName("connections")
        val connections: Connections,
        @SerializedName("id")
        val id: String,
        @SerializedName("image")
        val image: Image,
        @SerializedName("name")
        val name: String,
        @SerializedName("powerstats")
        val powerstats: Powerstats,
        @SerializedName("work")
        val work: Work
) : Serializable {

    override fun toString(): String {
        return "${connections}\n" +
                "${work.occupation}\n" +
                "$connections ${connections}\n" +
                "${work.occupation}\n" +
                "${connections}\n${biography}"
    }
}