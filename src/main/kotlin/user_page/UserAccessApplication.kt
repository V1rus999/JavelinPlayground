package user_page

import io.javalin.ApiBuilder
import io.javalin.Javalin
import io.javalin.security.Role
import user_page.auth.AccessManager
import user_page.auth.AuthRoles
import user_page.controllers.UserController
import JavelinApplication

/**
 * Created by johannesC on 2017/10/10.
 */
class UserAccessApplication : JavelinApplication {

    private val app = Javalin.create()
            .port(7000)
            .apply { accessManager(AccessManager::manage) }

    init {
        app.routes {
            ApiBuilder.get("/") { ctx -> ctx.redirect("users") }
            ApiBuilder.path("users") {
                ApiBuilder.get(UserController::getUserIds, Role.roles(AuthRoles.AuthRoles.ANYONE))

                ApiBuilder.path(":user-id") {
                    ApiBuilder.get(UserController::getUser, Role.roles(AuthRoles.AuthRoles.READ))
                }
            }
        }
    }

    override fun start() {
        app.start()
    }

    override fun stop() {
        app.stop()
    }
}