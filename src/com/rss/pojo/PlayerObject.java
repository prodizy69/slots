package com.rss.pojo;

import java.sql.Date;

public class PlayerObject
{
    private int id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String contact;
    private String email;
    private String fe;
    private String brand;
    private String product;
    private String language;
    private String country;
    private String ip;
    private String user_agent;
    private String source;
    private String user_type;
    private Date createdAt;
    private Date updatedAt;

    public PlayerObject() {
    }

    public PlayerObject(String username, String password, String first_name, String last_name, String contact, String email, String fe, String brand, String product, String language, String country, String ip, String user_agent, String source, String user_type, Date createdAt, Date updatedAt) {
        this(0,username,password,first_name,last_name,contact,email,fe,brand,product,language,country,ip,user_agent,source,user_type,createdAt,updatedAt);
    }

    public PlayerObject(int id, String username, String password, String first_name, String last_name, String contact, String email, String fe, String brand, String product, String language, String country, String ip, String user_agent, String source, String user_type, Date createdAt, Date updatedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.contact = contact;
        this.email = email;
        this.fe = fe;
        this.brand = brand;
        this.product = product;
        this.language = language;
        this.country = country;
        this.ip = ip;
        this.user_agent = user_agent;
        this.source = source;
        this.user_type = user_type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFe() {
        return fe;
    }

    public void setFe(String fe) {
        this.fe = fe;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public void setUser_agent(String user_agent) {
        this.user_agent = user_agent;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "PlayerObject{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", fe='" + fe + '\'' +
                ", brand='" + brand + '\'' +
                ", product='" + product + '\'' +
                ", language='" + language + '\'' +
                ", country='" + country + '\'' +
                ", ip='" + ip + '\'' +
                ", user_agent='" + user_agent + '\'' +
                ", source='" + source + '\'' +
                ", user_type='" + user_type + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
