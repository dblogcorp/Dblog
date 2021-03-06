package io.dblog.jpa.sso;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * {@code BaseEntity}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    public static final Timestamp DELETE_AT = Timestamp.valueOf("1970-01-01 00:00:00.0");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "`created_at`")
    protected Timestamp createdAt;

    @Column(name = "`updated_at`")
    protected Timestamp updatedAt;

    @Column(name = "`deleted_at`")
    protected Timestamp deletedAt;

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