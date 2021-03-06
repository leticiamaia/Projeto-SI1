package controllers;
import play.*;
import static play.data.Form.*;
import play.data.Form;
import play.mvc.*;
import views.html.index;
import views.html.login;


public class Application extends Controller {

    public static Result index() {
        if (session().get("email") == null) {
            return redirect(routes.Login.login());
        }
        return ok(index.render("Your new application is ready."));
    }
}
