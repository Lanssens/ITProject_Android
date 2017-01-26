package be.fenego.android_spotshop.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 23/01/2017.
 */

@SuppressWarnings("ALL")
public class ShoppingBasketElementList {
    private List<ShoppingBasketElement> elements = null;

    public ShoppingBasketElementList(ArrayList<ShoppingBasketElement> shoppingBasketElementArrayList){
        this.elements = shoppingBasketElementArrayList;
    }

    public List<ShoppingBasketElement> getElements() {
        return elements;
    }

    public void setElements(List<ShoppingBasketElement> elements) {
        this.elements = elements;
    }
}
