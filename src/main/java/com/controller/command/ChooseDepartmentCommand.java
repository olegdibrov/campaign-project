package com.controller.command;

import com.controller.Pages;
import com.model.entity.Department;
import com.service.implementation.DepartmentService;
import com.service.implementation.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ChooseDepartmentCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(ChooseSpecialityCommand.class);

    private DepartmentService departmentService = ServiceFactory.getInstance().getDepartmentService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int idUniversity = Integer.parseInt((String)request.getParameter("chosenUniversity"));
        HttpSession session = request.getSession();
        int idSpeciality =  (Integer) session.getAttribute("idSpeciality");
        List<Department> departments = departmentService.getUniversitiesByParameters(idSpeciality, idUniversity);
        request.setAttribute("departmentList", departments);
        return Pages.DEPARTMENT;
    }
}
