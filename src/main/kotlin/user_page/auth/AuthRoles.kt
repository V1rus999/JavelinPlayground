package user_page.auth

import io.javalin.security.Role

/**
 * Created by johannesC on 2017/09/18.
 */
class AuthRoles {

    enum class AuthRoles : Role { ANYONE, READ, WRITE }

    companion object {
        fun currentUserRoles() = hashMapOf(
                Pair("Bob", "password") to listOf(AuthRoles.ANYONE),
                Pair("Alice", "password1@") to listOf(AuthRoles.ANYONE, AuthRoles.READ),
                Pair("James", "password123") to listOf()
        )
    }

}
