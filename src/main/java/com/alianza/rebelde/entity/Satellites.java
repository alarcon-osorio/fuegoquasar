package com.alianza.rebelde.entity;

import java.util.List;

public class Satellites extends SpaceShip {
    private double distance;
    private String name;

    private List<String> message;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
