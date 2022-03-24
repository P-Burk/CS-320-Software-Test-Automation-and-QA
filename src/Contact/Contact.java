/*
 * Class: CS-320-T4514 Software Test Automation & QA
 * Instructor: Dr. Angel Cross, DIT, MMIS
 * Assignment: 3-2 Milestone: Contact Service
 * Student: Preston Burkhardt
 * Date: 19 March 2022
 */

package Contact;

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String contactNum;
    private String contactAddress;
    private static final AtomicLong idGenerator = new AtomicLong();

    //CONSTRUCTORS
    /**
     * CONSTRUCTOR for the Contact class
     *
     * @param firstName  this contact's first name.
     *                   Cannot be NULL. Cannot be blank. Cannot exceed 10 characters.
     * @param lastName this is a contact's last name.
     *                 Cannot be NULL. Cannot be blank. Cannot exceed 10 characters.
     * @param Number this is a contact's phone number.
     *               Cannot be NULL. Cannot be blank. Must be exactly 10 digits.
     * @param Address this is a contact's street address.
     *                Cannot be NULL. Cannot be blank. Cannot exceed 30 characters.
     */
    public Contact(String firstName, String lastName, String Number, String Address) {
        if (firstName == null || firstName.isBlank()) {     //checks for null or blank values
            this.firstName = "NoName";
        } else if (firstName.length() > 10) {               //checks for string length
            this.firstName = firstName.substring(0, 10);
        } else {
            this.firstName = firstName;
        }

        if (lastName == null || lastName.isBlank()) {       //checks for null or blank values
            this.lastName = "NoName";
        } else if (lastName.length() > 10) {                //checks for string length
            this.lastName = lastName.substring(0, 10);
        } else {
            this.lastName = lastName;
        }

        if (Number == null || Number.isBlank()) {           //checks for null or blank values
            this.contactNum = "0000000000";
        } else if (Number.contains("-")) {
            Number = Number.replace("-", ""); //strips out dashes commonly found in phone numbers
            if (Number.length() != 10) this.contactNum = "0000000000";
        } else if (Number.length() != 10){                  //checks for string length
            this.contactNum = "0000000000";
        } else {
            this.contactNum = Number;
        }

        if (Address == null || Address.isBlank()) {         //checks for null or blank values
            this.contactAddress = "NoAddress";
        } else if (Address.length() > 30)
            this.contactAddress = Address.substring(0, 30); //checks for string length
        else {
            this.contactAddress = Address;
        }

        //contactID is unique and cannot be changed once generated
        this.contactID = String.valueOf(idGenerator.getAndIncrement());
    }

    //SETTERS
    /**
     * Set the first name of the contact.
     * @param firstName this contact's first name.
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {     //checks for null or blank values
            this.firstName = "NoName";
        } else if (firstName.length() > 10) {               //checks for string length
            this.firstName = firstName.substring(0, 10);
        } else {
            this.firstName = firstName;
        }
    }
    /**
     * Set the last name of the contact.
     * @param lastName this is a contact's last name.
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.isBlank()) {       //checks for null or blank values
            this.lastName = "NoName";
        } else if (lastName.length() > 10) {                //checks for string length
            this.lastName = lastName.substring(0, 10);
        } else {
            this.lastName = lastName;
        }
    }
    /**
     * Set the phone number name of the contact.
     * @param num this is a contact's phone number.
     */
    public void setContactNum(String num) {
        if (num == null || num.isBlank()) {           //checks for null or blank values
            this.contactNum = "0000000000";
        } else if (num.contains("-")) {
            num = num.replace("-", ""); //strips out dashes commonly found in phone numbers
            if (num.length() != 10) {                    //checks for string length
                this.contactNum = "0000000000";
            } else {
                this.contactNum = num;
            }
        } else if (num.length() != 10) {                    //checks for string length
            this.contactNum = "0000000000";
        } else {
            this.contactNum = num;
        }
    }
    /**
     * Set the address of the contact.
     * @param Address this is a contact's street address.
     */
    public void setContactAddress(String Address) {
        if (Address == null || Address.isBlank()) {         //checks for null or blank values
            this.contactAddress = "NoAddress";
        } else if (Address.length() > 30)
            this.contactAddress = Address.substring(0, 30); //checks for string length
        else {
            this.contactAddress = Address;
        }
    }

    //GETTERS
    /**
     * @return the contact's first name.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @return the contact's last name.
     */
    public String getLastName() {
        return  this.lastName;
    }

    /**
     * @return the contact's phone number.
     */
    public String getContactNum() {
        return this.contactNum;
    }

    /**
     * @return the contact's address.
     */
    public String getContactAddress() {
        return this.contactAddress;
    }
    
    /**
     * @return the contact's ID number.
     */
    public String getContactID() {
        return this.contactID;
    }
}
