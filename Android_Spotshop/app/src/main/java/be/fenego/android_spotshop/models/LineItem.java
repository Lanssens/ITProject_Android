
package be.fenego.android_spotshop.models;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unused")
public class LineItem implements Serializable{

    @SuppressWarnings("unused")
    private String title;
    @SuppressWarnings("unused")
    private String type;
    @SuppressWarnings("unused")
    private List<Attribute> attributes = null;
    @SuppressWarnings("unused")
    private String uri;

    @SuppressWarnings("unused")
    public String getTitle() {
        return title;
    }

    @SuppressWarnings("unused")
    public void setTitle(String title) {
        this.title = title;
    }

    @SuppressWarnings("unused")
    public String getType() {
        return type;
    }

    @SuppressWarnings("unused")
    public void setType(String type) {
        this.type = type;
    }

    @SuppressWarnings("unused")
    public List<Attribute> getAttributes() {
        return attributes;
    }

    @SuppressWarnings("unused")
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @SuppressWarnings("unused")
    public String getUri() {
        return uri;
    }

    @SuppressWarnings("unused")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @SuppressWarnings("unused")
    public Object getAttributeValueByName(String name){
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
