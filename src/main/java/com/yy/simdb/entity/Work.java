package com.yy.simdb.entity;

import java.util.Date;

public class Work {
    private Integer id;

    private Float no;

    private Integer userId;

    private Integer type;

    private Date dueTime;

    private Byte finished;

    private String other;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getNo() {
        return no;
    }

    public void setNo(Float no) {
        this.no = no;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public Byte getFinished() {
        return finished;
    }

    public void setFinished(Byte finished) {
        this.finished = finished;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", no=").append(no);
        sb.append(", userId=").append(userId);
        sb.append(", type=").append(type);
        sb.append(", dueTime=").append(dueTime);
        sb.append(", finished=").append(finished);
        sb.append(", other=").append(other);
        sb.append("]");
        return sb.toString();
    }
}