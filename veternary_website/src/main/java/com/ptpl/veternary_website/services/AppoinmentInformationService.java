package com.ptpl.veternary_website.services;

import com.ptpl.veternary_website.payloads.AppoinmentInformationDto;

public interface AppoinmentInformationService {

//Create an Appointment: This service allows you to create a new appointment by providing the appointment details, including the doctor and hospital associated with it.
AppoinmentInformationDto createAnAppointment(AppoinmentInformationDto appoinmentInformationDto,Integer docId,Integer hosId);	

//Get All Appointments: This service retrieves a list of all appointments stored in the database.

//Get Appointment by ID: This service retrieves a specific appointment based on its unique ID.

//Update Appointment: This service allows you to update the details of an existing appointment.

//Delete Appointment: This service allows you to delete an appointment from the database.

	
//Get Appointments by Doctor: This service retrieves all appointments associated with a specific doctor.

//Get Appointments by Hospital: This service retrieves all appointments associated with a specific hospital.

//Get Available Appointments: This service retrieves all available appointments where isDoctorAvailable is set to true.

//Search Appointments: Implement a service to search for appointments based on various criteria, such as date, time, doctor, hospital, etc.

//Get Appointments by User: If your application has a user system, you can create a service to retrieve all appointments associated with a specific user (patient).

//Cancel Appointment: Implement a service to allow users to cancel their appointments.

//Get Available Time Slots: Provide a service to get available time slots for a specific doctor or hospital.

//Get Appointments for Today: Create a service to retrieve all appointments scheduled for the current day.

//Get Appointments by Status: If your appointments have different status (e.g., confirmed, pending, canceled), create a service to filter appointments based on their status.

//Get Appointments by Date Range: Implement a service to fetch appointments within a specified date range.

//Get Doctor's Next Available Appointment: Provide a service to get the next available appointment for a specific doctor.

//Appointment Reminders: Implement a service to send appointment reminders to users before their scheduled appointments.

//Appointment Analytics: Create services to retrieve appointment-related analytics, such as the number of appointments per day, average appointment duration
}
