UPDATE ds_guardian SET usertime = '2018-02-09 10:21:29' WHERE usertime = '0000-00-00 00:00:00';
UPDATE ds_student SET usertime = '2014-04-19 12:37:00' WHERE usertime = '0000-00-00 00:00:00';
UPDATE ds_student SET regdate = '2012-04-01' WHERE regdate = '0000-00-00';
UPDATE ds_lastschool SET usertime = '2018-02-09 10:21:29' WHERE usertime = '0000-00-00 00:00:00';
INSERT INTO `ds_category` (`ID_Category`, `Name`, `OrderNo`, `ID_User`, `UserTime`, `BankAccount`, `Short`, `code`) VALUES('15','Dummy Bank','14','7','2013-02-06 14:35:23','DummyBank','DUM','0');

COMMIT;

