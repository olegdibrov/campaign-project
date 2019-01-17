package com.controller.command;

import com.controller.Pages;
import com.model.entity.Department;
import com.model.entity.RatingPreview;
import com.service.implementation.DepartmentService;
import com.service.implementation.RatingService;
import com.service.implementation.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class ShowRatingCommand implements ICommand{
    private final static Logger LOGGER = Logger.getLogger(ShowRatingCommand.class);

    private DepartmentService departmentService = ServiceFactory.getInstance().getDepartmentService();
    private RatingService ratingService = ServiceFactory.getInstance().getRatingService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Department> departments = departmentService.getAllDistinctDepartments();
        String department = request.getParameter("departmentName");
        if (department == null) {
            department = departments.get(0).getDepartmentName();
        }
        List<RatingPreview> ratingPreviews = ratingService.getPreviewRatingByDepartment(department);
        HttpSession session = request.getSession();
        session.setAttribute("ratings", ratingPreviews);
        session.setAttribute("departments", departments);
        session.setAttribute("selectedModule", department);
        return Pages.RATING;
    }
}
