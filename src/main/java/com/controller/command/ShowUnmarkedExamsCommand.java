package com.controller.command;

import com.controller.Pages;
import com.model.entity.ExamPreview;
import com.service.implementation.ExamService;
import com.service.implementation.ServiceFactory;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowUnmarkedExamsCommand implements ICommand {
    private final static Logger LOGGER = Logger.getLogger(ShowUnmarkedExamsCommand.class);

    private ExamService examService = ServiceFactory.getInstance().getExamService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<ExamPreview> exams = examService.getAllPreviewOfNotMarkedExams();
        List<ExamPreview> allExams = examService.getAllPreviewExams();
        HttpSession session = request.getSession();
        session.setAttribute("examList", exams);
        session.setAttribute("allExams", allExams);
        return Pages.EXAMS;
    }
}
