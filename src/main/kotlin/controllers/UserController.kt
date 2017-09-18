package controllers

import io.javalin.Context
import java.util.*

/**
 * Created by johannesC on 2017/09/18.
 */
object UserController {

    private data class UserObject(val username: String, val email: String)

    private val users = hashMapOf(
            randomId() to UserObject("Bob", "Bob@gmail.com"),
            randomId() to UserObject("Alice", "Aliceb@gmail.com"),
            randomId() to UserObject("James", "James@gmail.com")
    )

    fun getAllUserIds(ctx: Context) {
        ctx.json(users)
    }

    private fun randomId() = UUID.randomUUID().toString()
}