package com.project.digiparking.Model;

public class BookingModel {
    String location;
    String spot;
    String date;
    String startTime;
    String endTime;
    String model;
    String plate;
    String Amount;

    public BookingModel() {
    }

    public BookingModel(String location, String spot, String date, String startTime, String endTime, String model, String plate, String amount) {
        this.location = location;
        this.spot = spot;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.model = model;
        this.plate = plate;
        Amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
