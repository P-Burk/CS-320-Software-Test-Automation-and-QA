package Contact;

import com.sun.source.tree.NewArrayTree;

public class Driver {
    public static void main(String[] args) {
        Contact contact1 = new Contact("This", "is", "111-222-3333-77", "test");
        Contact contact2 = new Contact("John", "Snow", "1234567890", "123 Fake St.");
        System.out.println(contact1.getContactNum());
        System.out.println(contact1.getContactID());

    }
}
