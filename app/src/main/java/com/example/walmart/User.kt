package com.example.walmart

import java.io.Serializable

class User(var firstname:String, var lastname:String, var username:String, var password:String) :
Serializable {
    override fun toString(): String {
        return """Name: $firstname  $lastname 
            |Username: $username"""".trimMargin()
    }
}