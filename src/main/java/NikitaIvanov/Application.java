package NikitaIvanov;

import NikitaIvanov.dao.CatalogDAO;
import NikitaIvanov.dao.PrestitoDAO;
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
        PrestitoDAO pd = new PrestitoDAO(em);

        //Generazione utenti e salvataggio nel DB
       /* Utente utente1 = new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.now().minusYears(30));
        Utente utente2 = new Utente(faker.name().firstName(), faker.name().lastName(), LocalDate.now().minusYears(15));
        ud.save(utente1);
        ud.save(utente2);

        //Generazione libri e riviste e salvataggio nel DB
        Libri libro1 = new Libri(faker.code().isbn10(), faker.book().title(), 2024, 125, faker.book().author(), faker.book().genre());
        Libri libro2 = new Libri(faker.code().isbn10(), faker.book().title(), 2020, 134, faker.book().author(), faker.book().genre());

        Riviste rivista1 = new Riviste(faker.code().isbn10(), faker.book().title(), 2015, 58, "SETTIMANALE");
        Riviste rivista2 = new Riviste(faker.code().isbn10(), faker.book().title(), 2022, 75, "MENSILE");
        Riviste rivista3 = new Riviste(faker.code().isbn10(), faker.book().title(), 2024, 58, "SEMESTRALE");
        cd.save(libro1);
        cd.save(libro2);
        cd.save(rivista1);
        cd.save(rivista2);
        cd.save(rivista3);*/

        //Generazione prestiti e salvataggio nel DB
//        Catalogo catalogoFromDb = cd.findByIsbn("0992199344");
//        Catalogo catalogoFromDb2 = cd.findByIsbn("007457308X");
//        Utente utenteFromDb2 = ud.findById(2);
//        Utente utenteFromDb = ud.findById(1);
//        Prestito prestito1 = new Prestito(LocalDate.now().minusDays(10), LocalDate.now().plusDays(30), LocalDate.now().plusDays(30), catalogoFromDb, utenteFromDb);
//        Prestito prestito2 = new Prestito(LocalDate.now(), LocalDate.now().plusDays(30), null, catalogoFromDb2, utenteFromDb2);
//        pd.save(prestito1);
//        pd.save(prestito2);

        //Attualmente in prestito
        System.out.println(pd.attualmenteInPrestito(2));
        System.out.println(" ");
        System.out.println("-----------------------------------");
        //Prestiti scaduti e non Restituiti
        System.out.println(" ");
        System.out.println(pd.prestitiNonRestituiti());

    }
}
