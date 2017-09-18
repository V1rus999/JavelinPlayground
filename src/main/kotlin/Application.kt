import controllers.UserController
import io.javalin.ApiBuilder.get
import io.javalin.ApiBuilder.path
import io.javalin.Javalin

/**
 * Created by johannesC on 2017/09/18.
 */
fun main(args: Array<String>) {
    val app = Javalin.create().start()

    app.routes {
        path("users") {
            get(UserController::getAllUserIds)
        }
    }

}