import models.Usuario;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.db.jpa.JPA;
public class Global extends GlobalSettings {

    private static GenericDAO dao = new GenericDAOImpl();

    @Override
    public void onStart(Application app) {
        Logger.info("Aplicação inicializada...");

        JPA.withTransaction(new play.libs.F.Callback0() {
            @Override
            public void invoke() throws Throwable {
                Usuario user = new Usuario("leticia", "leticia@hotmail.com", "leticia");
                dao.persist(user);
                dao.flush();
            }
        });
    }

    @Override
    public void onStop(Application app) {
    }
}