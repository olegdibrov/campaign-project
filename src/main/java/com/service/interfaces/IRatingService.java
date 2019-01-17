package com.service.interfaces;

import com.model.entity.Rating;
import com.model.entity.RatingPreview;

import java.util.List;

public interface IRatingService {
    List<Rating> getAllRating();
    List<Rating> getRatingByDepartment(String departmentName);
    void insertRating(Rating rating);
    List<RatingPreview> getAllPreviewRating();
    List<RatingPreview> getPreviewRatingByDepartment(String departmentName);
    boolean updateStatusUserByDepartment(String departmentName);
    Integer getRatingMark(int idUser);
    RatingPreview getUserRatingPreview(int idUser);
    boolean setRatingForUser(int idUser, int rating);
}
