package com.controller.command;

import com.controller.Pages;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LocalizationCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(LocalizationCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("Changing localization");
        String local = request.getParameter("locale");
        request.setAttribute("locale", local);
        return Pages.INDEX;
    }
}
