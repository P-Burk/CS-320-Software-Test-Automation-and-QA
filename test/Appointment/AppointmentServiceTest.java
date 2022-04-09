package Appointment;

import org.junit.jupiter.api.*;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppointmentServiceTest {
    private AppointmentService newService;

    //SETUP AND TEARDOWN FUNCTIONS
    @BeforeEach
    void setUp() throws ParseException {
        newService = new AppointmentService();
        newService.addNewAppt("06/01/2025", "This is a description.");
    }

    @AfterEach
    void tearDown() {
        newService = null;
    }

    @Test
    @Order(1)
    @DisplayName("Appointment adding check.")
    void addNewAppt() throws ParseException {
        newService.addNewAppt("06/02/2025", "This is another description.");
        assertEquals("0",newService.getApptByIndex(0).getAppointmentID(),
                "Add new appointment failure.");
        assertEquals("1",newService.getApptByIndex(1).getAppointmentID(),
                "Add new appointment failure.");
    }

    @Test
    @Order(2)
    @DisplayName("Appointment delete check.")
    void deleteAppt() throws ParseException {
        newService.addNewAppt("06/02/2025", "This is another description.");
        //using four delete calls to ensure the appointment service is completely empty.
        //single run and "entire class" tests should pass.
        newService.deleteAppt("0");
        newService.deleteAppt("1");
        newService.deleteAppt("2");
        newService.deleteAppt("3");
        assertEquals(0, newService.getApptCount(), "Appointment delete failure.");
    }
}