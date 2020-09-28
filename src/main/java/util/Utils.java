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


}
