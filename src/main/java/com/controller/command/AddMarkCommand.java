package com.controller.command;

import com.model.entity.Exam;
import com.service.implementation.ExamService;
import com.service.implementation.RatingService;
import com.service.implementation.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddMarkCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(AddMarkCommand.class);

    private ExamService examService = ServiceFactory.getInstance().getExamService();
    private RatingService ratingService = ServiceFactory.getInstance().getRatingService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idExam = Integer.parseInt(request.getParameter("idExam"));
            int mark = Integer.parseInt(request.getParameter("mark"));
            Exam exam = examService.findExamById(idExam);
            exam.setMark(mark);
            examService.updateExam(exam);
            Integer rating = ratingService.getRatingMark(exam.getIdUser());
            if ( rating != null) {
                ratingService.setRatingForUser(exam.getIdUser(), rating);
            }
            request.setAttribute("markAction", "Mark saved");
        } catch (NumberFormatException | NullPointerException ex) {
            LOGGER.error("Mark is not inputted");
            request.setAttribute("markAction", "Mark is not saved");
        }
        return new ShowUnmarkedExamsCommand().execute(request, response);
    }

}
