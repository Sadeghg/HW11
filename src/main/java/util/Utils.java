package util;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

@Getter
public class Utils {

    private static EntityManagerFactory factoryA  = Persistence.createEntityManagerFactory("persistence-unit-a");
    private static EntityManagerFactory factoryB  = Persistence.createEntityManagerFactory("persistence-unit-b");


    public static Scanner scanner = new Scanner(System.in);


    public static EntityManager managerA = factoryA.createEntityManager();


    public static EntityManager managerB = factoryB.createEntityManager();

    public static int checkIntInput(int start, int end) {
        boolean valid = false;
        int input = 0;
        do {
            try {
                input = Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                continue;
            }
            if (end >= input && start <= input) {
                valid = true;
            }
        } while (!valid);
        return input;
    }

}
