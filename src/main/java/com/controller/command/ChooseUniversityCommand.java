package com.controller.command;

import com.controller.Pages;
import com.model.entity.University;
import com.service.implementation.ServiceFactory;
import com.service.implementation.UniversityService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ChooseUniversityCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(ChooseSpecialityCommand.class);

    private UniversityService universityService = ServiceFactory.getInstance().getUniversityService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int speciality = Integer.parseInt((String)request.getParameter("chosenSpeciality"));
        LOGGER.debug("Show university registration page");
        try {
            List<University> universities =universityService.getUniversitiesBySpeciality(speciality);
            request.setAttribute("universityList", universities);
            HttpSession session = request.getSession();
            session.setAttribute("idSpeciality", speciality);
        } catch (Exception e) {
            return Pages.INDEX;
        }
        return Pages.UNIVERSITY;
    }
}
