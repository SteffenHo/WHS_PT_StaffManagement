package de.PT.utils;

import de.PT.personal.Manager;

import java.util.Comparator;

/**
 * A comparator implementation for manager
 */
public class ManagerComparator implements Comparator<Manager> {
    /**
     * Compare two manager by bonus
     * @param o1 manager
     * @param o2 manager
     * @return 1 if o1 has bigger bonus then o1, -1 if o2 has a bigger bonus and 0 if they have the same bonus
     */
    @Override
    public int compare(Manager o1, Manager o2) {
        if (o1.getBonus() > o2.getBonus()) {
            return 1;
        } else if (o1.getBonus() < o2.getBonus()) {
            return -1;
        }
        return 0;
    }
}
