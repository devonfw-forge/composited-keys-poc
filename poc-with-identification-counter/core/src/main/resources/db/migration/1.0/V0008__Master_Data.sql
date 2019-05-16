INSERT INTO employee (companyId, employeeId ,modificationCounter, name, lastName) VALUES ('cap1','test1',1,'test','test');
INSERT INTO employee (companyId, employeeId ,modificationCounter, name, lastName) VALUES ('cap1','test2',1,'test2','test2');

INSERT INTO Phone (id, modificationCounter, number, description, companyId, employeeId ) VALUES (1, 1, '112255474', 'mobile phone', 'cap1', 'test1');
INSERT INTO Phone (id, modificationCounter, number, description, companyId, employeeId ) VALUES (2, 1, '96112255474', 'home phone', 'cap1', 'test1');
INSERT INTO Phone (id, modificationCounter, number, description, companyId, employeeId ) VALUES (3, 1, '223344556', 'mobile phone', 'cap1', 'test2');
INSERT INTO Phone (id, modificationCounter, number, description, companyId, employeeId ) VALUES (4, 1, '96223344556', 'home phone', 'cap1', 'test2');