package ContaManager;

import ContactList.ContactList;
import contact.Contact;

public class ContactManager {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Remove Contact");
            System.out.println("4. List Contacts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    contactList.addContact(new Contact(name, phoneNumber, email));
                    System.out.println("Contact added.");
                    break;
                case 2:
                    System.out.print("Enter name or phone number to search: ");
                    String query = scanner.nextLine();
                    Contact contact = contactList.searchContact(query);
                    if (contact != null) {
                        System.out.println("Contact found: " + contact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter name or phone number to remove: ");
                    String removeQuery = scanner.nextLine();
                    boolean removed = contactList.removeContact(removeQuery);
                    if (removed) {
                        System.out.println("Contact removed.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    System.out.println("Listing all contacts:");
                    contactList.listContacts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
