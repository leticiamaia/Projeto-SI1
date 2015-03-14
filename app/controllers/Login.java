package controllers;

import models.User;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;

import static play.data.Form.form;

/**
 * Created by Leticia on 3/14/2015.
 */
public class Login extends Controller {

    private static GenericDAO dao = new GenericDAOImpl();
    static Form<User> loginForm = form(User.class).bindFromRequest();

    @Transactional
    public static Result login() {
        if (session().get("user") != null) {
            return redirect(routes.Application.index());
        }
        return ok(login.render(loginForm));
    }

    public static Result authenticate() {
        User user = loginForm.bindFromRequest().get();
        System.out.println(user.email + user.password);

        if(!(user.password).equals("a")) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("email", user.email);
            return redirect(
                    routes.Application.index()
            );
        }
        //return ok(login.render(loginForm));
    }

}
