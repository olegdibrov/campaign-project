package com.controller.command;

import com.model.entity.Speciality;
import com.model.entity.University;
import com.service.implementation.ServiceFactory;
import com.util.Pages;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChooseUniversityCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(ChooseSpecialityCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String speciality = (String) request.getAttribute("chosenSpeciality");
        System.out.println(speciality);
        LOGGER.debug("Show university registration page");
        try {
            List<University> universities = ServiceFactory.getInstance()
                    .getUniversityService().getAllUniversities();
            System.out.println(universities);
            request.setAttribute("universityList", universities);

        } catch (Exception e) {
            return Pages.INDEX;
        }
        return Pages.UNIVERSITY;
    }
}
