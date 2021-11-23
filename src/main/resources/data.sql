--CREATE TABLE employee
--(
--id INTEGER,
--name VARCHAR(20),
--dept VARCHAR(20),
--reports VARCHAR(20)
--
--);

INSERT INTO passport(id,passport_number) VALUES(100,'AW002412');
INSERT INTO passport(id,passport_number) VALUES(102,'AW002414');
INSERT INTO passport(id,passport_number) VALUES(103,'AW002417');
INSERT INTO passport(id,passport_number) VALUES(104,'AW002419');



INSERT INTO employee(id,name,dept,reports,passport_id) VALUES(1,'rajaram','development','raviraja',100);
INSERT INTO employee(id,name,dept,reports,passport_id) VALUES(2,'subbu','development','raviraja',102);
INSERT INTO employee(id,name,dept,reports,passport_id) VALUES(3,'raviraja','development','hari',103);
INSERT INTO employee(id,name,dept,reports,passport_id) VALUES(4,'bhimu','development','rajaram',104);


INSERT INTO vehicle(id,vehicle_brand) Values(201,'Zen');
INSERT INTO vehicle(id,vehicle_brand) Values(202,'NEXON');
INSERT INTO vehicle(id,vehicle_brand) Values(204,'CRETA');
INSERT INTO vehicle(id,vehicle_brand) Values(207,'Breeza');



INSERT INTO review(id,review_comment,vehicle_id) Values(401,'Super',201);
INSERT INTO review(id,review_comment,vehicle_id) Values(402,'SuperDuper',202);
INSERT INTO review(id,review_comment,vehicle_id) Values(404,'Amazing',204);
INSERT INTO review(id,review_comment,vehicle_id) Values(407,'ok',202);


INSERT INTO driver(id,name) VALUES(801,'Arjuna');
INSERT INTO driver(id,name) VALUES(802,'Krishna');
INSERT INTO driver(id,name) VALUES(804,'Karna');
INSERT INTO driver(id,name) VALUES(808,'Duryodhana');


INSERT INTO vehicle_driver_join(vehicle_id,driver_id) VALUES(201,801);
INSERT INTO vehicle_driver_join(vehicle_id,driver_id) VALUES(202,802);
INSERT INTO vehicle_driver_join(vehicle_id,driver_id) VALUES(204,804);
INSERT INTO vehicle_driver_join(vehicle_id,driver_id) VALUES(207,808);






