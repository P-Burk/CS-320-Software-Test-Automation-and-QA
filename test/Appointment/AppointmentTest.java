/*
 * Class: CS-320-T4514 Software Test Automation & QA
 * Instructor: Dr. Angel Cross, DIT, MMIS
 * Assignment: 5-1 Milestone: Appointment Service
 * Student: Preston Burkhardt
 * Date: 01 Apr 2022
 */

package Appointment;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    //HELPER FUNCTION
    /**
     * Strips only the date from a Date object and returns a string in the format of MM/dd/yyyy.
     * @param passedDate this is a Date object.
     * @return string of the date in the format MM/dd/yyyy.
     */
    private String dateToString(Date passedDate) {
        SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
        return dateOnly.format(passedDate);
    }

    @Test
    void setAppointmentDate() throws ParseException {
        Appointment newApt = new Appointment("04/25/2022", "This is a description");
        String compareDate = dateToString(newApt.getAppointmentDate());
        assertEquals("04/25/2022", compareDate, "Date was not constructed correctly.");

        newApt.setAppointmentDate("01/01/2000");
        Date newDate = new Date();
        assertEquals(newDate, newApt.getAppointmentDate(), "Date past check failed.");

        newApt.setAppointmentDate("05/25/2022");
        compareDate = dateToString(newApt.getAppointmentDate());
        assertEquals("05/25/2022", compareDate, "Date was not set correctly.");

        newApt.setAppointmentDate(null);
        newDate = new Date();
        assertEquals(newDate, newApt.getAppointmentDate(), "Date null check failed.");

        newApt.setAppointmentDate("");
        newDate = new Date();
        assertEquals(newDate, newApt.getAppointmentDate(), "Date blank check failed.");
    }

    @Test
    void setAppointmentDesc() {
    }

    @Test
    void getAppointmentID() {
    }

    @Test
    void getAppointmentDate() {
    }

    @Test
    void getAppointmentDesc() {
    }
}