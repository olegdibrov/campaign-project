package com.controller.command;

import com.controller.Pages;
import com.model.entity.Speciality;
import com.service.implementation.ServiceFactory;
import com.service.implementation.SpecialityService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChooseSpecialityCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(ChooseSpecialityCommand.class);

    private SpecialityService specialityService = ServiceFactory.getInstance().getSpecialityService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.debug("Show speciality registration page");
        try {
            List<Speciality> specialities = specialityService.getAllSpecialities();
            request.setAttribute("specialityList", specialities);
        } catch (Exception e) {
            LOGGER.error("Exception in speciality command" + e);
            return Pages.INDEX;
        }
        return Pages.SPECIALITY_PAGE;
    }
}
