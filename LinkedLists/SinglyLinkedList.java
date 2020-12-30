//Singly-linked, no tail-pointer, not circular, containing integers
public class SinglyLinkedList {
    private Node head,
                 current; //traversal pointer

    public SinglyLinkedList() {
        head = null;
    }//end constructor

    public void printList() {
        System.out.print("H > ");
        if (isEmpty()) {
            System.out.println("null\n");
        }
        else if (isSingleton()) {
            System.out.println(head.data + " (Singly-linked)\n");
        }
        else {
            current = head;
            while (current.next != null) {
                System.out.print(current.data + " > ");
                current = current.next;
            }
            System.out.println(current.data + " (Singly-linked)\n");
        }
    }//end printList

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        else {
            return false;
        }
    }//end isEmpty

    public boolean isSingleton() {
        if (head.next == null) {
            return true;
        }
        else {
            return false;
        }
    }//end isSingleton

    public void clearList() {
        head = null;
        System.out.println("Operation success, list is now empty");
    }//end clearList

    public boolean isSorted() {
        boolean sorted = true;
        if(head == null || head.next == null) {
            sorted = true;
        }
        else {// more than one node
            current = head;
            while (current.next != null) {
                if (current.data < current.next.data) {
                }
                else if (current.data > current.next.data) {
                    sorted = false;
                }
                current = current.next;
            }
        }
        return sorted;
    }//end isSorted

    public void insertAtHead(int newData) {
        if (isEmpty()) {
            head = new Node(newData,null);
        }
        else {
            Node temp = new Node(newData, null);
            temp.next = head;
            head = temp;
        }
    }//end insertAtHead

    public void insertAtTail(int newData) {
        Node temp = new Node(newData,null);
        if (isEmpty()) {
            insertAtHead(newData);
        }
        else if (isSingleton()) {
            head.next =temp;
        }
        else {
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
            current = temp;
        }
    }//end insertAtTail

    public void insertInOrder(int newData) {
        Node newNode = new Node(newData,null);
        if (isSorted()) {
            if (isEmpty()) {
                insertAtHead(newData);
            }
            else if (head.data >= newData){
                insertAtHead(newData);
            }
            else {
                current = head;
                while (current.next != null && current.next.data < newData) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }
        else if (!isSorted()) {
            System.out.println("Operation failed, list is not in sorted order.");
        }
    }//end insertInOrder

    public void deleteByValue(int userValue) {
        int numberOfOccurances = 0;
        if (isEmpty()) {
            System.out.println("Operation failed, value is not present in the list.");
        }
        else if (userValue == head.data) {
            head = head.next;
        }
        else {
            current = head;
            Node previous = null;
            while (current.next != null) {
                if (current.data == userValue) {
                    numberOfOccurances++;
                    previous.next = current.next;
                }
                previous = current;
                current = current.next;
            }
            if (current.data == userValue) {
                previous.next = null;
            }
            else if (numberOfOccurances == 0) {
                System.out.println("Operation failed, value is not present in the list.");
            }
        }
    }//end deleteByValue

    //-----------------------------------------------------------------------
    private class Node { //nested class node
        private int data;
        private Node next;

        private Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
