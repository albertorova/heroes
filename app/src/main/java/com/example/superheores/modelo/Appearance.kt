package com.example.superheores.modelo


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Appearance(
    @SerializedName("eye-color")
    val eyeColor: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("hair-color")
    val hairColor: String,
    @SerializedName("height")
    val height: List<String>,
    @SerializedName("race")
    val race: String,
    @SerializedName("weight")
    val weight: List<String>
) : Serializable