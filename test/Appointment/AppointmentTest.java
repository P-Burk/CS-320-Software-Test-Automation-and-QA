/*
 * Class: CS-320-T4514 Software Test Automation & QA
 * Instructor: Dr. Angel Cross, DIT, MMIS
 * Assignment: 5-1 Milestone: Appointment Service
 * Student: Preston Burkhardt
 * Date: 01 Apr 2022
 */

package Appointment;

import org.junit.jupiter.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppointmentTest {
    private Appointment newApt;
    private String aptID1;

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

    //SETUP AND TEARDOWN FUNCTIONS
    @BeforeEach
    void setUp() throws ParseException {
        newApt = new Appointment("04/25/2022", "This is a description");
        aptID1 = newApt.getAppointmentID();
    }

    @AfterEach
    void tearDown() {
        newApt = null;
    }

    @Test
    @DisplayName("Appointment constructor check.")
    void apptConstructorTest() {
        String compareDate = dateToString(newApt.getAppointmentDate());
        assertEquals("04/25/2022", compareDate, "Date was not constructed correctly.");
        assertEquals("This is a description", newApt.getAppointmentDesc(),
                "Description was not constructed correctly.");
    }

    @Test
    @DisplayName("Appointment date setter check.")
    void setAppointmentDate() throws ParseException {
        String compareDate = dateToString(newApt.getAppointmentDate());

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
    @DisplayName("Appointment description setter check.")
    void setAppointmentDesc() {
        newApt.setAppointmentDesc("This is a very very super extremely looooooooooong description.");
        assertEquals("This is a very very super extremely looooooooooong", newApt.getAppointmentDesc(),
                "Appointment description max character failure.");

        newApt.setAppointmentDesc(null);
        assertEquals("noDesc", newApt.getAppointmentDesc(), "Appointment description NULL failure.");

        newApt.setAppointmentDesc("");
        assertEquals("noDesc", newApt.getAppointmentDesc(), "Appointment description blank failure.");
    }

    @Test
    @Order(1)
    @DisplayName("Appointment ID getter check.")
    void getAppointmentID() {
        assertEquals(aptID1, newApt.getAppointmentID(), "Appointment ID getter failure.");
    }

    @Test
    @DisplayName("Appointment date getter check.")
    void getAppointmentDate() {
        assertEquals("04/25/2022", dateToString(newApt.getAppointmentDate()),
                "Appointment date getter failure.");
    }

    @Test
    @DisplayName("Appointment description getter check.")
    void getAppointmentDesc() {
        assertEquals("This is a description", newApt.getAppointmentDesc(),
                "Appointment description getter failure.");
    }
}