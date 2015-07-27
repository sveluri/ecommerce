DROP database IF EXISTS ecommerce;
create database ecommerce;

-- -----------------------------------------------------
-- Table `ecommerce`.`Customer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ecommerce`.`Customer` (
  `ID` INT auto_increment NOT NULL ,
  `username` VARCHAR(20) NOT NULL DEFAULT '',
  `password` VARCHAR(20) NOT NULL DEFAULT '',
  `email` VARCHAR(100) NOT NULL DEFAULT '',
  `birthdate` DATETIME NULL,
  `hobbies` VARCHAR(500) NOT NULL DEFAULT '',
  `favorite_music` VARCHAR(500) NOT NULL DEFAULT '',
  `favorite_book` VARCHAR(500) NOT NULL DEFAULT '',
  `favorite_tv_shows` VARCHAR(500) NOT NULL DEFAULT '',
  `favorite_quotes` VARCHAR(500) NOT NULL DEFAULT '',
  `marital_status` TINYINT(4) NOT NULL DEFAULT 0,
  `educational_status` TINYINT(4) NOT NULL DEFAULT 0,
  `created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `ecommerce`.`Order`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ecommerce`.`Order` (
  `ID` INT auto_increment  NOT NULL ,
  `customer_id` INT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_Order_1_idx` (`customer_id` ASC) ,
  CONSTRAINT `fk_Order_1`
    FOREIGN KEY (`customer_id` )
    REFERENCES `ecommerce`.`Customer` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecommerce`.`Product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ecommerce`.`Product` (
  `ID` INT auto_increment NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `description` TEXT NULL ,
  `availableQuantity` INT NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ecommerce`.`OrderItem`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ecommerce`.`OrderItem` (
  `ID` INT auto_increment  NOT NULL ,
  `order_ID` INT NOT NULL ,
  `product_ID` INT NOT NULL ,
  `quantity` INT NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_OrderItem_1_idx` (`order_ID` ASC) ,
  INDEX `fk_OrderItem_2_idx` (`product_ID` ASC) ,
  CONSTRAINT `fk_OrderItem_1`
    FOREIGN KEY (`order_ID` )
    REFERENCES `ecommerce`.`Order` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrderItem_2`
    FOREIGN KEY (`product_ID` )
    REFERENCES `ecommerce`.`Product` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `ecommerce` ;
