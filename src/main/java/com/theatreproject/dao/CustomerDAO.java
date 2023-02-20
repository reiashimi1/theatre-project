package com.theatreproject.dao;

import com.theatreproject.models.Customer;

public interface CustomerDAO extends DAO<Customer> {

    Customer authenticate(String email, String password);

}
