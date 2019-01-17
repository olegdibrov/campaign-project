package com.model.entity;

import java.util.Objects;

public class ExamPreview implements Entity {
    private int id;
    private String subjectName;
    private String userName;
    private String userSurname;
    private int mark;

    public ExamPreview() {
    }

    public ExamPreview(int id, String subjectName, String userName, String userSurname, int mark) {
        this.id = id;
        this.subjectName = subjectName;
        this.userName = userName;
        this.userSurname = userSurname;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
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
        ExamPreview that = (ExamPreview) o;
        return id == that.id &&
                mark == that.mark &&
                Objects.equals(subjectName, that.subjectName) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userSurname, that.userSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectName, userName, userSurname, mark);
    }

    @Override
    public String toString() {
        return "ExamPreview{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", mark=" + mark +
                '}';
    }
}
