package de.PT.interfaces;

/**
 * Manage the dress size
 */
public interface DressSizeChangeable {
    /**
     * max Site of all dresses
     */
    Size maxSize = Size.L;

    /**
     * Get the dress size.
     * @return Size
     */
    Size getSize();

    /**
     * Set the size of the dress
     * @param clothingSize Size
     * @return Size the new size
     */
    Size setSize(Size clothingSize);

    /**
     * Get the max size a dress could have. Default is L.
     * @return Size max dress Size
     */
    default Size maxAvailableSize(){
        return maxSize;
    };

}
