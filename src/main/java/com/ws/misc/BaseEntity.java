package com.ws.misc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
*/
@MappedSuperclass
@JsonIgnoreProperties(value = {"dateCreated", "lastUpdated"}, allowGetters = true)
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -1L;


    @JsonIgnore
    protected Date deleted;

    @JsonIgnore
    protected Date imported;

    @CreatedDate
    protected Date dateCreated;

    @LastModifiedDate
    protected Date lastUpdated;


    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    public Date getImported() {
        return imported;
    }

    public void setImported(Date imported) {
        this.imported = imported;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


}
