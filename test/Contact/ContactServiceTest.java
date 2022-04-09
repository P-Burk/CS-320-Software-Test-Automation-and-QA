package Contact;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactServiceTest {
    private ContactService newContactService;
    private String contactID1;
    private String contactID2;

    //used for testing console print statements
    private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private final PrintStream originalPrint = System.out;

    //SETUP
    @BeforeEach
    void startService() {
        newContactService = new ContactService();
        newContactService.addNewContact("John", "Snow", "1112223333", "1010 Binary St.");
        contactID1 = newContactService.getContactByIndex(0).getContactID();
        newContactService.addNewContact("Arya", "Stark", "0009998888", "123 Fake Ln.");
        contactID2 = newContactService.getContactByIndex(1).getContactID();
    }

    @BeforeEach
    void printStreamSetUp() {
        System.setOut(new PrintStream(outStream));
    }

    //TEAR DOWN
    @AfterEach
    void printSteamTearDown() {
        System.setOut(originalPrint);
    }

    @AfterEach
    void clearService() {
        newContactService = null;
    }

    @Test
    @Order(1)
    @DisplayName("Check the adding of contacts to contact service.")
    void addNewContact() {
        assertEquals(newContactService.getContactByID(contactID1), newContactService.getContactByIndex(0),
                "Contact not added correctly.");
        assertEquals(newContactService.getContactByID(contactID2), newContactService.getContactByIndex(1),
                "Contact not added correctly.");
    }

    @Test
    @Order(2)
    @DisplayName("Check the deletion of contacts from contact service.")
    void deleteContact() {
        newContactService.deleteContact(contactID1);
        assertNull(newContactService.getContactByID(contactID1), "Contact not deleted correctly.");
    }


    @Test
    @Order(3)
    @DisplayName("Check first name updater.")
    void updateFirstName() {
        newContactService.updateFirstName(contactID1, "Tom");
        assertEquals("Tom", newContactService.getContactByID(contactID1).getFirstName(),
                "First name not updated correctly.");
    }

    @Test
    @Order(4)
    @DisplayName("Check last name updater.")
    void updateLastName() {
        newContactService.updateLastName(contactID1, "Stark");
        assertEquals("Stark", newContactService.getContactByID(contactID1).getLastName(),
                "Last name not updated correctly.");
    }

    @Test
    @Order(5)
    @DisplayName("Check phone number updater.")
    void updateNumber() {
        newContactService.updateNumber(contactID1, "1234567890");
        assertEquals("1234567890", newContactService.getContactByID(contactID1).getContactNum(),
                "Phone number not updated correctly.");
    }

    @Test
    @Order(6)
    @DisplayName("Check address updater.")
    void updateAddress() {
        newContactService.updateAddress(contactID1, "123 Fake St.");
        assertEquals("123 Fake St.", newContactService.getContactByID("10").getContactAddress(),
                "Address not updated correctly.");
    }


    @Test
    @Order(7)
    @DisplayName("Check all contacts display.")
    void displayAllContacts() {
        newContactService.displayAllContacts();
        assertEquals(String.format("""
                ID Number: %s; First Name: John; Last Name: Snow\r
                Phone #: 1112223333; Address: 1010 Binary St.\r
                ID Number: %s; First Name: Arya; Last Name: Stark\r
                Phone #: 0009998888; Address: 123 Fake Ln.\r
                """, contactID1, contactID2),
                outStream.toString(), "Printed output fails.");
    }
}