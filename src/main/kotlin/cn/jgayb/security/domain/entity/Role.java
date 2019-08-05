package cn.jgayb.security.domain.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Classname Role
 * Description
 * Date 2019-08-05 13:38
 * Created by Wang jun gang
 */
@Entity
public class Role {
    private int id;
    private String name;
    private byte statues;
    private Integer parentId;
    private List<User> users;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "statues", nullable = false)
    public byte getStatues() {
        return statues;
    }

    public void setStatues(byte statues) {
        this.statues = statues;
    }

    @Basic
    @Column(name = "parent_id", nullable = true)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                statues == role.statues &&
                Objects.equals(name, role.name) &&
                Objects.equals(parentId, role.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, statues, parentId);
    }

    @OneToMany(mappedBy = "role")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
