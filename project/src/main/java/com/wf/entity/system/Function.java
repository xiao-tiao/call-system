package com.wf.entity.system;

import java.util.List;

public class Function {
    private int id;//功能id
    private String name;
    private int parentId;
    private String url;
    private int serialNum;
    private int accordion;
    private String info;
    private List<Auth> auth;

    public List<Auth> getAuth() {
        return auth;
    }

    public void setAuth(List<Auth> auth) {
        this.auth = auth;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public int getAccordion() {
        return accordion;
    }

    public void setAccordion(int accordion) {
        this.accordion = accordion;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
