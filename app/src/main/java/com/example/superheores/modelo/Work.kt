package com.example.superheores.modelo


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Work(
    @SerializedName("base")
    val base: String,
    @SerializedName("occupation")
    val occupation: String
) : Serializable