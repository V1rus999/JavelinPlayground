import user_page.auth.AuthRoles
import user_page.controllers.UserController
import io.javalin.ApiBuilder.get
import io.javalin.ApiBuilder.path
import io.javalin.Javalin
import io.javalin.security.Role.roles
import user_page.UserAccessApplication
import user_page.auth.AccessManager

/**
 * Created by johannesC on 2017/09/18.
 */
fun main(args: Array<String>) {
    val userAccess = UserAccessApplication()
    userAccess.start()
}