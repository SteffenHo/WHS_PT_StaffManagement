package de.PT.personal;

import java.util.Date;
import java.util.Objects;

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

}
