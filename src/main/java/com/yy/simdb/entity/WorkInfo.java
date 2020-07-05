package com.yy.simdb.entity;

import java.util.Date;

public class WorkInfo {
    private Integer id;

    private Integer wid;

    private Integer status;

    private Byte finished;

    private Date date;

    private String bgsComment;

    private Date modifyTime;

    private String info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Byte getFinished() {
        return finished;
    }

    public void setFinished(Byte finished) {
        this.finished = finished;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBgsComment() {
        return bgsComment;
    }

    public void setBgsComment(String bgsComment) {
        this.bgsComment = bgsComment == null ? null : bgsComment.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", wid=").append(wid);
        sb.append(", status=").append(status);
        sb.append(", finished=").append(finished);
        sb.append(", date=").append(date);
        sb.append(", bgsComment=").append(bgsComment);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", info=").append(info);
        sb.append("]");
        return sb.toString();
    }
}