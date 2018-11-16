package de.PT.personal;

import java.util.Date;
import java.util.Objects;

public abstract class AbstractEmployee {

    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    private double salary;
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }

    private Date dateOfEmployment;
    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    private int id;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public AbstractEmployee(String name, double salary, Date dateOfEmployment, int id){
        setName(name);
        setSalary(salary);
        setDateOfEmployment(dateOfEmployment);
        setId(id);
    }

    public double updateSalary(double percentage) {
        double newSalary = getSalary() * ((percentage / 100) + 1);
        setSalary(newSalary);
        return  newSalary;
    }

    @Override
    public boolean equals(Object testStaff) {
        if (this == testStaff) return true;
        if (!(testStaff instanceof AbstractEmployee)) return false;
        AbstractEmployee that = (AbstractEmployee) testStaff;
        return Double.compare(that.getSalary(), getSalary()) == 0 &&
                getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDateOfEmployment(), that.getDateOfEmployment());
    }

}
