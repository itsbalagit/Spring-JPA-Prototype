CREATE or REPLACE PROCEDURE findAllLeads()
IS
BEGIN
  SELECT e.* FROM EMPLOYEE e WHERE e.reportees IS NOT NULL;
  if()
END;
/
