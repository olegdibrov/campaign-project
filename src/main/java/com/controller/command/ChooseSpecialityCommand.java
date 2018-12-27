package com.controller.command;

import com.model.entity.Speciality;
import com.service.implementation.ServiceFactory;
import com.util.Pages;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ChooseSpecialityCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(ChooseSpecialityCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("Show speciality registration page");
        try {
            List<Speciality> specialities = ServiceFactory.getInstance()
                    .getSpecialityService().getAllSpecialities();
            request.setAttribute("specialityList", specialities);
            System.out.println(specialities);

        } catch (Exception e) {
            return Pages.INDEX;
        }
        return Pages.SPECIALITY_PAGE;
    }
}
