-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ecci
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ecci
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ecci` DEFAULT CHARACTER SET utf8 ;
USE `ecci` ;

-- -----------------------------------------------------
-- Table `ecci`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`Usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `contrasenia` VARCHAR(32) NOT NULL,
  `activo` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`Grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`Grupo` (
  `idgrupo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `activo` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idgrupo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`UsuarioGrupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`UsuarioGrupo` (
  `idusuariogrupo` INT NOT NULL AUTO_INCREMENT,
  `idusuario` INT NOT NULL,
  `idgrupo` INT NOT NULL,
  PRIMARY KEY (`idusuariogrupo`),
  INDEX `FK_usuario_grupo_usuario_idx` (`idusuario` ASC),
  INDEX `FK_usuario_grupo_grupo_idx` (`idgrupo` ASC),
  CONSTRAINT `FK_usuario_grupo_usuario`
    FOREIGN KEY (`idusuario`)
    REFERENCES `ecci`.`Usuario` (`idusuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_usuario_grupo_grupo`
    FOREIGN KEY (`idgrupo`)
    REFERENCES `ecci`.`Grupo` (`idgrupo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`Modulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`Modulo` (
  `idmodulo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `activo` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idmodulo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`NivelAcceso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`NivelAcceso` (
  `idnivelacceso` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idnivelacceso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`Permiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`Permiso` (
  `idpermiso` INT NOT NULL AUTO_INCREMENT,
  `idgrupo` INT NOT NULL,
  `idnivelacceso` INT NOT NULL,
  `idmodulo` INT NOT NULL,
  PRIMARY KEY (`idpermiso`),
  INDEX `FK_permiso_grupo_idx` (`idgrupo` ASC),
  INDEX `FK_permiso_nivelacceso_idx` (`idnivelacceso` ASC),
  INDEX `FK_permiso_modulo_idx` (`idmodulo` ASC),
  CONSTRAINT `FK_permiso_grupo`
    FOREIGN KEY (`idgrupo`)
    REFERENCES `ecci`.`Grupo` (`idgrupo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_permiso_nivelacceso`
    FOREIGN KEY (`idnivelacceso`)
    REFERENCES `ecci`.`NivelAcceso` (`idnivelacceso`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_permiso_modulo`
    FOREIGN KEY (`idmodulo`)
    REFERENCES `ecci`.`Modulo` (`idmodulo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`Etiqueta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`Etiqueta` (
  `idetiqueta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idetiqueta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`Necesidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`Necesidad` (
  `idnecesidad` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NOT NULL,
  `descripcion` VARCHAR(1000) NOT NULL,
  `idnecesidadpadre` INT NULL,
  PRIMARY KEY (`idnecesidad`),
  INDEX `FK_necesidad_padre_idx` (`idnecesidadpadre` ASC),
  CONSTRAINT `FK_necesidad_padre`
    FOREIGN KEY (`idnecesidadpadre`)
    REFERENCES `ecci`.`Necesidad` (`idnecesidad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`EtiquetaNecesidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`EtiquetaNecesidad` (
  `idetiquetanecesidad` INT NOT NULL AUTO_INCREMENT,
  `idetiqueta` INT NOT NULL,
  `idnecesidad` INT NOT NULL,
  PRIMARY KEY (`idetiquetanecesidad`),
  INDEX `FK_etiquetanecesidad_etiqueta_idx` (`idetiqueta` ASC),
  INDEX `FK_etiquetanecesidad_necesidad_idx` (`idnecesidad` ASC),
  CONSTRAINT `FK_etiquetanecesidad_etiqueta`
    FOREIGN KEY (`idetiqueta`)
    REFERENCES `ecci`.`Etiqueta` (`idetiqueta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_etiquetanecesidad_necesidad`
    FOREIGN KEY (`idnecesidad`)
    REFERENCES `ecci`.`Necesidad` (`idnecesidad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`Software`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`Software` (
  `idsoftware` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(1000) NOT NULL,
  `licencia` VARCHAR(45) NOT NULL,
  `url` VARCHAR(250) NOT NULL,
  `version` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idsoftware`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`Calificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`Calificacion` (
  `idcalificacion` INT NOT NULL AUTO_INCREMENT,
  `idsoftware` INT NOT NULL,
  `idetiqueta` INT NOT NULL,
  `porcentaje` SMALLINT NOT NULL,
  PRIMARY KEY (`idcalificacion`),
  INDEX `FK_calificacion_software_idx` (`idsoftware` ASC),
  INDEX `FK_calificacion_etiqueta_idx` (`idetiqueta` ASC),
  CONSTRAINT `FK_calificacion_software`
    FOREIGN KEY (`idsoftware`)
    REFERENCES `ecci`.`Software` (`idsoftware`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_calificacion_etiqueta`
    FOREIGN KEY (`idetiqueta`)
    REFERENCES `ecci`.`Etiqueta` (`idetiqueta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`Escolaridad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`Escolaridad` (
  `idescolaridad` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idescolaridad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`Labor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`Labor` (
  `idlabor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idlabor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`Solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`Solicitud` (
  `idsolicitud` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `idescolaridad` INT NOT NULL,
  `idlabor` INT NOT NULL,
  PRIMARY KEY (`idsolicitud`),
  INDEX `FK_solicitud_escolaridad_idx` (`idescolaridad` ASC),
  INDEX `FK_solicitud_labor_idx` (`idlabor` ASC),
  CONSTRAINT `FK_solicitud_escolaridad`
    FOREIGN KEY (`idescolaridad`)
    REFERENCES `ecci`.`Escolaridad` (`idescolaridad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_solicitud_labor`
    FOREIGN KEY (`idlabor`)
    REFERENCES `ecci`.`Labor` (`idlabor`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecci`.`SolicitudDetalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ecci`.`SolicitudDetalle` (
  `idsolicituddetalle` INT NOT NULL AUTO_INCREMENT,
  `idsolicitud` INT NOT NULL,
  `necesidad` VARCHAR(1000) NOT NULL,
  `justificacion` VARCHAR(5000) NULL,
  `herramientaActual` VARCHAR(1000) NULL,
  PRIMARY KEY (`idsolicituddetalle`),
  INDEX `FK_solicituddetalle_solicitud_idx` (`idsolicitud` ASC),
  CONSTRAINT `FK_solicituddetalle_solicitud`
    FOREIGN KEY (`idsolicitud`)
    REFERENCES `ecci`.`Solicitud` (`idsolicitud`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
