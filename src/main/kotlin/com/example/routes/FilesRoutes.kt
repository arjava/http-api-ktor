package com.example.routes

import com.example.models.RandomPict
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://172.17.3.61:8080"
val randomsImage = listOf<RandomPict>(
    RandomPict(url = "$BASE_URL/images/404_image.png", name = "404 image"),
    RandomPict(url = "$BASE_URL/images/bannar_1.jpg", name = "banner image"),
    RandomPict(url =  "$BASE_URL/images/ktor_logo.png", name = "ktor logo" ),
    )

fun Route.filesRouting() {
    get("/random_image"){
        val randoms = randomsImage.random()
        call.respond(
            HttpStatusCode.OK,
            RandomPict(url = randoms.url, randoms.name)
        )
    }
}