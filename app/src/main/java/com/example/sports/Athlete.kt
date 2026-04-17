package com.example.sports

import java.io.Serializable

data class Athlete(
    val name: String,
    val sport: String,
    val earnings: String,
    val description: String,
    val imageRes: Int
) : Serializable