
package be.fenego.android_spotshop.models.shoppingBasketModels;

import java.util.List;

@SuppressWarnings("unused")
public class ElementList {

    private List<Element> elements = null;
    private String type;
    private String name;

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
