package de.PT.personalAdministration;
import de.PT.personal.AbstractEmployee;
import java.util.ArrayList;
import java.util.Collections;

public class Management {
    private ArrayList<AbstractEmployee> personalList;

    public ArrayList<AbstractEmployee> getPersonalList() {
        return personalList;
    }
    public void setPersonalList(ArrayList<AbstractEmployee> personalList) {
        this.personalList = personalList;
    }

    public Management(){
        personalList = new ArrayList<AbstractEmployee>();
    }
    /**
     * Adds a person to the personal list.
     * @param e1 abstract employee
     * @return true -> added, false -> found duplicate
     */
    public boolean add(AbstractEmployee e1){
        boolean hasSame = false;
        for( AbstractEmployee employee : personalList){
            if(employee.equals(e1)){
                hasSame = true;
            }
        }
        if(!hasSame){
            personalList.add(e1);
            return true;
        }
        return false;
    }

    /**
     * Get the person with the min salary
     * @return Returns an abstract employee, null if list is empty
     */
    public AbstractEmployee min(){
        if(personalList.size() == 0){
            return  null;
        }
        Collections.sort(personalList);
        return personalList.get(0);
    }

    /**
     * Get the person with the max salary
     * @return Returns an abstract employee, null if list is empty
     */
    public AbstractEmployee max(){
        int length = personalList.size();
        if(length == 0){
            return  null;
        }
        Collections.sort(personalList);
        return personalList.get(length - 1);
    }


    /**
     * returns the string of all personals
     * @return
     */
    @Override
    public String toString(){
        StringBuilder st = new StringBuilder();
        for(AbstractEmployee employee : personalList){

            st.append(employee.toString() + "\n");
        }
        return  st.toString();
    }
}
