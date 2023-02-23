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
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class ShowBean implements Serializable {
    @ManagedProperty(value = "#{customerBean}")
    private CustomerBean customerBean;
    private List<Show> allShows;
    private Show show;
    private Date dateFilter;
    public ShowBean() {
//        dateFilter = new Date();
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
    public Date getDateFilter() {
        return dateFilter;
    }
    public void setDateFilter(Date dateFilter) {
        this.dateFilter = dateFilter;
    }

    public Integer getFreeSeats() {
        return show.getHall().getTotalseats().intValue() - show.getSeatsoccupied().intValue();
    }

    public void loadList() {
        if(dateFilter != null) {
            allShows = ShowControllerImpl.getInstance().index(dateFilter);
        } else {
            allShows = ShowControllerImpl.getInstance().index();
        }
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
