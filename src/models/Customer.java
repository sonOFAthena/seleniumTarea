
package models;

import PageObjects.PageCustomer;
import org.openqa.selenium.By;


public class Customer {
    private String name; 
    private String gender; 
    private String dateOfBirth; 
    private String address; 
    private String city; 
    private String state; 
    private String pin; 
    private String mobileNumber; 
    private String email; 
    private String pass; 
    private String customerIdCode;
    
    public Customer(){
        
    }
    
    public Customer(String name, String gender, String dateOfBirth, String address, String city, String state, String pin, String mobileNumber, String email, String pass) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pin = pin;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.pass = pass;
    }
 
    public void setCustomerIdCode(String id)
    {
        customerIdCode = id;
    }

    public String getCustomerIdCode() {
        return customerIdCode;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
