package com.model.entity;

import java.util.Objects;

public class Subject implements Entity {
    private int idSubject;
    private String subjectName;

    public Subject() {
    }

    public Subject(int idSubject, String subjectName) {
        this.idSubject = idSubject;
        this.subjectName = subjectName;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return idSubject == subject.idSubject &&
                Objects.equals(subjectName, subject.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubject, subjectName);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idSubject=" + idSubject +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
