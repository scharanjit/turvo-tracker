package com.turvo.demo.tracks.track;

import java.io.Serializable;
import java.util.List;

public class Track implements Serializable {

    private String id;
    private String name;
    private Position start;
    private String user;
    private List<Driver> driver;
    private List<Vehicle> vehicleDetails;
    private List<Position> data;

    public List<Vehicle> getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(List<Vehicle> vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public List<Driver> getDriver() {
        return driver;
    }

    public void setDriver(List<Driver> driver) {
        this.driver = driver;
    }

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
