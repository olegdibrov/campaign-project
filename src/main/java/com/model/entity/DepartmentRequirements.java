package com.model.entity;

import java.util.Objects;

public class DepartmentRequirements implements Entity {
    private int idDepartmentRequirements;
    private int idDepartment;
    private int idSubject;

    public DepartmentRequirements() {
    }

    public DepartmentRequirements(int idDepartmentRequirements, int idDepartment, int idSubject) {
        this.idDepartmentRequirements = idDepartmentRequirements;
        this.idDepartment = idDepartment;
        this.idSubject = idSubject;
    }

    public int getIdDepartmentRequirements() {
        return idDepartmentRequirements;
    }

    public void setIdDepartmentRequirements(int idDepartmentRequirements) {
        this.idDepartmentRequirements = idDepartmentRequirements;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentRequirements that = (DepartmentRequirements) o;
        return idDepartmentRequirements == that.idDepartmentRequirements &&
                idDepartment == that.idDepartment &&
                idSubject == that.idSubject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartmentRequirements, idDepartment, idSubject);
    }

    @Override
    public String toString() {
        return "DepartmentRequirements{" +
                "idDepartmentRequirements=" + idDepartmentRequirements +
                ", idDepartment=" + idDepartment +
                ", idSubject=" + idSubject +
                '}';
    }
}
