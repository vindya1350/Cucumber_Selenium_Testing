package com.jupitertoys.testData;

public class FeedbackContactDetails {
    private String name;
    private String email;
    private String telephoneNo;
    private String type;
    private String message;

    public FeedbackContactDetails(String name, String email, String telephoneNo, String type, String message) {
        this.name = name;
        this.email = email;
        this.telephoneNo = telephoneNo;
        this.type = type;
        this.message = message;
    }

    // getters and setters for the fields

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
