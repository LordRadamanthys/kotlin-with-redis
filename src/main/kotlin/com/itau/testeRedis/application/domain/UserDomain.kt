package com.itau.testeRedis.application.domain

data class UserDomain(
    var name: String,
    var lastName: String,
    var age: Int
){
    fun toLower(){
        this.name = this.name.lowercase()
        this.lastName = this.lastName.lowercase()
    }
}
