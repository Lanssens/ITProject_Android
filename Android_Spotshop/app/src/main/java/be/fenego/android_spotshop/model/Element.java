package be.fenego.android_spotshop.model;

import android.content.res.Resources;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Nick on 23/12/2016.
 */

public class Element{
    private String type;
    private List<Attribute> attributes = null;
    private String uri;
    private String title;
    private String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getAttibuteValueByName(String name){
        Object o = null;
        for (Attribute attribute : attributes)
        {
            if (attribute.getName().equals(name)){
                o = attribute.getValue();
            }
        }
        return o;
    }
}
