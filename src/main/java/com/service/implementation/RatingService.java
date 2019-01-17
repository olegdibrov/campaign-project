package com.service.implementation;

import com.model.dao.factory.DaoFactory;
import com.model.dao.implementation.*;
import com.model.entity.*;
import com.service.interfaces.IRatingService;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class RatingService implements IRatingService {
    private final static Logger LOGGER = Logger.getLogger(RatingService.class);

    private DaoFactory daoFactory;

    RatingDAO ratingDAO;
    UserDAO userDAO;
    DepartmentDAO departmentDAO;
    ExamDAO examDAO;

    RatingService(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
        ratingDAO = daoFactory.getRatingDAO();
        userDAO = daoFactory.getUserDao();
        departmentDAO = daoFactory.getDepartmentDao();
        examDAO = daoFactory.getExamDAO();
    }

    private List<RatingPreview> previewOfExams(List<Rating> ratings) {
        List<RatingPreview> ratingPreviews = new ArrayList<>();
        ratings.stream().map(this::generateRatingPreview).forEach(ratingPreviews::add);
        return ratingPreviews;
    }

    private RatingPreview generateRatingPreview(Rating rating) {
        return new RatingPreview(rating.getIdRating(), rating.getIdUser(),
                userDAO.findEntityById(rating.getIdUser()).getName(),
                userDAO.findEntityById(rating.getIdUser()).getSurname(),
                departmentDAO.findEntityById(rating.getIdDepartment()).getDepartmentName(),
                ratingDAO.findEntityById(rating.getIdUser()).getRating(),
                rating.getStatus());
    }

    @Override
    public List<Rating> getAllRating() {
        return daoFactory.getRatingDAO().findAll();
    }

    @Override
    public List<Rating> getRatingByDepartment(String departmentName) {
        Department department = daoFactory.getDepartmentDao().findDepartmentByName(departmentName);
        return daoFactory.getRatingDAO().findRatingByDepartment(department.getIdDepartment());
    }

    @Override
    public void insertRating(Rating rating) {
        daoFactory.getRatingDAO().create(rating);
    }

    @Override
    public List<RatingPreview> getAllPreviewRating() {
        return previewOfExams(getAllRating());
    }

    @Override
    public List<RatingPreview> getPreviewRatingByDepartment(String departmentName) {
        List<RatingPreview> ratingPreviews = previewOfExams(getRatingByDepartment(departmentName));
        return ratingPreviews.stream().sorted(Comparator.comparingInt(RatingPreview::getRating).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateStatusUserByDepartment(String departmentName) {
        Department department = departmentDAO.findDepartmentByName(departmentName);
        List<RatingPreview> ratings = getPreviewRatingByDepartment(departmentName);
        int numberOfFreeSpace = department.getNumberOfFreeSpace();
        boolean result;
        String status;
        for (RatingPreview rating : ratings) {
            if (numberOfFreeSpace > 0) {
                if (rating.getRating() != 0) {
                    status = "Congratulations! You Passed exams and entered to " + rating.getDepartment();
                    numberOfFreeSpace--;
                } else {
                    status = "Your exams have not yet been verified. Please wait";
                }
            } else {
                status = "Sorry, you don't enter to " + rating.getDepartment();
            }
            result = ratingDAO.setStatus(rating.getIdUser(), status);
            if (!result) return false;
        }
        return true;
    }

    @Override
    public Integer getRatingMark(int idUser) {
        List<Exam> exams = daoFactory.getExamDAO().findExamsByUser(idUser);
        boolean skippedExam = exams.stream().anyMatch(exam -> exam.getMark() == 0);
        if (exams != null) {
            if (exams.size() == 3) {
                return skippedExam ? null : exams.stream().mapToInt(exam -> exam.getMark()).sum();
            }
        }
        return null;

    }

    @Override
    public RatingPreview getUserRatingPreview(int idUser) {
        Rating rating = ratingDAO.findEntityById(idUser);
        return generateRatingPreview(rating);

    }

    @Override
    public boolean setRatingForUser(int idUser, int rating) {
        return daoFactory.getRatingDAO().setRating(idUser, rating);
    }
}
