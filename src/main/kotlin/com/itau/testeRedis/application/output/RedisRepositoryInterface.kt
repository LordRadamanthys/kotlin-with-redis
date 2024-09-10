package com.itau.testeRedis.application.output

interface RedisRepositoryInterface {

    fun SaveValue(key: String, value: String)

    fun GetValue(key: String): String
}