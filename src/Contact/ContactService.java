/*
 * Class: CS-320-T4514 Software Test Automation & QA
 * Instructor: Dr. Angel Cross, DIT, MMIS
 * Assignment: 3-2 Milestone: Contact Service
 * Student: Preston Burkhardt
 * Date: 19 March 2022
 */

package Contact;

import java.util.ArrayList;
import java.util.Objects;

public class ContactService {
    private final ArrayList<Contact> contactServiceList = new ArrayList<>();

    //CONSTRUCTORS
    public ContactService(){}

    /**
     * Creates a new contact and adds it to contactServiceList arraylist.
     *
     * @param firstName contact's first name.
     * @param lastName contact's last name.
     * @param Number contact's phone number.
     * @param Address contact's street address.
     */
    public void addNewContact(String firstName, String lastName, String Number, String Address) {
        Contact newContact = new Contact(firstName, lastName, Number, Address);
        contactServiceList.add(newContact);
    }

    /**
     * Deletes a specific contact from the contactService arraylist.
     *
     * @param contactID contact's ID number that you wish to delete.
     */
    public void deleteContact(String contactID) {
        for (Contact contact : contactServiceList) {
            if (Objects.equals(contactID, contact.getContactID())) {
                contactServiceList.remove(contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    /**
     * Iterates through contactService arraylist and prints each contact's information.
     * Used for testing/debug purposes only.
     */
    public void displayAllContacts() {
        for (Contact contact :
                contactServiceList) {
            System.out.println("ID Number: " + contact.getContactID() + "; First Name: " +
                    contact.getFirstName() + "; Last Name: " + contact.getLastName());
            System.out.println("Phone #: " + contact.getContactNum() + "; Address: " + contact.getContactAddress());
        }
    }

    /**
     * Update a contact's first name per contact ID.
     *
     * @param contactID this is the contact's ID that you wish to update.
     * @param newName this is the updated first name for the contact.
     */
    public void updateFirstName(String contactID, String newName) {
        for (Contact contact : contactServiceList) {
            if (Objects.equals(contactID, contact.getContactID())) {
                contact.setFirstName(newName);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    /**
     * Update a contact's last name per contact ID.
     *
     * @param contactID this is the contact's ID that you wish to update.
     * @param newName this is the updated last name for the contact.
     */
    public void updateLastName(String contactID, String newName) {
        for (Contact contact : contactServiceList) {
            if (Objects.equals(contactID, contact.getContactID())) {
                contact.setLastName(newName);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    /**
     * Update a contact's phone number per contact ID.
     *
     * @param contactID this is the contact's ID that you wish to update.
     * @param newNumber this is the updated phone number for the contact.
     */
    public void updateNumber(String contactID, String newNumber) {
        for (Contact contact : contactServiceList) {
            if (Objects.equals(contactID, contact.getContactID())) {
                contact.setContactNum(newNumber);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    /**
     * Update a contact's address per contact ID.
     *
     * @param contactID this is the contact's ID that you wish to update.
     * @param newAddress this is the updated first name for the contact.
     */
    public void updateAddress(String contactID, String newAddress) {
        for (Contact contact : contactServiceList) {
            if (Objects.equals(contactID, contact.getContactID())) {
                contact.setContactAddress(newAddress);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    /**
     * Returns a contact by contact ID. Used for testing.
     *
     * @param contactID this is the contact's ID number.
     */
    public Contact getContactByID(String contactID) {
        for (Contact contact : contactServiceList) {
            if (contactID.equals(contact.getContactID())) {
                return contact;
            }
        }
        return null;
    }

    public Contact getContactByIndex(int indexNum) {
        return contactServiceList.get(indexNum);
    }
}
