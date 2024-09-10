package com.itau.testeRedis.application.utils

import java.security.MessageDigest

class HashService {
    fun gerarHash(nome: String, lastName: String): String {
        val input = "$nome$lastName"
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}