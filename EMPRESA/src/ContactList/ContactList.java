package ContactList;

import Node.Node;
import contact.Contact;

public class ContactList {
    private Node head;

    public ContactList() {
        this.head = null;
    }

    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Contact searchContact(String query) {
        Node current = head;
        while (current != null) {
            if (current.contact.getName().equalsIgnoreCase(query) || current.contact.getPhoneNumber().equals(query)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }

    public boolean removeContact(String query) {
        if (head == null) return false;

        if (head.contact.getName().equalsIgnoreCase(query) || head.contact.getPhoneNumber().equals(query)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.contact.getName().equalsIgnoreCase(query) || current.next.contact.getPhoneNumber().equals(query)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void listContacts() {
        Node current = head;
        while (current != null) {
            System.out.println(current.contact);
            current = current.next;
        }
    }
}
