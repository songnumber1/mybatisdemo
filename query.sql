USE testdb;

CREATE TABLE `user` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`active` BIT(1) NOT NULL,
	`email` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`password` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`remark` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`roles` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`token` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`tokenExpired` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`username` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb3_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2
;


CREATE TABLE LOG (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	CONTENT VARCHAR(2000) NOT NULL,
	REMARK VARCHAR(255) NULL,
	
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb3_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2
;


SELECT * FROM user;