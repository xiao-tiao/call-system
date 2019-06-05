package com.wf.entity.system;



import java.util.List;

public class Department {
    private int id;
    private String name;
    private String address;
    private List<Post> post;
    private List<Auth> auth;

    public List<Auth> getAuth() {
        return auth;
    }

    public void setAuth(List<Auth> auth) {
        this.auth = auth;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }



    public Department(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Department(String name, String address) {
        this.name=name;
        this.address=address;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
