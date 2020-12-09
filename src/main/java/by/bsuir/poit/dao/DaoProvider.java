package by.bsuir.poit.dao;

import by.bsuir.poit.dao.impl.DefaultRouteRepository;
import by.bsuir.poit.dao.impl.DefaultUserRepository;

public class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();

    private final UserRepository userRepository = new DefaultUserRepository();
    private final RouteRepository routeRepository = new DefaultRouteRepository();

    public static DaoProvider getInstance() {
        return instance;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public RouteRepository getRouteRepository() {
        return routeRepository;
    }
}
