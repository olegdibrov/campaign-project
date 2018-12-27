package com.model.entity;

import java.util.Objects;

public class Rating implements Entity {
    private int idRating;
    private int idUser;
    private int idDepartment;
    private int rating;

    public Rating() {
    }

    public Rating(int idRating, int idUser, int idDepartment, int rating) {
        this.idRating = idRating;
        this.idUser = idUser;
        this.idDepartment = idDepartment;
        this.rating = rating;
    }

    public int getIdRating() {
        return idRating;
    }

    public void setIdRating(int idRating) {
        this.idRating = idRating;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
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
        Rating rating1 = (Rating) o;
        return idRating == rating1.idRating &&
                idUser == rating1.idUser &&
                idDepartment == rating1.idDepartment &&
                rating == rating1.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRating, idUser, idDepartment, rating);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "idRating=" + idRating +
                ", idUser=" + idUser +
                ", idDepartment=" + idDepartment +
                ", rating=" + rating +
                '}';
    }
}
