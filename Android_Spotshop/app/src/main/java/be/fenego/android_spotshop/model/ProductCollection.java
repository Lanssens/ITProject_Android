package be.fenego.android_spotshop.model;

import java.util.List;

/**
 * Created by Nick on 23/12/2016.
 */

public class ProductCollection {
    private String pageable;
    private Integer total;
    private Integer offset;
    private Integer amount;
    private List<Element> elements = null;
    private String type;
    private String name;

    public String getPageable() {
        return pageable;
    }

    public void setPageable(String pageable) {
        this.pageable = pageable;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

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
