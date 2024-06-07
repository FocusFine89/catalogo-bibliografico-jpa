package NikitaIvanov;

import NikitaIvanov.dao.CatalogDAO;
import NikitaIvanov.dao.UtenteDAO;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker();
        CatalogDAO cd = new CatalogDAO(em);
        UtenteDAO ud = new UtenteDAO(em);

        //Generazione utenti e salvataggio nel DB
       /* Utente utente1 = new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.now().minusYears(30));
        Utente utente2 = new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.now().minusYears(15));
        ud.save(utente1);
        ud.save(utente2);*/

        //Generazione libri e riviste e salvataggio nel DB
        /*Libri libro1 = new Libri(faker.code().isbn10(), faker.book().title(), 2024, 125, faker.book().author(), faker.book().genre());
        Libri libro2 = new Libri(faker.code().isbn10(), faker.book().title(), 2020, 134, faker.book().author(), faker.book().genre());

        Riviste rivista1 = new Riviste(faker.code().isbn10(), faker.book().title(), 2015, 58, "SETTIMANALE");
        Riviste rivista2 = new Riviste(faker.code().isbn10(), faker.book().title(), 2022, 75, "MENSILE");
        Riviste rivista3 = new Riviste(faker.code().isbn10(), faker.book().title(), 2024, 58, "SEMESTRALE");
        cd.save(libro1);
        cd.save(libro2);
        cd.save(rivista1);
        cd.save(rivista2);
        cd.save(rivista3);*/


        System.out.println(ud.findById(1));


    }
}
