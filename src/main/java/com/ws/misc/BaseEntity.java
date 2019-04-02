package com.ws.misc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by gl on 2019/4/1.
 */
@MappedSuperclass
@JsonIgnoreProperties(value = {"dateCreated", "lastUpdated"}, allowGetters = true)
@Filter(name = DataFilterConstants.NOT_SOFT_DELETE_FILTER_NAME)
@EntityListeners(AuditingEntityListener.class)
@Where(clause = DataFilterConstants.NOT_SOFT_DELETE_CONDITION)
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
