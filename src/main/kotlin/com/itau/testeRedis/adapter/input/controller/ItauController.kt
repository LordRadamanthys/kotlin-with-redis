package com.itau.testeRedis.adapter.input.controller

import com.itau.testeRedis.adapter.output.RedisRepository
import com.itau.testeRedis.application.domain.UserDomain
import com.itau.testeRedis.application.service.ItauService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ItauController {

    @GetMapping("v1/teste")
    @ResponseBody
    fun GetRedis(
        @RequestParam name: String,
        @RequestParam lastName: String
    ): UserDomain {
        val redisClient = RedisRepository()

        val service = ItauService(redisClient)

        return service.GetUserService(name, lastName)
    }


    @PostMapping("v1/teste")
    @ResponseBody
    fun SaveRedis(
        @RequestBody user: UserDomain,
    ) {
        val redisClient = RedisRepository()

        val service = ItauService(redisClient)

        return service.SaveUser(user)
    }
}