/*polpulate users*/
INSERT INTO users(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO users(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);

/*populate roles*/ 
INSERT INTO authorities (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');

/*polpulate timespans*/
INSERT INTO `timespan` VALUES (1,'10:45','10:00'),(2,'11:45','11:00'),(3,'14:15','13:30'),(4,'15:15','14:30'),(5,'16:15','15:30'),(6,'17:15','16:30');

/*polpulate categories*/
INSERT INTO `category` VALUES (1,'Allergist',NULL),(2,'Cardiologist',NULL),(3,'Chiropractor',NULL),(5,'Dermatologist',NULL),(6,'Gastroenterologist',NULL),(7,'Opthalmologist',NULL),(8,'Optometrist',NULL),(9,'Orthopedic Surgeon',NULL),(10,'Pediatrician',NULL),(11,'Primary Care Doctor',NULL),(12,'Psychiatrist',NULL),(13,'Urologist',NULL);

/*populate phones*/
INSERT INTO `phone` VALUES (1,'999','3333','222'),(2,'111','4444','333'),(3,'444','6666','555'),(4,'111','3333','222');

/*populate addresses*/
INSERT INTO `address` VALUES (1,'Fairfield','IA','1000 N 4th','12345'),(2,'Fairfield','IA','1000 Nth','52557'),(3,'Fairfield','IA','1000 N 4th','52557'),(4,'Fairfield','IA','1000 N 4th','52557');

/*populate doctors*/
INSERT INTO `doctor` VALUES (1,'Khanh','Tran','15 years experience',1,1,1),(2,'Tom','Kid','4 years experience',2,10,2),(3,'John','Doe','2 years experience',3,1,3),(4,'David','Pull','1 year experience',4,5,4);

/*populate doctors - timespan*/
INSERT INTO `doctor_timespan` VALUES (1,1),(1,2),(1,3),(1,4),(1,5), (2,1),(2,2),(2,3),(3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(4,1),(4,2),(4,3),(4,4),(4,5),(4,6);

/*populate Airline*/
INSERT INTO `Airline` VALUES (1,'SkyTeam'),(2,'oneworld'),(3,'Star Alliance');

/*populate Airplane*/
INSERT INTO `Airplane` VALUES (1,519,'A380','12345'),(2,416,'747','54321'),(3,519,'A380','23451'),(4,416,'747','43215'),(5,519,'A380','34512'),(6,416,'747','32154');

/*populate Airport*/
INSERT INTO `Airport` VALUES (1,'AMS','Amsterdam','The Netherlands','Schiphol'),(2,'DTW','Detroid','USA','Detroid City'),(3,'NRT','Tokyo','Japan','Narita International Airport'),(4,'SYD','Sydney','Australia','Kingsford Smith'),(5,'LAX','Los Angeles','USA','Los Angeles International'),(6,'FRA','Frankfurt','Germany','Frankfurt International Airport'),(7,'ORD','Chicago','USA','Chicago Ohare International'),(8,'LHR','London','UK','London Heathrow'),(9,'JFK','New York','USA','John F. Kennedy International'),(10,'SIN','Singapore','Singapore','Changi Airport');

/*populate Flight*/
INSERT INTO `Flight` VALUES (1,'2009-08-07','09:00:00','2009-08-06','19:10:00','NW 36',1,1,1,2),(2,'2009-08-07','13:45:00','2009-08-06','15:05:00','NW 96',1,2,2,3),(3,'2009-08-07','06:15:00','2009-08-05','22:30:00','QF 12',2,3,4,5),(4,'2009-08-07','06:55:00','2009-08-06','21:55:00','QF 21',2,4,3,4),(5,'2009-08-07','05:45:00','2009-08-06','14:30:00','UA 944',3,5,6,7),(6,'2009-08-07','07:30:00','2009-08-06','12:59:00','UA 934',3,6,8,5),(7,'2009-08-07','07:40:00','2009-08-07','07:15:00','NW 8445',1,1,8,1),(8,'2009-08-07','12:21:00','2009-08-07','12:05:00','NW 1689',1,2,7,2),(9,'2009-08-07','23:39:00','2009-08-07','15:00:00','QF 3101',2,3,9,5),(10,'2009-08-07','17:15:00','2009-08-07','11:05:00','QF 4022',2,4,10,3),(11,'2009-08-07','14:53:00','2009-08-07','12:45:00','UA 941',3,5,7,6),(12,'2009-08-07','10:38:00','2009-08-07','08:10:00','UA 4842',3,6,1,8);