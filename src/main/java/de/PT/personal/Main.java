package de.PT.personal;

import java.util.Date;

public class Main {
    public static void main(String[] args){
        System.out.println("Praktikum 3 Aufgabe 2");

        Employee e1 = new Employee("Albert", 2000, new Date(), 1);
        Employee e2 = new Employee("Berta", 2400, new Date(), 2);
        Employee e3 = new Employee("Conny", 1400, new Date(), 3);
        Employee e4 = new Employee("Conny", 1400, new Date(), 3);

        Manager m1 = new Manager("Doris", 3000, new Date(), 4, 400);
        Manager m2 = new Manager("Emanuel", 7000, new Date(), 5, 800);
        Manager m3 = new Manager("Conny", 1400, new Date(), 3, 500);

        boolean t1 = e1.equals(e2);
        boolean t2 = e2.equals(m1);
        boolean t3 = m3.equals(e3);
        boolean t4 = e3.equals(m3);
        boolean t5 = e1.equals(e1);
        boolean t6 = e4.equals(e3);

}
}
