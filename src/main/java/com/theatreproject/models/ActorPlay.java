package com.theatreproject.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "ACTOR_PLAYS", schema = "REI")
public class ActorPlay {
    @Basic
    @Column(name = "ACTORID")
    private BigInteger actorid;
    @Basic
    @Column(name = "PLAYID")
    private BigInteger playid;
    @Id
    private Long id;
    @OneToOne
    @JoinColumn
    private Actor actor;

    public BigInteger getActorid() {
        return actorid;
    }

    public void setActorid(BigInteger actorid) {
        this.actorid = actorid;
    }

    public BigInteger getPlayid() {
        return playid;
    }

    public void setPlayid(BigInteger playid) {
        this.playid = playid;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActorPlay that = (ActorPlay) o;

        if (actorid != null ? !actorid.equals(that.actorid) : that.actorid != null) return false;
        if (playid != null ? !playid.equals(that.playid) : that.playid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = actorid != null ? actorid.hashCode() : 0;
        result = 31 * result + (playid != null ? playid.hashCode() : 0);
        return result;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
