package com.theatreproject.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "SHOWS", schema = "REI")
@NamedQueries({
        @NamedQuery(name = "Show.findAll", query = "SELECT s FROM Show s")
})
public class Show {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "SHOWID")
    private BigInteger showid;
    @OneToOne
    @JoinColumn(name = "PLAYID")
    private Play play;
    @OneToOne
    @JoinColumn(name = "HALLID")
    private Hall hall;
    @Basic
    @Column(name = "SHOWDATE")
    private Date showdate;
    @Basic
    @Column(name = "SEATSOCCUPIED")
    private BigInteger seatsoccupied;

    public BigInteger getShowid() {
        return showid;
    }

    public void setShowid(BigInteger showid) {
        this.showid = showid;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Date getShowdate() {
        return showdate;
    }

    public void setShowdate(Date showdate) {
        this.showdate = showdate;
    }

    public BigInteger getSeatsoccupied() {
        return seatsoccupied;
    }

    public void setSeatsoccupied(BigInteger seatsoccupied) {
        this.seatsoccupied = seatsoccupied;
    }

    public String getOccupiedSeats() {
        if(seatsoccupied.intValue() < 1) {
            return "N/A";
        }
        else if (seatsoccupied.intValue() == 1) {
            return "1";
        }
        return "1-" + seatsoccupied;
    }

    public String getFreeSeats() {
        if(seatsoccupied.intValue() == hall.getTotalseats().intValue()) {
            return "N/A";
        }
        return (seatsoccupied.intValue() + 1) + "-" + hall.getTotalseats();
    }

    public Integer getFreeSeatsNumber() {
        return hall.getTotalseats().intValue() - seatsoccupied.intValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Show that = (Show) o;

        if (showid != null ? !showid.equals(that.showid) : that.showid != null) return false;
        if (play != null ? !play.equals(that.play) : that.play != null) return false;
        if (hall != null ? !hall.equals(that.hall) : that.hall != null) return false;
        if (showdate != null ? !showdate.equals(that.showdate) : that.showdate != null) return false;
        if (seatsoccupied != null ? !seatsoccupied.equals(that.seatsoccupied) : that.seatsoccupied != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = showid != null ? showid.hashCode() : 0;
        result = 31 * result + (play != null ? play.hashCode() : 0);
        result = 31 * result + (hall != null ? hall.hashCode() : 0);
        result = 31 * result + (showdate != null ? showdate.hashCode() : 0);
        result = 31 * result + (seatsoccupied != null ? seatsoccupied.hashCode() : 0);
        return result;
    }
}
