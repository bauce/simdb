package com.yy.simdb.entity;

public class WorkSearch {

    private String type;

    private String no;

    private String originKey;

    private String contentKey;

    private String userId;

    private String dueTime;

    private String dueTimeAlt;

    private String finished;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }

    public String getDueTimeAlt() {
        return dueTimeAlt;
    }

    public void setDueTimeAlt(String dueTimeAlt) {
        this.dueTimeAlt = dueTimeAlt;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }
}
