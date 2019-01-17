package com.service.interfaces;

import com.model.entity.Exam;
import com.model.entity.ExamPreview;

import java.util.List;

public interface IExamService {
    List<Exam> getAllExam();
    List<ExamPreview> getAllPreviewOfNotMarkedExams();
    List<ExamPreview> getPreviewOfExams(List<Exam> exams);
    List<ExamPreview> getPreviewOfExamsByIdUser(int idUser);
    List<ExamPreview> getAllPreviewExams();
    void registerToExam(int idUser, int idDepartment);
    List<Exam> getExamsByUser(int idUser);
    Exam findExamById(int id);
    List<Exam> findAllNotMarkedExams();
    boolean updateExam(Exam entity);


}
