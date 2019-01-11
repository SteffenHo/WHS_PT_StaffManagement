package de.PT.interfaces;

import de.PT.Frontend.CustomDialog;

public interface Closeable {
    public void setCloseOperation(CustomDialog parent);

    public void close();
}
