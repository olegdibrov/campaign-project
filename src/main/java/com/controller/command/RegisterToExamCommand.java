package com.controller.command;

import com.controller.Pages;
import com.model.dao.factory.DaoFactory;
import com.model.entity.Rating;
import com.model.entity.Subject;
import com.model.entity.User;
import com.service.implementation.*;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RegisterToExamCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(RegisterToExamCommand.class);

    private DepartmentRequirementService departmentRequirementService = ServiceFactory.getInstance().getDepartmentRequirementService();
    private UserService userService = ServiceFactory.getInstance().getUserService();
    private RatingService ratingService = ServiceFactory.getInstance().getRatingService();
    private ExamService examService = ServiceFactory.getInstance().getExamService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int idDepartment = Integer.parseInt(request.getParameter("chosenDepartment"));
        List<Subject> subjects = departmentRequirementService.getSubjectsByDepartment(idDepartment);
        User user = userService.getUserByEmail((String) session.getAttribute("email"));
        Rating rating = new Rating();
        rating.setIdDepartment(idDepartment);
        rating.setIdUser(user.getIdUser());
        Connection connection = DaoFactory.getInstance().getConnection();
        try {
            ratingService.insertRating(rating);
            System.out.println("user id " + user.getIdUser());
            System.out.println("idDepart" + idDepartment);
            examService.registerToExam(user.getIdUser(), idDepartment);
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            LOGGER.error("Error with insert rating and register to exam");
            return Pages.ERROR;
        }
        request.setAttribute("subjects", subjects);
        return Pages.REGISTER_TO_EXAM;
    }
}
