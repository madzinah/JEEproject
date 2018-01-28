package jee.project.Entity;

import jee.project.Utils.AuthenticationUtils.Role;
import jee.project.Utils.ValidEmail;
import jee.project.Utils.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @ValidPassword
    @Transient
    private String password;

    private byte[] salt;

    @ValidEmail
    @NotNull
    private String email;

    private String hashedPassword;

    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getSalt() {return salt;}

    public void setSalt(byte[] salt) { this.salt = salt; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {return role; }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
