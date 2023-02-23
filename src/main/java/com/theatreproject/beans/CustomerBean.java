package com.theatreproject.beans;

import com.theatreproject.utils.GrowlMessage;
import com.theatreproject.utils.Routes;
import com.theatreproject.controllers.CustomerControllerImpl;
import com.theatreproject.models.Customer;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import java.io.Serializable;
import java.util.Date;

@ManagedBean
@SessionScoped
public class CustomerBean implements Serializable {
    private Customer currentCustomer;
    private String username;
    private String fullName;
    private String email;
    private String password;
    private Date birthday;
    private String gender;

    public CustomerBean() {
        clearAttributes();
        currentCustomer = null;
    }

    private void clearAttributes() {
        username = "";
        fullName = "";
        email = "";
        password = "";
        birthday = null;
        gender = null;
    }

    public boolean hasCurrentCustomer() {
        return currentCustomer != null;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String login() {
        try {
            currentCustomer = CustomerControllerImpl.getInstance().authenticate(username, password);
            clearAttributes();
            new GrowlMessage().showInfo("Logged in successfully!");
            return Routes.HOME.getUrl();
        } catch (NoResultException e) {
            new GrowlMessage().showError("Invalid email or password!");
            return null;
        }
    }

    public String logout() {
        currentCustomer = new Customer();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        new GrowlMessage().showInfo("Logged out successfully!");
        return Routes.HOME.getUrl();
    }

    public String register() {
        currentCustomer = new Customer();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return Routes.REGISTER.getUrl();
    }

    public String updateProfile() {
        try {
            CustomerControllerImpl.getInstance().update(getCurrentCustomer());
            new GrowlMessage().showInfo("Customer Profile Updated!");
            return Routes.HOME.getUrl();
        } catch (NoResultException e) {
            return null;
        }
    }

    public String createCustomer() {
        currentCustomer = new Customer();
        try {
            currentCustomer.setUsername(username);
            currentCustomer.setEmail(email);
            currentCustomer.setPassword(password);
            currentCustomer.setFullName(fullName);
            currentCustomer.setBirthday(birthday);
            currentCustomer.setGender(gender);
            CustomerControllerImpl.getInstance().store(currentCustomer);
            new GrowlMessage().showInfo("Customer created");
            return Routes.HOME.getUrl();
        } catch (Exception e) {
            new GrowlMessage().showInfo("Failed to Create!");
            return null;
        }
    }
}
