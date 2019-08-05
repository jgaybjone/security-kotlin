package cn.jgayb.security.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * Classname ApiAccess
 * Description
 * Date 2019-08-05 12:57
 * Created by Wang jun gang
 */
@Entity
@Table(name = "api_access")
public class ApiAccess {
    private int id;
    private String name;
    private String url;
    private byte httpMethod;
    private boolean permitAll;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String remarks;
    private Integer createdBy;
    private Integer updatedBy;
    private List<MenuResources> menuResources;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "url", nullable = false, length = 500)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "http_method", nullable = false)
    public byte getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(byte httpMethod) {
        this.httpMethod = httpMethod;
    }

    @Basic
    @Column(name = "permit_all", nullable = false)
    public boolean isPermitAll() {
        return permitAll;
    }

    public void setPermitAll(boolean permitAll) {
        this.permitAll = permitAll;
    }

    @Basic
    @Column(name = "created_at", nullable = true)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at", nullable = true)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "remarks", nullable = true, length = 200)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "created_by", nullable = true)
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "updated_by", nullable = true)
    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiAccess apiAccess = (ApiAccess) o;
        return id == apiAccess.id &&
                httpMethod == apiAccess.httpMethod &&
                permitAll == apiAccess.permitAll &&
                Objects.equals(name, apiAccess.name) &&
                Objects.equals(url, apiAccess.url) &&
                Objects.equals(createdAt, apiAccess.createdAt) &&
                Objects.equals(updatedAt, apiAccess.updatedAt) &&
                Objects.equals(remarks, apiAccess.remarks) &&
                Objects.equals(createdBy, apiAccess.createdBy) &&
                Objects.equals(updatedBy, apiAccess.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url, httpMethod, permitAll, createdAt, updatedAt, remarks, createdBy, updatedBy);
    }

    @ManyToMany(mappedBy = "apiAccesses")
    public List<MenuResources> getMenuResources() {
        return menuResources;
    }

    public void setMenuResources(List<MenuResources> menuResources) {
        this.menuResources = menuResources;
    }
}
