package de.PT.personal;

import java.util.Date;
import java.util.Objects;

public class Employee extends AbstractEmployee {

    public Employee(String name, double salary, Date dateOfEmployment, int id) {
        super(name, salary, dateOfEmployment, id);
    }

    /**
     * Equal if all properties of abstractEmployee and employee are the same
     * @param testEmployee Person to compare with
     * @return true if same
     */
    @Override
    public boolean equals(Object testEmployee) {
        if (this == testEmployee) return true;
        if (!(testEmployee instanceof Employee)) return false;
        return  super.equals(testEmployee);
    }

    /**
     * Return a string with all properties of employee and abstractEmployee
     * @return
     */
    @Override
    public String toString() {
        return "Employee{" + super.toString() +"}";
    }
}
