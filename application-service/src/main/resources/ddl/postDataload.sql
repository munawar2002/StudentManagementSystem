SET autocommit=0;
UPDATE ds_guardian SET usertime = '2018-02-09 10:21:29' WHERE usertime = '0000-00-00 00:00:00';
UPDATE ds_student SET usertime = '2014-04-19 12:37:00' WHERE usertime = '0000-00-00 00:00:00';
UPDATE ds_student SET regdate = '2012-04-01' WHERE regdate = '0000-00-00';
UPDATE ds_lastschool SET usertime = '2018-02-09 10:21:29' WHERE usertime = '0000-00-00 00:00:00';
Delete from ds_student where id_student=0;
Delete from ds_category where id_category=0;
INSERT INTO `ds_category` (`ID_Category`, `Name`, `OrderNo`, `ID_User`, `UserTime`, `BankAccount`, `Short`, `code`) VALUES('15','Dummy Bank','14','7','2013-02-06 14:35:23','DummyBank','DUM','0');
UPDATE ds_guardian SET id_area =9 WHERE id_area IN (2017,2016,2015,2014,2013,2012,7,1,0);
UPDATE ds_area SET usertime = '2018-02-09 10:21:29' WHERE usertime = '0000-00-00 00:00:00';
UPDATE ds_profession SET usertime = '2018-02-09 10:21:29' WHERE usertime = '0000-00-00 00:00:00';
UPDATE ds_GUARDIAN SET NICNO = SUBSTRING(NICNO,1,15) WHERE LENGTH(NICNO) > 20;
UPDATE ds_employee SET usertime = '2018-02-09 10:21:29' , dol=NULL WHERE usertime = '0000-00-00 00:00:00';
UPDATE ds_guardian SET nicno = REPLACE(nicno,'-','');
INSERT INTO `ds_guardian` (`Id_Guardian`, `Id_Profession`, `Name`, `NICNo`, `Contact1`, `Contact2`, `Contact3`, `Address`, `ToDate`, `Id_Area`, `email`, `ISDELETED`, `ID_User`, `UserTime`)
VALUES('371','181','UNKNOWN','0000000000000','00000000000','00000000000','02100000000','UNKNOWN',NULL,'9',NULL,'0','0','2018-02-09 10:21:29');
UPDATE ds_student SET id_guardian = 371 WHERE id_guardian=0;
DELETE FROM ds_student WHERE id_house=0;
COMMIT;

