package cn.jgayb.security.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * Classname MenuResources
 * Description
 * Date 2019-08-05 12:57
 * Created by Wang jun gang
 */
@Entity
@Table(name = "menu_resources")
public class MenuResources {
    private int id;
    private String name;
    private String routingUrl;
    private String createdBy;
    private Boolean enabled;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String remarks;
    private List<ApiAccess> apiAccesses;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "routing_url", nullable = true, length = 200)
    public String getRoutingUrl() {
        return routingUrl;
    }

    public void setRoutingUrl(String routingUrl) {
        this.routingUrl = routingUrl;
    }

    @Basic
    @Column(name = "created_by", nullable = true, length = 20)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "enabled", nullable = true)
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuResources that = (MenuResources) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(routingUrl, that.routingUrl) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(enabled, that.enabled) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt) &&
                Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, routingUrl, createdBy, enabled, createdAt, updatedAt, remarks);
    }

    @ManyToMany
    @JoinTable(name = "menu_api_mapping", joinColumns = @JoinColumn(name = "menu_resources_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "api_access_id", referencedColumnName = "id", nullable = false))
    public List<ApiAccess> getApiAccesses() {
        return apiAccesses;
    }

    public void setApiAccesses(List<ApiAccess> apiAccesses) {
        this.apiAccesses = apiAccesses;
    }
}
