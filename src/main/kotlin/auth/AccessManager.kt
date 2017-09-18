package auth

import io.javalin.Context
import io.javalin.Handler
import io.javalin.security.Role

/**
 * Created by johannesC on 2017/09/18.
 */
object AccessManager {

    fun manage(handler: Handler, ctx: Context, permittedRoles: MutableList<Role>) {
        when {
            permittedRoles.contains(AuthRoles.AuthRoles.ANYONE) -> handler.handle(ctx)
            ctx.userRoles.any { it in permittedRoles } -> handler.handle(ctx)
            else -> ctx.status(401).json("Unauthorised").header("WWW-Authenticate", "Basic")

        }
    }

    val Context.userRoles: List<AuthRoles.AuthRoles>
        get() = this.basicAuthCredentials()?.let {
            (username, password) ->
            AuthRoles.currentUserRoles()[Pair(username, password)] ?: listOf()
        } ?: listOf()
}