package com.model.entity;

import java.util.Objects;

public class Exam implements Entity {
    private int idExam;
    private int idUser;
    private int idSubject;
    private int mark;

    public Exam() {
    }

    public Exam(int idExam, int idUser, int idSubject, int mark) {
        this.idExam = idExam;
        this.idUser = idUser;
        this.idSubject = idSubject;
        this.mark = mark;
    }

    public int getIdExam() {
        return idExam;
    }

    public void setIdExam(int idExam) {
        this.idExam = idExam;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return idExam == exam.idExam &&
                idUser == exam.idUser &&
                idSubject == exam.idSubject &&
                mark == exam.mark;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idExam, idUser, idSubject, mark);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "idExam=" + idExam +
                ", idUser=" + idUser +
                ", idSubject=" + idSubject +
                ", mark=" + mark +
                '}';
    }
}
