import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.db.jpa.JPA;

/**
 * Created by Leticia on 3/14/2015.
 */
public class GlobalTeste extends GlobalSettings {
 /*       private static GenericDAO dao = new GenericDAOImpl();

        @Override
        public void onStart(Application app) {
            Logger.info("Aplicação inicializada...");

            JPA.withTransaction(new play.libs.F.Callback0() {
                @Override
                public void invoke() throws Throwable {
                    Livro livro = new Livro();
                    livro.setNome("Meu livro");

                    Autor novoAutor = new Autor();
                    novoAutor.setNome("Meu autor");

                    livro.getAutores().add(novoAutor);
                    novoAutor.getLivros().add(livro);

                    dao.persist(novoAutor);
                    dao.merge(livro);
                    dao.flush();
                }
            };
        }*/
}
