package NikitaIvanov;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo");

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Faker faker = new Faker();

    }
}
