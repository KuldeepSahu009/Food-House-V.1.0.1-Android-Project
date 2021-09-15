package com.pvt.foodhouse;

public class UserHandlerClass {
    /**
     * Design & Developed by Kuldeep Sahu on 05/05/2021.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    String Name, Email, Contact, Password;

    public UserHandlerClass(String name) {

    }

    public UserHandlerClass(String name, String email, String contact, String password) {
        Name = name;
        Email = email;
        Contact = contact;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
