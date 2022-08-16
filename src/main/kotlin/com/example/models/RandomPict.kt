package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class RandomPict(
    val url: String = "",
    val name: String = ""
)