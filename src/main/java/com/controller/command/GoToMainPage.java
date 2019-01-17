package com.controller.command;

import com.controller.Pages;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToMainPage implements ICommand{
    private final static Logger LOGGER = Logger.getLogger(GoToMainPage.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Pages.INDEX;
    }
}
