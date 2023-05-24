package com.jupitertoys.testData;

public class DeliveryContactDetails {
    private String firstname;
    private String lastName;
    private String email;
    private String phoneNo;
    private String addressline1;
    private String suburb;
    private String state;
    private String postCode;

    public DeliveryContactDetails(String firstname,String lastName,String email, String phoneNo, String addressline1,String suburb,String state, String postCode){
        this.firstname=firstname;
        this.lastName=lastName;
        this.email=email;
        this.phoneNo=phoneNo;
        this.addressline1=addressline1;
        this.suburb=suburb;
        this.state=state;
        this.postCode=postCode;
    }
    
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public String getAddressline1() {
        return addressline1;
    }
    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }
    public String getSuburb() {
        return suburb;
    }
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
}
