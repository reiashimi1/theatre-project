package com.theatreproject.models;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "RESERVATIONS", schema = "REI")
@NamedQueries({
        @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r")
        , @NamedQuery(name = "Reservation.findAllForCustomer", query = "SELECT r FROM Reservation r " +
        "WHERE r.customer.customerid = :customerId")
})
public class Reservation implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_sequence")
    @Id
    @Column(name = "RESERVATIONID")
    private BigInteger reservationid;
    @OneToOne
    @JoinColumn(name = "SHOWID")
    private Show show;
    @OneToOne
    @JoinColumn(name = "CUSTOMERID")
    private Customer customer;
    @Basic
    @Column(name = "SEATS")
    private BigInteger seats;

    public BigInteger getReservationid() {
        return reservationid;
    }

    public void setReservationid(BigInteger reservationid) {
        this.reservationid = reservationid;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigInteger getSeats() {
        return seats;
    }

    public void setSeats(BigInteger seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (reservationid != null ? !reservationid.equals(that.reservationid) : that.reservationid != null)
            return false;
        if (show != null ? !show.equals(that.show) : that.show != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reservationid != null ? reservationid.hashCode() : 0;
        result = 31 * result + (show != null ? show.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }
}
