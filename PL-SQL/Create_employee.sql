CREATE or REPLACE PROCEDURE createEmployee(e_id IN EMPLOYEE.ID%TYPE,
e_name IN EMPLOYEE.NAME%TYPE, e_role IN EMPLOYEE.ROLE%TYPE, e_reportee IN EMPLOYEE.REPORTEE%TYPE)
IS
BEGIN
  INSERT INTO EMPLOYEE (ID, NAME, ROLE, REPORTEE) VALUES(e_id, e_name, e_role, e_reportee);
  commit;
END;
/
