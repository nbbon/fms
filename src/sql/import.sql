INSERT INTO `Airline` VALUES (1,'SkyTeam'),(2,'oneworld'),(3,'Star Alliance');
INSERT INTO `Airplane` VALUES (1,519,'A380','12345'),(2,416,'747','54321'),(3,519,'A380','23451'),(4,416,'747','43215'),(5,519,'A380','34512'),(6,416,'747','32154');
INSERT INTO `Airport` VALUES (1,'AMS','Amsterdam','The Netherlands','Schiphol'),(2,'DTW','Detroid','USA','Detroid City'),(3,'NRT','Tokyo','Japan','Narita International Airport'),(4,'SYD','Sydney','Australia','Kingsford Smith'),(5,'LAX','Los Angeles','USA','Los Angeles International'),(6,'FRA','Frankfurt','Germany','Frankfurt International Airport'),(7,'ORD','Chicago','USA','Chicago O\'hare International'),(8,'LHR','London','UK','London Heathrow'),(9,'JFK','New York','USA','John F. Kennedy International'),(10,'SIN','Singapore','Singapore','Changi Airport');
INSERT INTO `Flight` VALUES (1,'2009-08-07','09:00:00','2009-08-06','19:10:00','NW 36',1,1,1,2),
                            (2,'2009-08-07','13:45:00','2009-08-06','15:05:00','NW 96',1,2,2,3),
                            (3,'2009-08-07','06:15:00','2009-08-05','22:30:00','QF 12',2,3,4,5),
                            (4,'2009-08-07','06:55:00','2009-08-06','21:55:00','QF 21',2,4,3,4),
                            (5,'2009-08-07','05:45:00','2009-08-06','14:30:00','UA 944',3,5,6,7),
                            (6,'2009-08-07','07:30:00','2009-08-06','12:59:00','UA 934',3,6,8,5),
                            (7,'2009-08-07','07:40:00','2009-08-07','07:15:00','NW 8445',1,1,8,1),
                            (8,'2009-08-07','12:21:00','2009-08-07','12:05:00','NW 1689',1,2,7,2),
                            (9,'2009-08-07','23:39:00','2009-08-07','15:00:00','QF 3101',2,3,9,5),
                            (10,'2009-08-07','17:15:00','2009-08-07','11:05:00','QF 4022',2,4,10,3),
                            (11,'2009-08-07','14:53:00','2009-08-07','12:45:00','UA 941',3,5,7,6),
                            (12,'2009-08-07','10:38:00','2009-08-07','08:10:00','UA 4842',3,6,1,8);
