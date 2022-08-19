package com.example.routes

import com.example.models.ResponseLogin
import com.example.models.ResponseRegister
import com.example.models.User
import com.example.models.userStorage
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.login() {

    route("/login") {
        post {
//            val name = call.receiveText()[0].toString()
//            val password = call.receiveText()[1].toString()
//            if (name == "rafly" && password == "qwe321") {
//            if (authStorage.status==1)
//                call.respondText(ResponseLogin(status = 1, message = "Success").toString())
//            }
//            call.respond(ResponseLogin(status = 0, message = "Failed Login"))
//            val uri = call.request.uri
//            call.respondText("Request uri: $uri")
            val formParameters = call.receiveParameters()
            val username = formParameters["username"].toString()
            val email = formParameters["email"].toString()
            val password = formParameters["password"].toString()
            val responseLogin: ResponseLogin
//            if(username=="RaflyAom"){
//            responseLogin = ResponseLogin(status = 1, message = "Welcome $username")
////            call.respondText("The '$username' account is created")
//                call.respond(responseLogin)
//            }else{
//                responseLogin = ResponseLogin(status = 0, message = "Failed Credential")
//                call.respond(responseLogin)
//            }
            val user =
                userStorage.find { it.name == username || it.email == email && it.password == password } ?: return@post call.respond(
                    ResponseLogin(status = 0, message = "Failed", data = null))
            responseLogin = ResponseLogin(status = 1, message = "Sukses", data = user)
            call.respond(responseLogin)
        }
    }

    route("/signup"){
        post {
            val formParameters = call.receiveParameters()
            val username = formParameters["username"].toString()
            val password = formParameters["password"].toString()
            val email = formParameters["email"].toString()
            val phone = formParameters["phone"].toString()
            userStorage.add(User(name = username, password, email, phone))
            val response = ResponseRegister(status = 1, message = "Sukses mendaftar", username)
                call.respond(response)
        }
    }
}