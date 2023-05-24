package com.jupitertoys.testData;

public class PurchasedProductDetails {
    private String name;
    private String quantity;
    private String price ;
    private String subTotal ;

    public PurchasedProductDetails(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }
    
    public void setPrice(String price) {
        this.price =price;
    }

    public String getSubtotal() {
        return subTotal;
    }

    public void setSubtotal(String subtotal) {
        this.subTotal= subtotal;
    }  
}
