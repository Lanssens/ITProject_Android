package be.fenego.android_spotshop.models;

import java.io.Serializable;

/**
 * Created by Nick on 23/01/2017.
 */
@SuppressWarnings("ALL")
public class ShoppingBasketElement implements Serializable {

    @SuppressWarnings("unused")
    private String sku;
    @SuppressWarnings("unused")
    private Quantity quantity;
    @SuppressWarnings("unused")
    private String senderName;
    @SuppressWarnings("unused")
    private String senderEmail;
    @SuppressWarnings("unused")
    private String recipientName;
    @SuppressWarnings("unused")
    private String recipientEmail;
    @SuppressWarnings("unused")
    private String greetingMessage;

    @SuppressWarnings("unused")
    public ShoppingBasketElement(String sku, Quantity quantity){
        this.sku = sku;
        this.quantity = quantity;
    }

    @SuppressWarnings("unused")
    public String getSku() {
        return sku;
    }

    @SuppressWarnings("unused")
    public void setSku(String sku) {
        this.sku = sku;
    }

    @SuppressWarnings("unused")
    public Quantity getQuantity() {
        return quantity;
    }

    @SuppressWarnings("unused")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @SuppressWarnings("unused")
    public String getSenderName() {
        return senderName;
    }

    @SuppressWarnings("unused")
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @SuppressWarnings("unused")
    public String getSenderEmail() {
        return senderEmail;
    }

    @SuppressWarnings("unused")
    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    @SuppressWarnings("unused")
    public String getRecipientName() {
        return recipientName;
    }

    @SuppressWarnings("unused")
    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    @SuppressWarnings("unused")
    public String getRecipientEmail() {
        return recipientEmail;
    }

    @SuppressWarnings("unused")
    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    @SuppressWarnings("unused")
    public String getGreetingMessage() {
        return greetingMessage;
    }

    @SuppressWarnings("unused")
    public void setGreetingMessage(String greetingMessage) {
        this.greetingMessage = greetingMessage;
    }
}
