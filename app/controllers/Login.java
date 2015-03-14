package controllers;

import models.Usuario;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.login;

import java.util.LinkedList;
import java.util.List;

import static play.data.Form.form;

/**
 * Created by Leticia on 3/14/2015.
 */
public class Login extends Controller {

    private static GenericDAO dao = new GenericDAOImpl();
    static Form<Usuario> loginForm = form(Usuario.class).bindFromRequest();

    @Transactional
    public static Result login() {
        if (session().get("email") != null) {
            return redirect(routes.Application.index());
        }
        return ok(login.render(loginForm));
    }

    @Transactional
    public static Result authenticate() {
        Usuario usuarioLogin = loginForm.bindFromRequest().get();

        //List<Usuario> usuarios = dao.findAllByClassName("Usuario");
        List<Usuario> usuarios = new LinkedList<Usuario>();

        for (Usuario usuario : usuarios) {
            if ((usuario.validate(usuarioLogin))) {
                session().clear();
                session("email", usuario.getEmail());
                //session("userId", user.getId());
                return redirect(
                        routes.Application.index()
                );
            }
        }
        return badRequest(login.render(loginForm));
    }

}
