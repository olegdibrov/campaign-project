package com.controller.command;

import com.controller.Pages;
import com.service.implementation.RatingService;
import com.service.implementation.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class SendNotificationCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(SendNotificationCommand.class);

    private RatingService ratingService = ServiceFactory.getInstance().getRatingService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        if (ratingService.updateStatusUserByDepartment((String)request.getSession().getAttribute("selectedModule"))) {
            request.setAttribute("ratingAction", "Rating updated");
            return Pages.RATING;
        }
        else return Pages.ERROR;
    }
}
