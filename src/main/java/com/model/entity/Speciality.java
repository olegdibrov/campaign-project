package com.model.entity;

import java.util.Objects;

public class Speciality implements Entity {
    private int idSpeciality;
    public String specialityName;

    public Speciality() {
    }

    public Speciality(int idSpeciality, String specialityName) {
        this.idSpeciality = idSpeciality;
        this.specialityName = specialityName;
    }

    public int getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(int idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speciality that = (Speciality) o;
        return idSpeciality == that.idSpeciality &&
                Objects.equals(specialityName, that.specialityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSpeciality, specialityName);
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "idSpeciality=" + idSpeciality +
                ", specialityName='" + specialityName + '\'' +
                '}';
    }
}
