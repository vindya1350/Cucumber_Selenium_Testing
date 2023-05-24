package com.jupitertoys.testData;

public class PaymentDetails {
    private String cardNumber;
    private String cardType;
    private String nameOnCard;
    private String expiryDate;
    private String cvv;

    public PaymentDetails(){
        this.cardNumber = "1234567891234567";
        this.cardType = "Mastercard";
        this.nameOnCard ="John Doe";
        this.expiryDate="05/06";
        this.cvv="123";
    }

    public String getCardNumber() {
        return cardNumber;
    }
   
    public String getCardType() {
        return cardType;
    }
    
    public String getNameOnCard() {
        return nameOnCard;
    }
   
    public String getExpiryDate() {
        return expiryDate;
    }
    
    public String getCvv() {
        return cvv;
    }
}
