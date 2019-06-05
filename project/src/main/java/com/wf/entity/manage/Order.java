package com.wf.entity.manage;

import com.wf.entity.system.Department;
import com.wf.entity.system.Staff;

import java.util.Date;

public class Order {
    private int id;//工单号
    private int bid;//所属企业
    private int did;//处理部门
    private int sid;//处理人员
    private String question;//问题描述
    private String clas;//问题类别
    private String status;//工单状态
    private String mode;//处理方式
    private String info;//备注
    private Date createTime;//创建时间
    private int time;//处理时长
    private Date handTime;//处理时间
    private String resolve;//处理结果
    private int timeOut;
    private String extra;


    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    private Department department;//所属部门
    private Staff staff;//处理人员
    private Busines busines;//所属企业

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Busines getBusines() {
        return busines;
    }

    public void setBusines(Busines busines) {
        this.busines = busines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Date getHandTime() {
        return handTime;
    }

    public void setHandTime(Date handTime) {
        this.handTime = handTime;
    }

    public String getResolve() {
        return resolve;
    }

    public void setResolve(String resolve) {
        this.resolve = resolve;
    }
}
