package com.kietnguyen.models;

import com.kietnguyen.tools.PasswordEncoder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "App_User", uniqueConstraints = {@UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name")})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id", nullable = false)
    private Integer userId;

    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;

    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;

    @JoinColumn(name = "owner_id", nullable = false)
    @OneToOne
    private Owner owner;

    @Column(name = "Enabled", length = 1, nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean enabled;

    @ManyToMany(cascade = { CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<AppRole> roles = new HashSet<>();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = new PasswordEncoder().getEncodedPassword(encrytedPassword);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }

    public void clone(AppUser user) {
        this.userName = user.getUserName();
        this.owner = user.getOwner();
        this.encrytedPassword = user.getEncrytedPassword();
        this.enabled = user.isEnabled();
    }

    public String toString() {
        return "ID: " + userId + "\tUSERNAME: " + userName + "\tOWNER: " + owner.getName() + "\tIS_ENABLED:" +enabled;
    }
}
