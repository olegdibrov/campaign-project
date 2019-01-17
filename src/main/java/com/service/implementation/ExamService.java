package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.dao.implementation.DepartmentRequirementsDAO;
import com.model.dao.implementation.ExamDAO;
import com.model.dao.implementation.SubjectDAO;
import com.model.dao.implementation.UserDAO;
import com.model.entity.*;
import com.service.interfaces.IExamService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ExamService implements IExamService {
    private final static Logger LOGGER = Logger.getLogger(ExamService.class);

    private ExamDAO examDAO;
    private SubjectDAO subjectDAO;
    private UserDAO userDAO;
    private DepartmentRequirementsDAO departmentRequirementsDAO;

    ExamService(DaoFactory daoFactory) {
        examDAO = daoFactory.getExamDAO();
        subjectDAO = daoFactory.getSubjectDAO();
        userDAO = daoFactory.getUserDao();
        departmentRequirementsDAO = daoFactory.getDepartmentRequirementsDAO();
    }

    private List<ExamPreview> previewOfExams(List<Exam> exams) {
        List<ExamPreview> examPreview = new ArrayList<>();
        for (Exam exam : exams) {
            examPreview.add(new ExamPreview(exam.getIdExam(), subjectDAO.findEntityById(exam.getIdSubject()).getSubjectName(),
                    userDAO.findEntityById(exam.getIdUser()).getName(),
                    userDAO.findEntityById(exam.getIdUser()).getSurname(), exam.getMark()));
        }
        return examPreview;
    }

    @Override
    public List<Exam> getAllExam() {
        return examDAO.findAll();
    }

    @Override
    public List<ExamPreview> getAllPreviewOfNotMarkedExams() {
        return previewOfExams(findAllNotMarkedExams());
    }

    @Override
    public List<ExamPreview> getPreviewOfExams(List<Exam> exams) {
        return previewOfExams(exams);
    }

    @Override
    public List<ExamPreview> getPreviewOfExamsByIdUser(int idUser) {
        List<Exam> exams = examDAO.findExamsByUser(idUser);
        return getPreviewOfExams(exams);

    }

    @Override
    public List<ExamPreview> getAllPreviewExams() {
        return previewOfExams(getAllExam());
    }

    @Override
    public void registerToExam(int idUser, int idDepartment) {
        List<DepartmentRequirements> departmentRequirements = departmentRequirementsDAO.findRequirementsForDepartment(idDepartment);
        Exam exam = new Exam();
        exam.setIdUser(idUser);
        for (DepartmentRequirements require : departmentRequirements) {
            exam.setIdSubject(require.getIdSubject());
            examDAO.create(exam);
        }
    }

    @Override
    public List<Exam> getExamsByUser(int idUser) {
        return examDAO.findExamsByUser(idUser);
    }

    @Override
    public Exam findExamById(int id) {
        return examDAO.findEntityById(id);
    }

    @Override
    public List<Exam> findAllNotMarkedExams() {
        return examDAO.findAllNotMarkedExams();
    }

    @Override
    public boolean updateExam(Exam entity) {
        return examDAO.update(entity);
    }
}
