package com.project.digiparking;

public class CarDetailsModel {
    private int id;
    private byte[]avatar;
    private String name;
    private String plate;
    private String type;
    private String color;

    public CarDetailsModel(int id, byte[] avatar, String name, String plate, String type, String color) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.plate = plate;
        this.type = type;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
