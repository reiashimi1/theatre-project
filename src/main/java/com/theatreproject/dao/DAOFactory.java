package com.theatreproject.dao;

public class DAOFactory {
    private static final CustomerDAOImpl CUSTOMER_DAO;
    private static final HallDAOImpl HALL_DAO;
    private static final PlayDAOImpl PLAY_DAO;
    private static final ActorDAOImpl ACTOR_DAO;
    private static final ShowDAOImpl SHOW_DAO;
    private static final ReservationDAOImpl RESERVATION_DAO;
    private static final UserDAOImpl USER_DAO;


    static {
        CUSTOMER_DAO = new CustomerDAOImpl();
        HALL_DAO = new HallDAOImpl();
        PLAY_DAO = new PlayDAOImpl();
        ACTOR_DAO = new ActorDAOImpl();
        SHOW_DAO = new ShowDAOImpl();
        RESERVATION_DAO = new ReservationDAOImpl();
        USER_DAO = new UserDAOImpl();
    }

    public static CustomerDAO getCustomerDAO() {
        return CUSTOMER_DAO;
    }

    public static HallDAOImpl getHallDAO() {
        return HALL_DAO;
    }

    public static PlayDAOImpl getPlayDAO() {
        return PLAY_DAO;
    }

    public static ActorDAOImpl getActorDAO() {
        return ACTOR_DAO;
    }

    public static ShowDAOImpl getShowDAO() {
        return SHOW_DAO;
    }

    public static ReservationDAOImpl getReservationDAO() {
        return RESERVATION_DAO;
    }

    public static UserDAOImpl getUserDAO() {
        return USER_DAO;
    }

}
