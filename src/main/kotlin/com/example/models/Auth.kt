package com.example.models

import kotlinx.serialization.Serializable

@Serializable
//val authStorage = ResponseLogin(status = 1, message = "Success", data = User)

data class RequestLogin(
    val username: String,
    val password: String
)

@Serializable
data class ResponseLogin(
    val status: Int,
    val message: String,
    val data: User?
)

@Serializable
data class ResponseRegister(
    val status: Int,
    val message: String,
    val username: String
)

@Serializable
data class User(val name: String, val password: String, val email: String, val phone: String)

val userStorage = mutableListOf<User>()