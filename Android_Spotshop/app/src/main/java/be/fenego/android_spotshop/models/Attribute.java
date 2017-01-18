package be.fenego.android_spotshop.models;

import java.io.Serializable;

/**
 * Created by Nick on 20/12/2016.
 */

@SuppressWarnings({"DefaultFileTemplate", "unused"})
public class Attribute implements Serializable {

    @SuppressWarnings("unused")
    private String name;
    @SuppressWarnings("unused")
    private String type;
    @SuppressWarnings("unused")
    private Object value;


// --Commented out by Inspection START (14/01/2017 16:26):
//    public Attribute() {
//    }
// --Commented out by Inspection STOP (14/01/2017 16:26)


    public Attribute(String name, String type, Object value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}