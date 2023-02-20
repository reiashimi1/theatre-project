package com.theatreproject.controllers;

import com.theatreproject.dao.DAOFactory;
import com.theatreproject.models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerControllerImpl implements Controller<Customer> {
    public CustomerControllerImpl () {}

    private static class LazyHolder {
        static final CustomerControllerImpl INSTANCE = new CustomerControllerImpl();
    }

    public static CustomerControllerImpl getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public ArrayList index() {
        return convertToArrayList(DAOFactory.getCustomerDAO().index());
    }

    @Override
    public Customer show(Object key) {
        if (!(key instanceof String)) {
            throw new IllegalArgumentException("Wrong key type");
        }
        return DAOFactory.getCustomerDAO().show(key);

    }

    @Override
    public void store(Customer customer) {
        DAOFactory.getCustomerDAO().store(customer);
    }

    @Override
    public void update(Customer customer) {
        DAOFactory.getCustomerDAO().update(customer);
    }

    @Override
    public void destroy(Customer customer) {
        DAOFactory.getCustomerDAO().destroy(customer);
    }

    public Customer authenticate(String username, String password) {
        return DAOFactory.getCustomerDAO().authenticate(username, password);
    }

    public <T> ArrayList<Customer> convertToArrayList(List<T> customers) {
        return customers.stream()
                .filter(object -> object instanceof Customer)
                .map(object -> (Customer) object)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
