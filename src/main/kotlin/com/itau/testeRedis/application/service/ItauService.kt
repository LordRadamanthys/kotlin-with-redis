package com.itau.testeRedis.application.service

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.itau.testeRedis.application.domain.UserDomain
import com.itau.testeRedis.application.output.RedisRepositoryInterface
import com.itau.testeRedis.application.utils.HashService
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

@Service
class ItauService(
    val redisRepository: RedisRepositoryInterface
) {
    val t = UserDomain(
        "Mateus",
        "Lima",
        40
    )
    val objectMapper = jacksonObjectMapper()
    fun GetUserService(name: String, lastName: String): UserDomain {


        val hashKey = HashService().gerarHash(name, lastName)

        val value = redisRepository.GetValue(hashKey)

        if (value != null) {
            val userFromRedis: UserDomain = objectMapper.readValue(value)
            return userFromRedis
        }

        return t
    }

    fun SaveUser(user: UserDomain) {
        user.toLower()
        val userJson = objectMapper.writeValueAsString(user)

        val hashKey = HashService().gerarHash(user.name, user.lastName)

        redisRepository.SaveValue(hashKey, userJson)
    }

}
