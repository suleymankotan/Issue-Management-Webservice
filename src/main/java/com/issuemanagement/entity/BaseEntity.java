package com.issuemanagement.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Column(name = "created_At")
    @Temporal(TemporalType.TIME)
    private Date createdAt;

    @Column(name = "created_By",length = 100)
    private String createdBy;

    @Column(name = "updated_At")
    @Temporal(TemporalType.TIME)
    private Date updatedAt;

    @Column(name = "updated_By",length = 100)
    private String updatedBy;

    @Column(name = "status")
    private Boolean status;
}
