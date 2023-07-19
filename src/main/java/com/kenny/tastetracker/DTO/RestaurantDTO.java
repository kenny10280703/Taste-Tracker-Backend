package com.kenny.tastetracker.DTO;

import java.util.List;

public class RestaurantDTO {
    Long id;
    String name;
    String address;
    String phoneNumber;
    Double latitude;
    Double longitude;
    Double overallRating;
    String cuisine;
    List<String> operatingHoursOfTheWeek;
    String menuLink;
    String websiteLink;
    Double averageCostOfADish;
    Double distanceFromUser;
    Double approximateWalkingTimeFromUser;
    List<String> imagesLink;

    public RestaurantDTO(Long id, String name, String address, String phoneNumber, Double latitude, Double longitude, Double overallRating, String cuisine, List<String> operatingHoursOfTheWeek, String menuLink, String websiteLink, Double averageCostOfADish, Double distanceFromUser, Double approximateWalkingTimeFromUser, List<String> imagesLink) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.overallRating = overallRating;
        this.cuisine = cuisine;
        this.operatingHoursOfTheWeek = operatingHoursOfTheWeek;
        this.menuLink = menuLink;
        this.websiteLink = websiteLink;
        this.averageCostOfADish = averageCostOfADish;
        this.distanceFromUser = distanceFromUser;
        this.approximateWalkingTimeFromUser = approximateWalkingTimeFromUser;
        this.imagesLink = imagesLink;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Double overallRating) {
        this.overallRating = overallRating;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public List<String> getOperatingHoursOfTheWeek() {
        return operatingHoursOfTheWeek;
    }

    public void setOperatingHoursOfTheWeek(List<String> operatingHoursOfTheWeek) {
        this.operatingHoursOfTheWeek = operatingHoursOfTheWeek;
    }

    public String getMenuLink() {
        return menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public Double getAverageCostOfADish() {
        return averageCostOfADish;
    }

    public void setAverageCostOfADish(Double averageCostOfADish) {
        this.averageCostOfADish = averageCostOfADish;
    }

    public Double getDistanceFromUser() {
        return distanceFromUser;
    }

    public void setDistanceFromUser(Double distanceFromUser) {
        this.distanceFromUser = distanceFromUser;
    }

    public Double getApproximateWalkingTimeFromUser() {
        return approximateWalkingTimeFromUser;
    }

    public void setApproximateWalkingTimeFromUser(Double approximateWalkingTimeFromUser) {
        this.approximateWalkingTimeFromUser = approximateWalkingTimeFromUser;
    }

    public List<String> getImagesLink() {
        return imagesLink;
    }

    public void setImagesLink(List<String> imagesLink) {
        this.imagesLink = imagesLink;
    }
}
