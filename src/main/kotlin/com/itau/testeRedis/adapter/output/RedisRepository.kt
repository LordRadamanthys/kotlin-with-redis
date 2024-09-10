package com.itau.testeRedis.adapter.output

import com.itau.testeRedis.application.output.RedisRepositoryInterface
import org.springframework.stereotype.Repository
import redis.clients.jedis.Jedis

@Repository
class RedisRepository():RedisRepositoryInterface {
    final var endpointRedis = "localhost"
    final var portRedis = 6379

    val jedis = Jedis(endpointRedis, portRedis)


    override fun SaveValue(key: String, value: String) {

        jedis.set(key, value)
    }


    override fun GetValue(key: String): String {
        val value = jedis.get(key) ?: throw Exception("Not found")
        return value
    }
}