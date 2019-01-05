package de.PT.personalAdministration;
import de.PT.personal.AbstractEmployee;
import de.PT.personal.Manager;
import de.PT.utils.ManagerComparator;
import de.PT.utils.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Management {
    private HashMap<Integer, AbstractEmployee> personalList;

    public HashMap<Integer, AbstractEmployee> getPersonalList() {
        return personalList;
    }

    public Object[][] getPersonalListForTable(){
        Object[][] data = new Object[getPersonalList().values().size()][7]; // = {getPersonalList().values().toArray()};
       System.out.println(getPersonalList().values().toArray());
       int i = 0;
       for(AbstractEmployee e : getPersonalList().values()){
               data[i] = e.toObjectArray();
               i++;
       }
        return data;
    }
    public void setPersonalList(HashMap<Integer, AbstractEmployee>personalList) {
        this.personalList = personalList;
    }

    public Management(){
        personalList = new HashMap<Integer, AbstractEmployee>();
    }
    /**
     * Adds a person to the personal list.
     * @param e1 abstract employee
     * @return true = added, false = found duplicate
     */
    public boolean add(AbstractEmployee e1){
        if(!personalList.keySet().contains(e1.getId())){
            personalList.put(e1.getId(), e1);
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
       AbstractEmployee retVal = personalList.remove(e1.getId());
       return retVal != null;
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
        ArrayList<AbstractEmployee> list =  new ArrayList<>(personalList.values());
        Collections.sort(list);
        return  list;
    }


    /**
     * Get the manager with the smallest bonus and the biggest bonus in a pair
     * @return pair of manager
     */
    public Pair<Manager> getManagerPair(){
        ArrayList<Manager> list = personalList.values().stream().filter(em -> em instanceof Manager).map(e -> (Manager) e).sorted(new ManagerComparator()).collect(Collectors.toCollection(ArrayList::new));


        Pair<Manager>pair = new Pair<>();
        pair.setFirst(list.get(0));
        pair.setSecond(list.get(list.size() -1));
        return pair;
    }
    /**
     * returns the string of all personals
     * @return String
     */
    @Override
    public String toString(){
        StringBuilder st = new StringBuilder();
        for(AbstractEmployee employee : personalList.values()){

            st.append(employee.toString() + "\n");
        }
        return  st.toString();
    }

    public int getNextId(){
        return  999;
    }
}
