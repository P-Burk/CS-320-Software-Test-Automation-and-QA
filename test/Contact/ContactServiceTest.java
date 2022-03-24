package Contact;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactServiceTest {

    //These next three parts are used so that you don't have to make a new contact service and fill it
    //with testing contacts for every single JUnit test.

    //Part 1
    //initialize test list and a contact service.
    private final ArrayList<ContactService> testList = new ArrayList<>();
    ContactService newContactService = new ContactService();

    //Part 2
    //Adds two contacts to the contact service, then adds the service to the test list
    @BeforeEach
    public void startService() {
        newContactService.addNewContact("John", "Snow", "1112223333", "1010 Binary St.");
        newContactService.addNewContact("Arya", "Stark", "0009998888", "123 Fake Ln.");
        testList.add(newContactService);
    }

    //Part 3
    //delete the contact service after every test
    @AfterEach
    public void clearService() {
        testList.clear();
    }

    @Test
    @Order(1)
    @DisplayName("Check the adding of contacts to contact service.")
    void addNewContact() {
        assertEquals(testList.get(0).getContactByID("0"), testList.get(0).getContactByIndex(0),
                "Contact not added correctly.");
        assertEquals(testList.get(0).getContactByID("1"), testList.get(0).getContactByIndex(1),
                "Contact not added correctly.");
    }

    @Test
    @Order(2)
    @DisplayName("Check the deletion of contacts from contact service.")
    void deleteContact() {
        testList.get(0).deleteContact("0");
        assertNull(testList.get(0).getContactByID("0"), "Contact not deleted correctly.");
    }


    @Test
    @Order(3)
    @DisplayName("Check first name updater.")
    void updateFirstName() {
        testList.get(0).updateFirstName("4", "Tom");
        assertEquals("Tom", testList.get(0).getContactByID("4").getFirstName(),
                "First name not updated correctly.");
    }

    @Test
    @Order(4)
    @DisplayName("Check last name updater.")
    void updateLastName() {
        testList.get(0).updateLastName("6", "Stark");
        assertEquals("Stark", testList.get(0).getContactByID("6").getLastName(),
                "Last name not updated correctly.");
    }

    @Test
    @Order(5)
    @DisplayName("Check phone number updater.")
    void updateNumber() {
        testList.get(0).updateNumber("8", "1234567890");
        assertEquals("1234567890", testList.get(0).getContactByID("8").getContactNum(),
                "Phone number not updated correctly.");
    }

    @Test
    @Order(6)
    @DisplayName("Check address updater.")
    void updateAddress() {
        testList.get(0).updateAddress("10", "123 Fake St.");
        assertEquals("123 Fake St.", testList.get(0).getContactByID("10").getContactAddress(),
                "Address not updated correctly.");
    }


}