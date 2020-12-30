// singly-linked list, non-circular, tail pointer
public class LinkedList {
    private node head,
                 tail,
                 current;
    private int listSize;

    public LinkedList() {
        listSize = 0;
        head = null;
        tail = null;
    }

    // insert node at the tail of the list
    public void insert(int data) {
        node newNode = new node(data, null);
        if (listSize == 0) {
            head = new node(data, null);
            tail = head;
            listSize++;
        } else {
            tail.next = newNode;
            tail = newNode;
            listSize++;
        }
    }// end insert

    // clear list
    public void clear() {
        head = null;
        tail = null;
        listSize = 0;
    }// end clear

    // add up all the data stored in each node
    public void addData(int total) {
        current = head;
        while (current.next != null) {
            total = total + current.data;
            current = current.next;
        }
    }// end addData

    // search the list for a randomly given value and increase count each time it's found
    public void search(int value, int count) {
        current = head;
        while (current.next != null) {
            if (current.data == value) {
                count++;
            }
            current = current.next;
        }
    }// end search

    // Doubles the values in each node of the list
    public void doubleValues(int doubleValue) {
        current = head;
        while (current.next != null) {
            doubleValue = current.data + current.data;
            current.data = doubleValue;
            current = current.next;
        }
    }// end doubleValues
//------------------------------------------------------------------------------------------------------------------
    private class node {
        private int data;
        private node next;

        private node(int data, node next) {
            this.data = data;
            this.next = next;
        }
    }
}
