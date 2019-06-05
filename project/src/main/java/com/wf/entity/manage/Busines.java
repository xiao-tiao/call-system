package com.wf.entity.manage;

public class Busines {
    private int id;
    private String name;
    private String contact;
    private String phone;
    private String telPhone;
    private String licence;
    private String info;
    private String address;

    public Busines(int id, String name, String contact, String phone, String telPhone, String licence, String info, String address) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.phone = phone;
        this.telPhone = telPhone;
        this.licence = licence;
        this.info = info;
        this.address = address;
    }

    public Busines()
    {

    }
    public Busines(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
