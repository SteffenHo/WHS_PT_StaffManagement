package de.PT.personal;

import de.PT.interfaces.Size;

import java.util.Date;

public class Manager extends AbstractEmployee {

    private double bonus;
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public double getBonus() {
        return bonus;
    }

    public Manager(String name, double salary, Date dateOfEmployment, int id, double bonus) {
        super(name, salary, dateOfEmployment, id);
        this.bonus = bonus;
    }

    /**
     * Get the max size the Managers dress is available. Manager have XL Employees L
     * @return
     */
    @Override
    public Size maxAvailableSize() {
        return Size.L;
    }

    /**
     * Equal if all properties of manager and abstractEmployee are the same.
     * @param testManager person to compare with
     * @return true if equal
     */
    @Override
    public boolean equals(Object testManager) {
        if(this == testManager){
            return true;
        }
        if( ! (testManager instanceof  Manager)){
            return false;
        }

        if(!(super.equals(testManager))){
            return  false;
        }
        Manager manager = (Manager) testManager;
        return Double.compare(manager.getBonus(), getBonus()) == 0;
    }

    /**
     * Returns a string wit all properties of manager and abstractEmployee
     * @return String
     */
    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus +
                super.toString() +
                '}';
    }
}
