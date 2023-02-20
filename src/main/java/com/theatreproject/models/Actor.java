package com.theatreproject.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "ACTORS", schema = "REI")
@NamedQueries({
        @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a")
        ,         @NamedQuery(name = "Actor.findAllForPlay", query = "SELECT a FROM Actor a WHERE a.actorid " +
        "IN (SELECT ap.actorid FROM ActorPlay ap WHERE ap.playid = :playId )")

})
public class Actor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ACTORID")
    private BigInteger actorid;
    @Basic
    @Column(name = "ACTORNAME")
    private String actorname;

    public BigInteger getActorid() {
        return actorid;
    }

    public void setActorid(BigInteger actorid) {
        this.actorid = actorid;
    }

    public String getActorname() {
        return actorname;
    }

    public void setActorname(String actorname) {
        this.actorname = actorname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor that = (Actor) o;

        if (actorid != null ? !actorid.equals(that.actorid) : that.actorid != null) return false;
        if (actorname != null ? !actorname.equals(that.actorname) : that.actorname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actorid != null ? actorid.hashCode() : 0;
        result = 31 * result + (actorname != null ? actorname.hashCode() : 0);
        return result;
    }
}
