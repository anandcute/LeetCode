//Given the head of a linked list, the task is to find the middle.
//  For example, the middle of 1-> 2->3->4->5 is 3. 
// If there are two middle nodes (even count), return the second middle. 
// For example, middle of 1->2->3->4->5->6 is 4.

// Examples:

// Input: Linked list: 1->2->3->4->5
// Output: 3

// Explanation: The given linked list is 1->2->3->4->5 and its middle is 3.


public class MiddleOfLinkden {
    Node head;
    class Node{
        int data;
        Node next;
        Node(int value){
            data = value;
            next = null;
        }
    }
    // MiddleOfLinkden(int value){
    //     head = new Node(value);
    // }
    public void insert(int value){
        Node newnNode = new Node(value);
        if (head == null) {
            head = newnNode;
        }
        else{
            newnNode.next = head;
            head = newnNode;
        }
        
    }
    public int middleNum(Node root){
        Node slow = head;
        Node fast = head ;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    public static void main(String[] args) {
        MiddleOfLinkden mdl = new MiddleOfLinkden();
        mdl.insert(5);
        mdl.insert(4);
        mdl.insert(3);
        mdl.insert(2);
        mdl.insert(1);
        System.out.println(mdl.middleNum(mdl.head)); // Output: 3
    }
}