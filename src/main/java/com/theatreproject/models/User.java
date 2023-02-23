package com.theatreproject.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "USERS", schema = "REI")
@NamedQueries({
        @NamedQuery(name = "User.authenticate", query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
})
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "USERID")
    private BigInteger userid;
    @Basic
    @Column(name = "USERNAME")
    private String username;
    @Basic
    @Column(name = "PASSWORD")
    private String password;

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
