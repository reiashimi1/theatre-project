package com.theatreproject.utils;

public enum Routes {
    HOME("home.xhtml"),
    PROFILE("profile.xhtml"),
    LOGIN("login.xhtml"),
    REGISTER("register.xhtml"),
    PLAYS("plays.xhtml"),
    SHOWS("shows.xhtml"),
    ACTORS("actors.xhtml"),
    RESERVATIONS("reservations.xhtml"),
    MAKE_RESERVATION("make-reservation.xhtml");

    private final String url;

    Routes(final String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

