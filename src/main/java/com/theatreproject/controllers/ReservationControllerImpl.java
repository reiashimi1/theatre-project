package com.theatreproject.controllers;

import com.theatreproject.dao.DAOFactory;
import com.theatreproject.models.Reservation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationControllerImpl implements Controller<Reservation> {
    public ReservationControllerImpl () {}

    private static class LazyHolder {
        static final ReservationControllerImpl INSTANCE = new ReservationControllerImpl();
    }

    public static ReservationControllerImpl getInstance() {
        return ReservationControllerImpl.LazyHolder.INSTANCE;
    }

    @Override
    public ArrayList<Reservation> index() {
        return convertToArrayList(DAOFactory.getReservationDAO().index());
    }

    public ArrayList<Reservation> index(BigInteger customerId) {
        return convertToArrayList(DAOFactory.getReservationDAO().index(customerId));
    }

    public ArrayList<Reservation> index(BigInteger customerId, Date filterDate) {
        return convertToArrayList(DAOFactory.getReservationDAO().index(customerId, filterDate));
    }

    public ArrayList<Reservation> indexCustomer(BigInteger customerId) {
        return convertToArrayList(DAOFactory.getReservationDAO().indexCustomer(customerId));
    }

    @Override
    public Reservation show(Object key) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException("Wrong key type");
        }
        return DAOFactory.getReservationDAO().show(key);
    }

    @Override
    public void store(Reservation reservation) {
        DAOFactory.getReservationDAO().store(reservation);
    }

    @Override
    public void update(Reservation reservation) {
        DAOFactory.getReservationDAO().update(reservation);
    }

    @Override
    public void destroy(Reservation reservation) {
        DAOFactory.getReservationDAO().destroy(reservation);
    }

    public <T> ArrayList<Reservation> convertToArrayList(List<T> reservations) {
        return reservations.stream()
                .filter(object -> object instanceof Reservation)
                .map(object -> (Reservation) object)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
