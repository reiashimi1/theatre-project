package com.theatreproject.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "HALLS", schema = "REI")
@NamedQueries({
        @NamedQuery(name = "Hall.findAll", query = "SELECT h FROM Hall h")
})
public class Hall {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "HALLID")
    private BigInteger hallid;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "HALLCOLUMNS")
    private BigInteger hallcolumns;
    @Basic
    @Column(name = "HALLROWS")
    private BigInteger hallrows;
    @Basic
    @Column(name = "TOTALSEATS")
    private BigInteger totalseats;

    public BigInteger getHallid() {
        return hallid;
    }

    public void setHallid(BigInteger hallid) {
        this.hallid = hallid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getHallcolumns() {
        return hallcolumns;
    }

    public void setHallcolumns(BigInteger hallcolumns) {
        this.hallcolumns = hallcolumns;
    }

    public BigInteger getHallrows() {
        return hallrows;
    }

    public void setHallrows(BigInteger hallrows) {
        this.hallrows = hallrows;
    }

    public BigInteger getTotalseats() {
        return totalseats;
    }

    public void setTotalseats(BigInteger totalseats) {
        this.totalseats = totalseats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hall that = (Hall) o;

        if (hallid != null ? !hallid.equals(that.hallid) : that.hallid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (hallcolumns != null ? !hallcolumns.equals(that.hallcolumns) : that.hallcolumns != null) return false;
        if (hallrows != null ? !hallrows.equals(that.hallrows) : that.hallrows != null) return false;
        if (totalseats != null ? !totalseats.equals(that.totalseats) : that.totalseats != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hallid != null ? hallid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (hallcolumns != null ? hallcolumns.hashCode() : 0);
        result = 31 * result + (hallrows != null ? hallrows.hashCode() : 0);
        result = 31 * result + (totalseats != null ? totalseats.hashCode() : 0);
        return result;
    }
}
