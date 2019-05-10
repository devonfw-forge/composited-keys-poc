CREATE TABLE employee(
	companyId VARCHAR(10) NOT NULL,
	employeeId VARCHAR(10) NOT NULL,
	modificationCounter INTEGER NOT NULL,
	name VARCHAR(255) NOT NULL,
	lastName VARCHAR(255) NOT NULL,
	CONSTRAINT PK_Employee PRIMARY KEY ( companyId, employeeId );
);