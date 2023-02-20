package com.theatreproject.beans;

import com.theatreproject.controllers.ReservationControllerImpl;
import com.theatreproject.models.Customer;
import com.theatreproject.models.Reservation;
import com.theatreproject.models.Show;
import com.theatreproject.utils.GrowlMessage;
import com.theatreproject.utils.Routes;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@ManagedBean
@SessionScoped
public class ReservationBean implements Serializable {
    @ManagedProperty(value = "#{customerBean}")
    private CustomerBean customerBean;
    @ManagedProperty(value = "#{showBean}")
    private ShowBean showBean;
    private List<Reservation> allReservations;
    private Reservation reservation;
    private Show show;
    private Customer customer;
    private BigInteger seats;

    public ReservationBean() {}
    @PostConstruct
    public void init () { loadList(); }

    public CustomerBean getCustomerBean() {
        return customerBean;
    }

    public void setCustomerBean(CustomerBean customerBean) {
        this.customerBean = customerBean;
    }

    public ShowBean getShowBean() {
        return showBean;
    }

    public void setShowBean(ShowBean showBean) {
        this.showBean = showBean;
    }

    public List<Reservation> getAllReservations() {
        return allReservations;
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
    public void setAllReservations(List<Reservation> allReservations) {
        this.allReservations = allReservations;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void loadList() {
        allReservations = ReservationControllerImpl.getInstance().index(customerBean.getCurrentCustomer().getCustomerid());
    }

    public String makeReservation() {
        try {
            if(seats.intValue() > showBean.getShow().getFreeSeatsNumber()) {
                new GrowlMessage().showInfo("Select a proper number of seats");
                return null;
            }
            reservation = new Reservation();
            reservation.setShow(showBean.getShow());
            reservation.setCustomer(customerBean.getCurrentCustomer());
            reservation.setSeats(seats);
            ReservationControllerImpl.getInstance().store(reservation);
            loadList();
            new GrowlMessage().showInfo("Reservation done");
            return Routes.HOME.getUrl();
        } catch (Exception e) {
            new GrowlMessage().showInfo("Failed to Create!");
            return null;
        }
    }
}
