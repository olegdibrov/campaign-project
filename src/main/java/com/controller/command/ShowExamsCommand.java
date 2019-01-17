package com.controller.command;

import com.controller.Pages;
import com.model.entity.*;
import com.service.implementation.ExamService;
import com.service.implementation.RatingService;
import com.service.implementation.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowExamsCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(ShowExamsCommand.class);

    private ExamService examService = ServiceFactory.getInstance().getExamService();
    private RatingService ratingService = ServiceFactory.getInstance().getRatingService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        List<ExamPreview> examPreviews = examService.getPreviewOfExamsByIdUser(user.getIdUser());
        RatingPreview ratingPreview = ratingService.getUserRatingPreview(user.getIdUser());
        request.setAttribute("userExams", examPreviews);
        request.setAttribute("rating", ratingPreview);
        return Pages.USER_PAGE;
    }
}
