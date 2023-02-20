package com.theatreproject.beans;

import com.theatreproject.controllers.PlayControllerImpl;
import com.theatreproject.models.Play;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class PlayBean implements Serializable {
    @ManagedProperty(value = "#{customerBean}")
    private CustomerBean customerBean;
    private List<Play> allPlays;
    private Play play;
    public PlayBean () {}
    @PostConstruct
    public void init() { loadList(); }

    public CustomerBean getCustomerBean() {
        return customerBean;
    }

    public void setCustomerBean(CustomerBean customerBean) {
        this.customerBean = customerBean;
    }

    public List<Play> getAllPlays() {
        return allPlays;
    }

    public void setAllPlays(List<Play> allPlays) {
        this.allPlays = allPlays;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public void loadList() {
        allPlays = PlayControllerImpl.getInstance().index();
    }
}
