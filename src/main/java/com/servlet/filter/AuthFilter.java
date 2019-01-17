package com.servlet.filter;

import com.controller.Pages;
import com.controller.command.ListOfCommands;
import com.model.entity.User;
import com.service.implementation.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {
    private final static Logger LOGGER = Logger.getLogger("AuthFilter");

    private List<String> commandsWithoutCheck;


    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("do filter auth");
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String command = req.getParameter("command");
        if (command != null && httpServletRequest.getSession() != null) {
            if ( commandsWithoutCheck.contains(command)) {
                System.out.println(req.getParameter("command"));
                LOGGER.debug("User try to " + command);
            } else {
                User user = validateUser(httpServletRequest);
                if (user == null || httpServletRequest.getSession() == null) {
                    httpServletRequest.getRequestDispatcher(Pages.ACCESS_DENIED)
                            .forward(req, resp);
                }
            }
        }
        if (httpServletRequest.getSession() == null) {
            httpServletRequest.getRequestDispatcher(Pages.ACCESS_DENIED)
                    .forward(req, resp);
        }
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        System.out.println("auth - " + req.getCharacterEncoding());


        chain.doFilter(req, resp);
    }

    private User validateUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        if (user == null) {
            LOGGER.debug("User validation failed1");
            ServiceFactory.getInstance().getAuthenticationService().logout(session);
        } else {
            user = ServiceFactory.getInstance().getAuthenticationService()
                    .validate(user.getEmail(), user.getPassword());
            if (user == null) {
                LOGGER.debug("User validation failed2");
                ServiceFactory.getInstance().getAuthenticationService().logout(session);
            }
        }
        return user;
    }

    public void init(FilterConfig config) throws ServletException {
        LOGGER.debug("Auth Filter Initialized");
        commandsWithoutCheck = new ArrayList<>();
        commandsWithoutCheck.add(ListOfCommands.LOGIN.name().toLowerCase());
        commandsWithoutCheck.add(ListOfCommands.REGISTRATION.name().toLowerCase());
        commandsWithoutCheck.add(ListOfCommands.LOGOUT.name().toLowerCase());
        commandsWithoutCheck.add(ListOfCommands.INDEX.name().toLowerCase());
        commandsWithoutCheck.add(ListOfCommands.LOCALIZATION.name().toLowerCase());
    }

}
