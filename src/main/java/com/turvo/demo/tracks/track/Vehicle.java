package com.turvo.demo.tracks.track;

import java.io.Serializable;

public class Vehicle implements Serializable {

    String vehicleID;

    String vehicleType;

    Double vehicleSpeed;

    public Double getVehicleSpeed() {
        return vehicleSpeed;
    }

    public void setVehicleSpeed(Double vehicleSpeed) {
        this.vehicleSpeed = vehicleSpeed;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
