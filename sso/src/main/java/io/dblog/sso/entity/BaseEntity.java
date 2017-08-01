package io.dblog.sso.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Pelin on 17/7/31.
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    public static final Timestamp DELETE_AT = Timestamp.valueOf("1970-01-01 00:00:00.0");

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "`created_at`")
    private Timestamp createdAt;

    @Column(name = "`updated_at`")
    private Timestamp updatedAt;

    @Column(name = "`deleted_at`")
    private Timestamp deletedAt;

    @PrePersist
    void onCreate() {
        this.createdAt = new Timestamp(new Date().getTime());
        this.updatedAt = this.createdAt;
        this.deletedAt = DELETE_AT;
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = new Timestamp(new Date().getTime());
    }

    @Override
    public boolean equals(Object object) {
        return null != id && getClass().equals(object.getClass()) && id.equals(((BaseEntity) object).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass().getName(), id);
    }

}
