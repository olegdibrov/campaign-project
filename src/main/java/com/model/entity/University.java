package com.model.entity;

import java.util.Objects;

public class University implements Entity {
    private int idUniversity;
    private String universityName;

    public University() {
    }

    public University(int idUniversity, String universityName) {
        this.idUniversity = idUniversity;
        this.universityName = universityName;
    }

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return idUniversity == that.idUniversity &&
                Objects.equals(universityName, that.universityName);
    }

    @Override
    public String toString() {
        return "University{" +
                "idUniversity=" + idUniversity +
                ", universityName='" + universityName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUniversity, universityName);
    }
}
