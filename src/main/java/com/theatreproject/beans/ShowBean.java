package com.theatreproject.beans;

import com.theatreproject.controllers.ShowControllerImpl;
import com.theatreproject.models.Show;
import com.theatreproject.utils.GrowlMessage;
import com.theatreproject.utils.Routes;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class ShowBean implements Serializable {
    @ManagedProperty(value = "#{customerBean}")
    private CustomerBean customerBean;
    private List<Show> allShows;
    private Show show;

    public ShowBean() {
    }

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

    public List<Show> getAllShows() {
        return allShows;
    }

    public void setAllShows(List<Show> allShows) {
        this.allShows = allShows;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Integer getFreeSeats() {
        return show.getHall().getTotalseats().intValue() - show.getSeatsoccupied().intValue();
    }

    public void loadList() {
        allShows = ShowControllerImpl.getInstance().index();
    }

    public String prepareReservation() {
        if (!customerBean.hasCurrentCustomer()) {
            return Routes.LOGIN.getUrl();
        }
        else if (this.show == null) {
            new GrowlMessage().showInfo("Select a show first");
            return null;
        }  else {
            return Routes.MAKE_RESERVATION.getUrl();
        }
    }

}
