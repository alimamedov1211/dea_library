package com.model;

public class Users {

    private Integer id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String mail;
    private String address;
    
    public Users(){
        
    }
    
    public Users(Integer id, String name, String surname, String username, String password, String mail, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", username=" + username + ", password=" + password + ", mail=" + mail + ", address=" + address + '}';
    }

   

}
