-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema final_pr_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema final_pr_db
-- -----------------------------------------------------

DROP DATABASE IF EXISTS final_pr_db;

CREATE SCHEMA IF NOT EXISTS `final_pr_db` DEFAULT CHARACTER SET utf8mb4 ;
USE `final_pr_db` ;

-- -----------------------------------------------------
-- Table `final_pr_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_pr_db`.`user` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `final_pr_db`.`subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_pr_db`.`subject` (
  `idSubject` INT NOT NULL AUTO_INCREMENT,
  `subjectName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSubject`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `final_pr_db`.`exam`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_pr_db`.`exam` (
  `idExam` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NOT NULL,
  `idSubject` INT NOT NULL,
  `mark` INT NULL,
  PRIMARY KEY (`idExam`),
  INDEX `fk_exam_user_idx` (`idUser` ASC) VISIBLE,
  INDEX `fk_exam_subject1_idx` (`idSubject` ASC) VISIBLE,
  CONSTRAINT `fk_exam_user`
    FOREIGN KEY (`idUser`)
    REFERENCES `final_pr_db`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exam_subject1`
    FOREIGN KEY (`idSubject`)
    REFERENCES `final_pr_db`.`subject` (`idSubject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `final_pr_db`.`speciality`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_pr_db`.`speciality` (
  `idSpeciality` INT NOT NULL,
  `specialityName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSpeciality`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `final_pr_db`.`university`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_pr_db`.`university` (
  `idUniversity` INT NOT NULL AUTO_INCREMENT,
  `universityName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUniversity`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `final_pr_db`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_pr_db`.`department` (
  `idDepartment` INT NOT NULL AUTO_INCREMENT,
  `idSpeciality` INT NOT NULL,
  `idUniversity` INT NOT NULL,
  `numberOfFreeSpace` INT NOT NULL,
  PRIMARY KEY (`idDepartment`),
  INDEX `fk_department_speciality1_idx` (`idSpeciality` ASC) VISIBLE,
  INDEX `fk_department_university1_idx` (`idUniversity` ASC) VISIBLE,
  CONSTRAINT `fk_department_speciality1`
    FOREIGN KEY (`idSpeciality`)
    REFERENCES `final_pr_db`.`speciality` (`idSpeciality`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_department_university1`
    FOREIGN KEY (`idUniversity`)
    REFERENCES `final_pr_db`.`university` (`idUniversity`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `final_pr_db`.`department_requirements`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_pr_db`.`department_requirements` (
  `idDepartment_requirements` INT NOT NULL AUTO_INCREMENT,
  `idDepartment` INT NOT NULL,
  `idSubject` INT NOT NULL,
  PRIMARY KEY (`idDepartment_requirements`),
  INDEX `fk_department_requirements_department1_idx` (`idDepartment` ASC) VISIBLE,
  INDEX `fk_department_requirements_subject1_idx` (`idSubject` ASC) VISIBLE,
  CONSTRAINT `fk_department_requirements_department1`
    FOREIGN KEY (`idDepartment`)
    REFERENCES `final_pr_db`.`department` (`idDepartment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_department_requirements_subject1`
    FOREIGN KEY (`idSubject`)
    REFERENCES `final_pr_db`.`subject` (`idSubject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `final_pr_db`.`rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `final_pr_db`.`rating` (
  `idRating` INT NOT NULL AUTO_INCREMENT,
  `idUser` INT NOT NULL,
  `department_idDepartment` INT NOT NULL,
  `rating` INT NULL,
  PRIMARY KEY (`idRating`),
  INDEX `fk_rating_user1_idx` (`idUser` ASC) VISIBLE,
  INDEX `fk_rating_department1_idx` (`department_idDepartment` ASC) VISIBLE,
  CONSTRAINT `fk_rating_user1`
    FOREIGN KEY (`idUser`)
    REFERENCES `final_pr_db`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rating_department1`
    FOREIGN KEY (`department_idDepartment`)
    REFERENCES `final_pr_db`.`department` (`idDepartment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
