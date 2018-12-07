package de.PT.interfaces;


/**
 * Manage the hair color
 */
public interface HairColorChangeable {

    /**
     * Get the hair color
     * @return String color
     */
    String getHairColor();

    /**
     * Set the color of the hair
     * @param color String
     * @return String new color
     */
    String setHairColor(String color);
}
