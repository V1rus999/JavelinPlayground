package user_page.controllers

import io.javalin.Context

/**
 * Created by johannesC on 2017/09/18.
 */
object UserController {

    private data class UserObject(val username: String, val email: String)

    private val users = hashMapOf(
            "1" to UserObject("Bob", "Bob@gmail.com"),
            "2" to UserObject("Alice", "Aliceb@gmail.com"),
            "3" to UserObject("James", "James@gmail.com")
    )

    fun getUserIds(ctx: Context) {
        ctx.json(users.keys)
    }

    fun getUser(ctx: Context) {
        val user = users[ctx.param(":user-id")]
        if (user == null) {
            ctx.status(404).json("Not found ${ctx.param(":user-id")}")
        } else {
            ctx.json(user)
        }
    }
}