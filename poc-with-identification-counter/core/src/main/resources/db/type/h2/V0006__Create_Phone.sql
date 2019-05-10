CREATE TABLE phone(
	id BIGINT NOT NULL AUTO_INCREMENT,
	modificationCounter INTEGER NOT NULL,
	number VARCHAR(255) NOT NULL,
	description VARCHAR(255) NOT NULL,
	companyId VARCHAR(10) NOT NULL,
	employeeId VARCHAR(10) NOT NULL,
	CONSTRAINT PK_Employee PRIMARY KEY ( companyId, employeeId );
);