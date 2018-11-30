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
     * @return true = added, false = found duplicate
     */
    public boolean add(AbstractEmployee e1){
        if(!personalList.contains(e1)){
            personalList.add(e1);
            return true;
        }
        return false;
    }

    /**
     * Removes the given person from the list.
     * @param e1 Element to remove.
     * @return true, if person is found and removed. false, if person is not found
     */
    public boolean remove(AbstractEmployee e1){
       return personalList.remove(e1);
    }

    /**
     * Get the person with the min salary
     * @return Returns an abstract employee, null if list is empty
     */
    public AbstractEmployee min(){
        if(personalList.isEmpty()){
            return  null;
        }
        ArrayList<AbstractEmployee> l = sort();
        return l.get(0);
    }

    /**
     * Get the person with the max salary
     * @return Returns an abstract employee, null if list is empty
     */
    public AbstractEmployee max(){
        if(personalList.isEmpty()){
            return  null;
        }
         ArrayList<AbstractEmployee> l = sort();
        return l.get(l.size() - 1);
    }

    public ArrayList<AbstractEmployee> sort(){
        Collections.sort(personalList);
        return  personalList;
    }

    /**
     * returns the string of all personals
     * @return String
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
