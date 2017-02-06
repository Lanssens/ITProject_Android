package be.fenego.android_spotshop.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 23/01/2017.
 */


@SuppressWarnings("ALL")
public class ShoppingBasketElementList implements Serializable {

    @SuppressWarnings("unused")
    private List<ShoppingBasketElement> elements = null;

    @SuppressWarnings("unused")
    public ShoppingBasketElementList(ArrayList<ShoppingBasketElement> shoppingBasketElementArrayList){
        this.elements = shoppingBasketElementArrayList;
    }

    @SuppressWarnings("unused")
    public List<ShoppingBasketElement> getElements() {
        return elements;
    }

    @SuppressWarnings("unused")
    public void setElements(List<ShoppingBasketElement> elements) {
        this.elements = elements;
    }
}
