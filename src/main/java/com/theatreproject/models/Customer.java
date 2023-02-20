package com.theatreproject.models;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMERS", schema = "REI")
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
        , @NamedQuery(name = "Customer.authenticate", query = "SELECT c FROM Customer c WHERE c.username = :username AND c.password = :password")
})

public class Customer implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CUSTOMERID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    private BigInteger customerid;
    @Basic
    @Column(name = "USERNAME")
    private String username;
    @Basic
    @Column(name = "FULLNAME")
    private String fullName;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "PASSWORD")
    private String password;
    @Basic
    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Basic
    @Column(name = "GENDER")
    private String gender;

    public BigInteger getCustomerid() {
        return customerid;
    }

    public void setCustomerid(BigInteger customerid) {
        this.customerid = customerid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullname) {
        this.fullName = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer that = (Customer) o;

        if (!Objects.equals(customerid, that.customerid)) return false;
        if (!Objects.equals(username, that.username)) return false;
        if (!Objects.equals(fullName, that.fullName)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(password, that.password)) return false;
        if (!Objects.equals(birthday, that.birthday)) return false;
        if (!Objects.equals(gender, that.gender)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerid != null ? customerid.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "model.Customer[ username=" + username + " ]";
    }
}
