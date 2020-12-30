//Doubly-linked list, tail pointer, not circular, contains doubles
public class DoublyLinkedList {
    private DoubleListNode head,
                           current, //traversal pointer
                           tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    public void printList() {
        System.out.print("Head > ");
        if (isEmpty()) {
            System.out.println("null < Tail\n");
        }
        else if (isSingleton()) {
            System.out.println(head.data + " < Tail(doubly-linked)");
        }
        else {
            current = head;
            while (current.next != null) {
                System.out.print(current.data + " > ");
                current = current.next;
            }
            System.out.println(current.data + " < Tail (doubly-linked)");
        }
    }//end printList

    public void printListBackwards() {
        System.out.print("Tail > ");
        if (isEmpty()) {
            System.out.println("null\n");
        }
        else if (isSingleton()) {
            System.out.println(tail.data + " (doubly-linked)");
        }
        else {
            head.previous = null;
            current = tail;
            while (current.previous != null) {
                System.out.print(current.data + " > ");
                current = current.previous;

            }
            System.out.println(head.data + " < Head (doubly-linked)");
        }
    }//end printListBackwards

    public void clear() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("Operation success, list is now empty");
    }//end clear

    public boolean isSorted() {
        boolean sorted = true;
        if (head == null) {
            sorted = true;
        }
        else {
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

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        else {
            return false;
        }
    }//end isEmpty

    public boolean isSingleton() {
        if (size == 1) {
            return true;
        }
        else {
            return false;
        }
    }//end isSingleton
    public void insertAtHead(double newData) {
        DoubleListNode temp = new DoubleListNode(newData,null,null);
        if (isEmpty()) {
            head = temp;
            tail = temp;
        }
        else {
            temp.next = head;
            head.previous = temp;
            head = temp;
        }
        size++;
    }//end insertAtHead

    public void insertAtTail(double newData) {
        DoubleListNode newNode = new DoubleListNode(newData,null,null);
        if(isEmpty()) {
            insertAtHead(newData);
        }
        else if (isSingleton()) {
            head.next = newNode;
            newNode.previous = head;
            tail = newNode;
            size++;
        }
        else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    //inserts a node at the a user defined position
    public void insertByPosition(int position, double newData) {
        DoubleListNode newNode = new DoubleListNode(newData,null,null);
        int i = 0;
        if (isEmpty() && position == 1) {
            insertAtHead(newData);
        }
        else if (isSingleton() && position == 1) {
            insertAtHead(newData);
        }
        else if (position >= 1 && position < size + 2) {
            current = head;
            while (current.next != null && i < position - 2) {
                current = current.next;
                i++;
            }
            if(current.next == null) {
                insertAtTail(newData);
            }

            else {
                newNode.previous = current;
                newNode.next = current.next;
                current.next.previous = newNode;
                current.next = newNode;
                size++;
            }
        }
        else {
            System.out.println("Operation failed, specified position does not exist");
        }
    }//end insertByPosition

    public void insertInOrder(double newData) {
        DoubleListNode newNode = new DoubleListNode(newData,null,null);
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
                if(current.next == null) {
                    insertAtTail(newData);
                }
                else {
                    newNode.previous = current;
                    newNode.next = current.next;
                    current.next.previous = newNode;
                    current.next = newNode;
                    size++;
                }
            }
        }
        else if (!isSorted()) {
            System.out.println("Operation failed, list is not sorted");
        }

    }//end insertInOrder

    public void deleteHead() {
        if(isEmpty()) {
            System.out.println("Operation success, list is empty");
        }
        else if (isSingleton()) {
            clear();
        }
        else {
            head = head.next;
            head.previous = null;
            size--;
        }
    }//end deleteHead

    public void deleteTail() {
        if (isEmpty() || isSingleton()) {
            clear();
        }
        else {
            tail = tail.previous;
            tail.next = null;
            size--;
        }
    }//end deleteTail

    //-----------------------------------------------------------------------
    private class DoubleListNode { //nested class node
        private double data;
        private DoubleListNode next,
                               previous;

        private DoubleListNode(double data,DoubleListNode previous,DoubleListNode next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }
}
