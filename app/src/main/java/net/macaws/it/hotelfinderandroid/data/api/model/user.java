package net.macaws.it.hotelfinderandroid.data.api.model;

/**
 * Created by Rob on 12/02/2017.
 */

public class User {

    private String id;
    private String name;
    private String address;
    private String gender;
    private String token;
    private String email;

    public User(String id, String name, String address, String gender, String token) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
