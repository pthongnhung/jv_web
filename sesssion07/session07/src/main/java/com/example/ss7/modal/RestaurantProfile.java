package com.example.ss7.modal;

public class RestaurantProfile {

    private String name;
    private String phone;
    private Boolean active;

    public RestaurantProfile() {
    }

    public RestaurantProfile(String name, String phone, Boolean active) {
        this.name = name;
        this.phone = phone;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
