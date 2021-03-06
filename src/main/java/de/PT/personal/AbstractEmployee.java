package de.PT.personal;

import de.PT.interfaces.DressSizeChangeable;
import de.PT.interfaces.Size;

import java.util.Date;
import java.util.Objects;

public abstract class AbstractEmployee implements Comparable<AbstractEmployee>, DressSizeChangeable {

    private String name;
    private Double salary;
    private Date dateOfEmployment;
    private int id;
    private Size dressSize;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

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

    /**
     * Function to change the salary of a person
     * @param percentage The percentage the salary should increase. Negative values will decrement the salary.
     * @return The new salary
     */
    public double updateSalary(double percentage) {
        double newSalary = getSalary() * ((percentage / 100) + 1);
        setSalary(newSalary);
        return  newSalary;
    }

    /**
     * Equals if all properties are the same
     * @param testStaff Person to compare with
     * @return true if equal
     */
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

    /**
     * Compares the persons by salary
     * @param e2 The person to be compared with
     * @return Int value for Comparable interface
     */
    @Override
    public int compareTo(AbstractEmployee e2) {
        return this.salary.compareTo(e2.getSalary());
    }

    /**
     * Get the size of the Employees dress
     * @return Size
     */
    @Override
    public Size getSize() {
        return dressSize;
    }

    /**
     * Set the size of Employees dress
     * @param clothingSize
     * @return
     */
    @Override
    public Size setSize(Size clothingSize) {
       return this.dressSize = clothingSize;
    }


    /**
     * Returns a string with all properties of abstract employee
     * @return String
     */
    @Override
    public String toString() {
        return "AbstractEmployee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", dateOfEmployment=" + dateOfEmployment +
                ", id=" + id +
                '}';
    }

    public Object[] toObjectArray(){
        Object[] obj = {getId(), getName(), getSalary(), getDateOfEmployment(), getSize(), false, 0};
        return  obj;
    }
}
