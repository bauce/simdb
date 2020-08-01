package com.yy.simdb.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Work {
    private Integer workId;

    private String no;

    private Integer type;

    private String origin;

    private Integer userId;

    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueTime;

    private String dueTimeAlt;

    private Byte finished;

    private Date finishTime;

    private String other;

    private String content;

    private User user;

    private WorkInfo info;

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WorkInfo getInfo() {
        return info;
    }

    public void setInfo(WorkInfo info) {
        this.info = info;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", workId=").append(workId);
        sb.append(", no=").append(no);
        sb.append(", type=").append(type);
        sb.append(", origin=").append(origin);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", dueTime=").append(dueTime);
        sb.append(", dueTimeAlt=").append(dueTimeAlt);
        sb.append(", finished=").append(finished);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", other=").append(other);
        sb.append(", content=").append(content);
        sb.append("]");
        if(null != getInfo()){
            sb.append(" [");
            sb.append("info ="+info.toString());
            sb.append("]");
        }
        return sb.toString();
    }

}