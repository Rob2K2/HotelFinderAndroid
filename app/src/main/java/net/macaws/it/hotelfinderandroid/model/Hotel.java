package net.macaws.it.hotelfinderandroid.model;

import java.io.Serializable;

/**
 * Created by Rob on 19/10/2016.
 */

public class Hotel implements Serializable {

    private int hotelId;
    private String name;
    private String distance;
    private String urlThumb;
    private String urlImage;
    private String web;
    private String phone;
    private String address;
    private String summary;
    private String rooms;
    private String single;
    private String doble;
    private String triple;
    private String familiar;
    private String matrimonial;
    private String city;
    private double latitude;
    private double longitude;

    public Hotel() {
        hotelId = 0;
        name = "";
        distance="";
        urlThumb="";
        urlImage="";
        web="";
        phone="";
        address="";
        summary="";
        rooms="";
        single="";
        doble="";
        triple="";
        familiar="";
        matrimonial="";
        city="";
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getUrlThumb() {
        return urlThumb;
    }

    public void setUrlThumb(String urlThumb) {
        this.urlThumb = urlThumb;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getTriple() {
        return triple;
    }

    public void setTriple(String triple) {
        this.triple = triple;
    }

    public String getFamiliar() {
        return familiar;
    }

    public void setFamiliar(String familiar) {
        this.familiar = familiar;
    }

    public String getMatrimonial() {
        return matrimonial;
    }

    public void setMatrimonial(String matrimonial) {
        this.matrimonial = matrimonial;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDoble() {
        return doble;
    }

    public void setDoble(String doble) {
        this.doble = doble;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
