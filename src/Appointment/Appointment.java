/*
 * Class: CS-320-T4514 Software Test Automation & QA
 * Instructor: Dr. Angel Cross, DIT, MMIS
 * Assignment: 5-1 Milestone: Appointment Service
 * Student: Preston Burkhardt
 * Date: 01 Apr 2022
 */

package Appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Appointment {
    private final String appointmentID;
    private Date appointmentDate;
    private String appointmentDesc;
    private static final AtomicLong idGenerator = new AtomicLong();


    //CONSTRUCTORS
    /**
     * CONSTRUCTOR for the Appointment class.
     *
     * @param inputDate  this appointment's date (format: MM/dd/yyyy).
     *                   Cannot be NULL. Cannot be blank. Cannot be in the past.
     * @param inputDesc this appointment's description.
     *                 Cannot be NULL. Cannot be blank. Cannot exceed 50 characters.
     */
    public Appointment(String inputDate, String inputDesc) throws ParseException {
        this.appointmentID = String.valueOf(idGenerator.getAndIncrement());

        this.appointmentDate = dateLogic(inputDate);

        this.appointmentDesc = descLogic(inputDesc);
    }


    //SETTERS
    /**
     * Set the date of the appointment.
     * @param appointmentDate this is the appointment's date in the format of MM/dd/yyyy.
     */
    public void setAppointmentDate(String appointmentDate) throws ParseException {
        this.appointmentDate = dateLogic(appointmentDate);
    }

    /**
     * Set the description of the appointment.
     * @param appointmentDesc this is the appointment's description.
     */
    public void setAppointmentDesc(String appointmentDesc) {
        this.appointmentDesc = descLogic(appointmentDesc);
    }


    //GETTERS
    /**
     * @return the appointment's ID number.
     */
    public String getAppointmentID() {
        return this.appointmentID;
    }

    /**
     * @return the appointment's date.
     */
    public Date getAppointmentDate() {
        return this.appointmentDate;
    }

    /**
     * @return the appointment's description.
     */
    public String getAppointmentDesc() {
        return this.appointmentDesc;
    }


    //HELPER METHODS
    /**
     * Strips only the date from a Date object and returns a string in the format of MM/dd/yyyy.
     * @param passedDate this is a Date object.
     * @return string of the date in the format MM/dd/yyyy.
     */
    private String dateToString(Date passedDate) {
        SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
        return dateOnly.format(passedDate);
    }

    /**
     * Converts a string version of a date in the format of MM/dd/yyyy to a Date object.
     * @param passedDateString this is the date string.
     * @return Date object
     */
    private Date stringToDate(String passedDateString) throws ParseException {
        SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
        return dateOnly.parse(passedDateString);
    }

    /**
     * Performs the logic for setting the appointment date.
     * Can't be null, can't be blank, can't be in the past.
     * @param passedDate String version of the date in the format MM/dd/yyyy.
     * @return Date object
     */
    private Date dateLogic(String passedDate) throws ParseException {
        if (passedDate == null || passedDate.isBlank()) {
            return new Date();
        }
        Date aDate = stringToDate(passedDate);
        Date todaysDate = new Date();
        if (aDate.before(todaysDate)) {
            return todaysDate;
        } else {
            return aDate;
        }
    }

    /**
     * Performs the logic for setting the appointment description.
     * Can't be null, can't be blank, can't be > 50 characters.
     * @param appointmentDesc this is the appointment description.
     * @return appointment description.
     */
    private String descLogic(String appointmentDesc) {
        if (appointmentDesc == null || appointmentDesc.isBlank()) {
            return "noDesc";
        } else if (appointmentDesc.length() > 50) {
            return appointmentDesc.substring(0, 50);
        }
        return appointmentDesc;
    }
}
