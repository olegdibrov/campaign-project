package com.model.entity;

import java.util.Objects;

public class RatingPreview {
    private int idRating;
    private int idUser;
    private String userName;
    private String userSurname;
    private String department;
    private int rating;
    private String status;

    public RatingPreview(int idRating, int idUser, String userName, String userSurname, String department, int rating,
                         String status) {
        this.idRating = idRating;
        this.idUser = idUser;
        this.userName = userName;
        this.userSurname = userSurname;
        this.department = department;
        this.rating = rating;
        this.status = status;
    }

    public RatingPreview() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRating() {
        return idRating;
    }

    public void setIdRating(int idRating) {
        this.idRating = idRating;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingPreview that = (RatingPreview) o;
        return idRating == that.idRating &&
                idUser == that.idUser &&
                rating == that.rating &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userSurname, that.userSurname) &&
                Objects.equals(department, that.department) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRating, idUser, userName, userSurname, department, rating, status);
    }

    @Override
    public String toString() {
        return "RatingPreview{" +
                "idRating=" + idRating +
                ", idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", department='" + department + '\'' +
                ", rating=" + rating +
                ", status='" + status + '\'' +
                '}';
    }
}
