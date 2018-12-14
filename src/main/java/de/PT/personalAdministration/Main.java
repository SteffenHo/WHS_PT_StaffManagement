package de.PT.personalAdministration;

import de.PT.personal.AbstractEmployee;
import de.PT.personal.Employee;
import de.PT.personal.Manager;
import de.PT.utils.Bubblesort;
import de.PT.utils.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Praktikum 3 Aufgabe 2");

        Integer[] l1 = {1,4,6,8,90,454,45,346,78,7,7,898};
        Integer[] lb = Bubblesort.sort(l1);
        Double[] l2 ={1.4545,234.6,345.6575,7.4546,0.6235,7866.7,6.9};
        Double[] lc = Bubblesort.sort(l2);
        String[] l3 = {"öngvöenae", "öisvnsna", "a", "bb", "c"};
        String[] ld = Bubblesort.sort(l3);

        Employee e1 = new Employee("Albert", 2000, new Date(), 1);
        Employee e2 = new Employee("Berta", 2400, new Date(), 2);
        Employee e3 = new Employee("Conny", 1400, new Date(), 3);

        Manager m1 = new Manager("Doris", 3000, new Date(), 4, 400);
        Manager m2 = new Manager("Emanuel", 7000, new Date(), 5, 800);
        Manager m3 = new Manager("Conny", 1400, new Date(), 3, 500);

        Management man = new Management();
        man.min();
        man.max();
        man.add(e1);
        System.out.println(man.min());
        System.out.println(man.max());
        System.out.println( man.add(e1));
        man.add(e2);
        man.add(e3);
        man.add(m1);
        man.add(m2);
        man.add(m3);
        System.out.println("min" + man.min());
        System.out.println("mx" + man.max());
        System.out.println("\n\n\n");
        System.out.println(man);

        System.out.println(man.remove(e1));
        System.out.println(man.remove(e1));
        System.out.println(man);

        man.sort();
        System.out.println(man);

        Pair<Manager> p = man.getManagerPair();
        System.out.println(p.toString());
        // tests
        boolean t1 = e1.equals(e2);
        boolean t2 = e2.equals(m1);
        boolean t3 = m3.equals(e3);
        boolean t4 = e3.equals(m3);
        boolean t5 = e1.equals(e1);

        ArrayList<AbstractEmployee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(m1);
        list.add(m2);
        list.add(e3);
        list.add(m3);

        Collections.sort(list);
        int lentgth = list.size();
        for(AbstractEmployee employee : list){

        }

    }
}
