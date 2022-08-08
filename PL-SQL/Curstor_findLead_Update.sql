DECLARE
  CURSOR e_cur IS
    select id, name, role, reportee from employee;
BEGIN
  FOR e_rec IN e_cur
  LOOP
    IF e_rec.role == 'LEAD' THEN
      update employee set reportee = 'YES' where id=e_rec_id;
    END IF;
  END LOOP;
END;
