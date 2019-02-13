SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `sistema` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `sistema` ;

-- -----------------------------------------------------
-- Table `sistema`.`fornecedores`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sistema`.`fornecedores` (
  `codigo` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`codigo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema`.`produtos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sistema`.`produtos` (
  `codigo` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(50) NOT NULL ,
  `quantidade` INT NOT NULL ,
  `preco` DECIMAL(8,2) NOT NULL ,
  `fornecedores_codigo` INT NOT NULL ,
  PRIMARY KEY (`codigo`) ,
  INDEX `fk_produtos_fornecedores_idx` (`fornecedores_codigo` ASC) ,
  CONSTRAINT `fk_produtos_fornecedores`
    FOREIGN KEY (`fornecedores_codigo` )
    REFERENCES `sistema`.`fornecedores` (`codigo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `sistema` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
