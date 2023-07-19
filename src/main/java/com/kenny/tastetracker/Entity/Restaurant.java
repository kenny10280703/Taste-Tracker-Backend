package com.kenny.tastetracker.Entity;
import jakarta.persistence.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "rating")
    private double rating;
    @ManyToOne
    @JoinColumn(name = "cuisine")
    private Cuisine cuisine;
    @Column(name = "website_link")
    private String websiteLink;
    @Column(name = "menu_link")
    private String menuLink;

    @Column(name = "average_cost_of_a_dish")
    private double averageCostOfADish;

    @Transient
    private double distanceFromUser;

    private Boolean distanceCalculated = false;

    @Transient
    private double walkingTime;

    @Transient
    private static final double EARTH_RADIUS = 6371.0;

    @ManyToMany
    @JoinTable(
            name = "restaurant_operation_hour",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "operation_hour_id")
    )
    private List<OperationHour> operationHours;

    @OneToMany(mappedBy = "restaurant")
    private List<Image> imagesLink;


    public Restaurant() {
    }

    public Restaurant(Long id, String name, String address, String phoneNumber, double latitude, double longitude, double rating, Cuisine cuisine, String websiteLink, String menuLink) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
        this.cuisine = cuisine;
        this.websiteLink = websiteLink;
        this.menuLink = menuLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getMenuLink() {
        return menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
    }

    public double getAverageCostOfADish() { return getAverageCostOfADish(); }

    public List<String> getOperationHours() {
        List<String> stringOperationHour = new ArrayList<>();
        for (OperationHour o : this.operationHours) {
            String s = o.toString();
            stringOperationHour.add(s);
        }
        return stringOperationHour;
    }

    public double getDistanceFromUser() {
        return distanceFromUser;
    }

    public void setDistanceFromUser(double userLatitude, double userLongitude) {
        double userLatRad = Math.toRadians(userLatitude);
        double userLonRad = Math.toRadians(userLongitude);
        double restaurantLatRad = Math.toRadians(this.latitude);
        double restaurantLonRad = Math.toRadians(this.longitude);
        double deltaLat = userLatRad - restaurantLatRad;
        double deltaLon = userLonRad - restaurantLonRad;
        double a = Math.pow(Math.sin(deltaLat / 2), 2)
                + Math.cos(userLatRad) * Math.cos(restaurantLatRad)
                * Math.pow(Math.sin(deltaLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS * c;
        this.distanceFromUser =  distance * 1000;
        this.distanceCalculated = true;
    }

    public void setWalkingTime(double userLatitude, double userLongitude) {
        if (!distanceCalculated) {
            throw new RuntimeException("You must invoke the setDisntanceFromUser method before setting walking time.");
        } else {

        }
    }

    public double getWalkingTime() {
        return this.walkingTime;
    }

    public void setImagesLink() {

    }

    public List<String> getImageLink() {
        List<String> links = new ArrayList<>();
        for (Image i : this.imagesLink) {
            links.add(i.getImageLink());
        }
        return links;
    }
}
