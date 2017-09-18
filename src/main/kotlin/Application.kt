import auth.AuthRoles
import controllers.UserController
import io.javalin.ApiBuilder.get
import io.javalin.ApiBuilder.path
import io.javalin.Javalin
import io.javalin.security.Role.roles

/**
 * Created by johannesC on 2017/09/18.
 */
fun main(args: Array<String>) {
    val app = Javalin.create()
            .apply { accessManager(auth.AccessManager::manage) }
            .start()

    app.routes {
        get("/") {ctx -> ctx.redirect("users") }
        path("users") {
            get(UserController::getUserIds, roles(AuthRoles.AuthRoles.ANYONE))

            path(":user-id") {
                get(UserController::getUser, roles(AuthRoles.AuthRoles.READ))
            }
        }
    }

}