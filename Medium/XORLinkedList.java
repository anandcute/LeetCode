import java.util.ArrayList;



public class XORLinkedList {
    Node head;


    // Static Node class
    static class Node {
        int data;
        Node npx; // XORed address of the next and previous nodes

        // Constructor
        Node(int data) {
            this.data = data;
            this.npx = null;
        }
    }

    // Static insert method
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);  // Create a new node
        newNode.npx = head;  // Set the XOR of newNode as the current head (simplified for now)
        head = newNode;  // Set newNode as the new head
        return head;
    }

    // Static function to print the linked list
    static ArrayList<Integer> getList(Node head) {
        ArrayList<Integer> ans = new ArrayList<>();
        Node temp = head;

        // Traversing through the XOR Linked List
        while (temp != null) {
            ans.add(temp.data);
            temp = temp.npx;  // Moving to the next node
        }
        return ans;
    }



    public static void main(String[] args) {
        Node head = null;

        // Insert elements into the XOR Linked List
        head = insert(head, 9);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 7);
        head = insert(head, 3);
        head = insert(head, 10);

        // Print the list in forward direction
        ArrayList<Integer> list = getList(head);
        for (int data : list) {
            System.out.print(data + " ");  // Expected output: 10 3 7 4 5 9
        }
        System.out.println();
    }
}
