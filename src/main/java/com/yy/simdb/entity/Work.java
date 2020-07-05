package com.yy.simdb.entity;

import java.util.Date;

public class Work {
    private Integer id;

    private String no;

    private Integer type;

    private String origin;

    private Date dueTime;

    private String dueTimeAlt;

    private Byte finished;

    private String other;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
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
        this.dueTimeAlt = dueTimeAlt == null ? null : dueTimeAlt.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", no=").append(no);
        sb.append(", type=").append(type);
        sb.append(", origin=").append(origin);
        sb.append(", dueTime=").append(dueTime);
        sb.append(", dueTimeAlt=").append(dueTimeAlt);
        sb.append(", finished=").append(finished);
        sb.append(", other=").append(other);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}