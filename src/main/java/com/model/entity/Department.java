package com.model.entity;

import java.util.Objects;

public class Department implements Entity {
  private int idDepartment;
  private int idSpeciality;
  private int idUniversity;
  private int numberOfFreeSpace;

    public Department() {
    }

    public Department(int idDepartment, int idSpeciality, int idUniversity, int numberOfFreeSpace) {
        this.idDepartment = idDepartment;
        this.idSpeciality = idSpeciality;
        this.idUniversity = idUniversity;
        this.numberOfFreeSpace = numberOfFreeSpace;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public int getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(int idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public int getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    public int getNumberOfFreeSpace() {
        return numberOfFreeSpace;
    }

    public void setNumberOfFreeSpace(int numberOfFreeSpace) {
        this.numberOfFreeSpace = numberOfFreeSpace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return idDepartment == that.idDepartment &&
                idSpeciality == that.idSpeciality &&
                idUniversity == that.idUniversity &&
                numberOfFreeSpace == that.numberOfFreeSpace;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartment, idSpeciality, idUniversity, numberOfFreeSpace);
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", idSpeciality=" + idSpeciality +
                ", idUniversity=" + idUniversity +
                ", numberOfFreeSpace=" + numberOfFreeSpace +
                '}';
    }
}
