package com.alianza.rebelde.entity;

public class Transport extends SpaceShip {

    private String message;

    public Transport(Position position, String message){
        this.setPosition(position);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
