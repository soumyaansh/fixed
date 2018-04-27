package com.example.soumyaanshroy.final_test_1.models;

/**
 * Created by Soumyaansh Roy on 12-04-2018.
 */

public class Buku {

    private String id;
    private String name;
    private String type;
    private String color;
    private String gender;
    private String desc;
    private String price;
    private String size;
    private String sale;
    private String discount;
    private String quality;
    private String category;
    private int thumbnail;

    public Buku(){

    }


    public Buku(String id, String name, String type, String color, String gender, String desc, String price, String size, String sale, String discount, String quality, String category, int thumbnail) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.gender = gender;
        this.desc = desc;
        this.price = price;
        this.size = size;
        this.sale = sale;
        this.discount = discount;
        this.quality = quality;
        this.category = category;
        this.thumbnail = thumbnail;

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
