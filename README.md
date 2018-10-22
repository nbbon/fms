# Online Support

## Introduction
We are going to design and implement a online Flight Management and Ticketing Reservation project. This is an engineering proof of concept. It is not a planned marketable project. The goal is to exercise the Spring MVC technology according to the Web Application Architecture (WAA) course guidelines to validate its use in future projects.
## Purpose
	Online Flight Management and Ticketing Reservation is a web application which provides users the ability to view/serach and make ticket reservation for a flight online. Once ticket reservation is made, user can be able to view their reservation information by providing the system their confirmation code [auto generated after successful making reservation], first name, last name and date of bird for security check. The system also provides back-office features for system administration purpose. These features are provided for authorized persons only. Who have to provide username and password for login 
## Requirements 
- Register information for patients, doctors, users and clinical staff
- Create and modify new appointments for existing patients
- View the appointments with assigned doctors with filters by week or month
- Update consultation for each patient when the appointment occurs in the clinic and payment registration or check in and check out

## Common Use-Cases
### Patient register an account

- Patient clicks on Register New Account link
- System shows New Patient Form
- Patient enter first name, last name, date of birth, SSN, user name, password, confirm password, address, city, state and zip code
- Patient clicks on Save Account
- System validates all fields are mandatory, date of birth must be valid, SSN must be the correct format, password must be meet some requirements for security, confirm password must be equals to password, zip code must have two character length.
- System saves information in database and shows confirmation message
 
### Patient make an appointment

- Patient clicks on New Appointment link
- System shows New Appointment Form
- Patient  select a category
- Patient  select a doctor
- Patient enter date for the appointment
- Patient clicks on Check Availability link
- System shows available times spans for the selected doctor in the specified date
- Patient chooses a timespan and click Save Appointment
- System shows a confirmation modal window to accept the sending of data.
- System  validates information and saves appointment to database shows confirmation message.

	
### Admin create new doctor
- Admin click on New Doctor
- System shows New Doctor form
- Admin enter doctor information
- Admin setup available time spans for doctor
- Admin click Save
- System save doctor and schedule information and display confirmation message
	
## Class Diagram

## Sequence Diagrams

### Patient register an account
### Patient make an appointment
### Admin create new doctor



