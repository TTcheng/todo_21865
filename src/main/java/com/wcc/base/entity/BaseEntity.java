package com.wcc.base.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -5322965491880965341L;
    private String creation_date;
    private String last_update_date;
    private String comments;

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(String last_update_date) {
        this.last_update_date = last_update_date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
