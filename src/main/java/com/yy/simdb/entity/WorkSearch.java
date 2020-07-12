package com.yy.simdb.entity;

import java.util.Date;

public class WorkSearch {

    private Integer type;

    private String no;

    private String originKey;

    private String contentKey;

    private int userId;

    private Date dueTime;

    private String dueTimeAlt;

    private Byte finished;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOriginKey() {
        return originKey;
    }

    public void setOriginKey(String originKey) {
        this.originKey = originKey;
    }

    public String getContentKey() {
        return contentKey;
    }

    public void setContentKey(String contentKey) {
        this.contentKey = contentKey;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public String getDueTimeAlt() {
        return dueTimeAlt;
    }

    public void setDueTimeAlt(String dueTimeAlt) {
        this.dueTimeAlt = dueTimeAlt;
    }

    public Byte getFinished() {
        return finished;
    }

    public void setFinished(Byte finished) {
        this.finished = finished;
    }
}
