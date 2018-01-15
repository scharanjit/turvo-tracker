package com.turvo.demo.tracks.track;

import java.io.Serializable;
import java.util.List;

public class Track implements Serializable {

    private String id;
    private String name;
    private Position start;
    private String user;


    private List<Vehicle> vehicleDetails;

    public List<Vehicle> getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(List<Vehicle> vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    private String driver;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    private String vehicleType;


    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    private List<Position> data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Position> getData() {
        return data;
    }

    public void setData(List<Position> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getStart() {
        return start;
    }

    public void setStart(Position start) {
        this.start = start;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
