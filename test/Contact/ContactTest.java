package Contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    @DisplayName("First name setter. Cannot be NULL. Cannot be > 10 characters.")
    void setFirstName() {
        Contact aContact = new Contact("John", "Snow", "1112223333", "1010 Binary St.");
        aContact.setFirstName(null);
        assertNotNull(aContact.getFirstName(), "First name is NULL");
        aContact.setFirstName("This Is A Really Looooooong Name");
        assertEquals(10, aContact.getFirstName().length(), "First name is more than 10 characters");
    }

    @Test
    @DisplayName("Setting last name. Cannot be NULL. Cannot be > 10 characters.")
    void setLastName() {
        Contact aContact = new Contact("John", "Snow", "1112223333", "1010 Binary St.");
        aContact.setLastName(null);
        assertNotNull(aContact.getLastName(), "Last name is NULL");
        aContact.setLastName("This Is A Really Looooooong Name");
        assertEquals(10, aContact.getLastName().length(), "Last name is more than 10 characters");
    }

    @Test
    @DisplayName("Setting phone number. Cannot be NULL. Must be exactly 10 characters.")
    void setContactNum() {
        Contact aContact = new Contact("John", "Snow", "1112223333", "1010 Binary St.");
        aContact.setContactNum(null);
        assertNotNull(aContact.getContactNum(), "Phone number is NULL");
        aContact.setContactNum("1234");
        assertEquals(10, aContact.getContactNum().length(), "Phone number is NOT 10 characters");
        aContact.setContactNum("12345678901234567890");
        assertEquals(10, aContact.getContactNum().length(), "Phone number is NOT 10 characters");
        aContact.setContactNum("123-456-7890");
        assertEquals(10, aContact.getContactNum().length(), "Phone number is NOT 10 characters");
    }

    @Test
    @DisplayName("Setting Address. Cannot be NULL. Cannot be > 30 characters.")
    void setContactAddress() {
        Contact aContact = new Contact("John", "Snow", "1112223333", "1010 Binary St.");
        aContact.setContactAddress(null);
        assertNotNull(aContact.getContactAddress(), "Address is NULL");
        aContact.setContactAddress("This Is A Really Loooooooooooooooooooooooooooooooooooong Address");
        assertEquals(30, aContact.getContactAddress().length(), "Address is more than 30 characters");
    }

    @Test
    @DisplayName("Getting first name.")
    void getFirstName() {
        Contact aContact = new Contact("John", "Snow", "1112223333", "1010 Binary St.");
        assertEquals("John", aContact.getFirstName(), "First name not the same.");
    }

    @Test
    @DisplayName("Getting last name.")
    void getLastName() {
        Contact aContact = new Contact("John", "Snow", "1112223333", "1010 Binary St.");
        assertEquals("Snow", aContact.getLastName(), "Last name not the same.");
    }

    @Test
    @DisplayName("Getting phone number.")
    void getContactNum() {
        Contact aContact = new Contact("John", "Snow", "1112223333", "1010 Binary St.");
        assertEquals("1112223333", aContact.getContactNum(), "Phone number not the same.");
    }

    @Test
    @DisplayName("Getting address.")
    void getContactAddress() {
        Contact aContact = new Contact("John", "Snow", "1112223333", "1010 Binary St.");
        assertEquals("1010 Binary St.", aContact.getContactAddress(), "Address not the same.");
    }

    @Test
    @DisplayName("Getting contact ID number.")
    void getContactID() {
        Contact aContact = new Contact("John", "Snow", "1112223333", "1010 Binary St.");
        assertEquals("14", aContact.getContactID(), "Contact ID number not the same.");
    }

    @Test
    @DisplayName("Constructor null check.")
    void constructorNullCheck() {
        Contact aContact = new Contact(null, null, null, null);
        assertNotNull(aContact.getFirstName(), "First name is NULL");
        assertNotNull(aContact.getLastName(), "Last name is NULL");
        assertNotNull(aContact.getContactNum(), "Phone number is NULL");
        assertNotNull(aContact.getContactAddress(), "Address is NULL");
        assertNotNull(aContact.getContactID(), "Contact ID is NULL");
    }

    @Test
    @DisplayName("Constructor length check.")
    void constructorLengthCheck() {
        Contact aContact = new Contact("Really long long long name",
                "Really long long long name", "11122233334444555566666",
                "This Is A Really Loooooooooooooooooooooooooooooooooooong Address");
        assertEquals(10, aContact.getFirstName().length(), "First name is more than 10 characters");
        assertEquals(10, aContact.getLastName().length(), "Last name is more than 10 characters");
        assertEquals(10, aContact.getContactNum().length(), "Phone number is NOT 10 characters");
        assertEquals(30, aContact.getContactAddress().length(), "Address is more than 30 characters");
    }
}