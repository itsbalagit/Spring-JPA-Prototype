CREATE or REPLACE PROCEDURE findRecordException(e_id IN EMPLOYEE.ID%TYPE,
e_name OUT EMPLOYEE.NAME%TYPE, e_role OUT EMPLOYEE.ROLE%TYPE, e_reportee OUT EMPLOYEE.REPORTEE%TYPE)
IS
BEGIN
  SELECT e.* FROM EMPLOYEE e WHERE e.id := e_id;
  EXCEPTION WHEN NO_DATA_FOUND THEN
    RAISE  RAISE_APPLICATION_ERROR (-2001, 'EMPLOYEE DETAILS NOT FOUND');
END;
/