package com.theatreproject.beans;

import com.theatreproject.controllers.HallControllerImpl;
import com.theatreproject.models.Hall;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class HallBean implements Serializable {

    @ManagedProperty(value = "#{customerBean}")
    private CustomerBean customerBean;
    private List<Hall> allHalls;
    private Hall hall;
    public HallBean() {}
    @PostConstruct
    public void init() {
        loadList();
    }

    public CustomerBean getCustomerBean() {
        return customerBean;
    }

    public void setCustomerBean(CustomerBean customerBean) {
        this.customerBean = customerBean;
    }

    public List<Hall> getAllHalls() {
        return allHalls;
    }

    public void setAllHalls(List<Hall> allHalls) {
        this.allHalls = allHalls;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public void loadList() {
        allHalls = HallControllerImpl.getInstance().index();
    }

}
