package by.bsuir.poit.service;

import by.bsuir.poit.service.impl.DefaultRouteService;
import by.bsuir.poit.service.impl.DefaultUserService;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private final UserService userService = new DefaultUserService();
    private final RouteService routeService = new DefaultRouteService();

    public static ServiceProvider getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public RouteService getRouteService() {
        return routeService;
    }
}
