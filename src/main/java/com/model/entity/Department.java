package com.model.entity;

import java.util.Objects;

/**
 * Class describing department entity
 *
 * @author Dibrov Oleg
 */
public class Department implements Entity {
    /**
     * department id field
     */
    private int idDepartment;

    /**
     * department name field
     */
    private String departmentName;

    /**
     * speciality id field
     */
    private int idSpeciality;

    /**
     * university id field
     */
    private int idUniversity;

    /**
     * number of free space in department field
     */
    private int numberOfFreeSpace;


    /**
     * constructor without parameters
     */
    public Department() {
    }


    /**
     * constructor with parameters, sets all fields
     */
    public Department(int idDepartment, String departmentName, int idSpeciality, int idUniversity, int numberOfFreeSpace) {
        this.idDepartment = idDepartment;
        this.departmentName = departmentName;
        this.idSpeciality = idSpeciality;
        this.idUniversity = idUniversity;
        this.numberOfFreeSpace = numberOfFreeSpace;
    }

    /**
     * @return {@link #idDepartment}
     */
    public int getIdDepartment() {
        return idDepartment;
    }

    /**
     * @return {@link #departmentName}
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * sets department name
     *
     * @param departmentName {@link #departmentName}
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * sets department id
     *
     * @param idDepartment {@link #idDepartment}
     */
    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    /**
     * @return {@link #idSpeciality}
     */
    public int getIdSpeciality() {
        return idSpeciality;
    }

    /**
     * sets speciality id
     *
     * @param idSpeciality {@link #idSpeciality}
     */
    public void setIdSpeciality(int idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    /**
     * @return {@link #idUniversity}
     */
    public int getIdUniversity() {
        return idUniversity;
    }

    /**
     * sets university id
     *
     * @param idUniversity {@link #idUniversity}
     */
    public void setIdUniversity(int idUniversity) {
        this.idUniversity = idUniversity;
    }

    /**
     * @return {@link #numberOfFreeSpace}
     */
    public int getNumberOfFreeSpace() {
        return numberOfFreeSpace;
    }

    /**
     * sets university id
     *
     * @param numberOfFreeSpace {@link #numberOfFreeSpace}
     */
    public void setNumberOfFreeSpace(int numberOfFreeSpace) {
        this.numberOfFreeSpace = numberOfFreeSpace;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return idDepartment == that.idDepartment &&
                idSpeciality == that.idSpeciality &&
                idUniversity == that.idUniversity &&
                numberOfFreeSpace == that.numberOfFreeSpace &&
                Objects.equals(departmentName, that.departmentName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(idDepartment, departmentName, idSpeciality, idUniversity, numberOfFreeSpace);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", departmentName='" + departmentName + '\'' +
                ", idSpeciality=" + idSpeciality +
                ", idUniversity=" + idUniversity +
                ", numberOfFreeSpace=" + numberOfFreeSpace +
                '}';
    }
}
