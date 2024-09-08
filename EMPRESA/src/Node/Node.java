package Node;

import contact.Contact;

public class Node {
	
    public Node next;
	public Contact contact;

    // Constructor
    public Node(Contact contact) {
        this.contact = contact;
        this.next = null;
    }
}
