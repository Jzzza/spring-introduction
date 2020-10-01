package com.roadrantz.dao;

public class Rant {
    private Vehicle vehicle;

    public String getPostedDate() {
        return "";
    }

    public String getRantText() {
        return "";
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Rant{" +
                "vehicle=" + vehicle +
                '}';
    }
}
