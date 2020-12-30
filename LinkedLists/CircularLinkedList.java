import java.util.ArrayList;

//singly-linked, circular, containing Strings, Tail pointer, no head pointer
public class CircularLinkedList {
    private ListNode current,
                     tail;
    private int size;

    public CircularLinkedList() {
        tail = null;
        size = 0;
    }
    public void printList() {
        System.out.print("Head > ");
        if (isEmpty()) {
            System.out.println("null\n");
        }
        else if (isSingleton()) {
            System.out.println(tail.data + " (Singly-linked,circular)");
        }
        else {
            current = tail.next;
            while (current != tail) {
                System.out.print(current.data + " > ");
                current = current.next;
            }
            System.out.println(tail.data + " (Singly-linked, circular)");
            System.out.println();
        }
    }//end printlist

    public boolean isEmpty() {
        if (size == 0) {
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
    }//end is singleton

    public void clear() {
        tail = null;
        size = 0;
        System.out.println("Operation success, list is empty");
    }//end clear

    public void insertAtTail(String newData) {
        ListNode newNode = new ListNode(newData,null);
        if (isEmpty()) {
            tail = newNode;
            tail.next = tail;
        }
        else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }//end insertAtTail

    public void printStringsLessThanX(int userLength) {
        System.out.println("All strings less than " + userLength);
        if (isEmpty()) {
            System.out.println("Operation failed, list is empty");
        }
        else {
            current = tail.next;
            while (current != tail) {
                if (current.data.length() < userLength) {
                    System.out.println(current.data);
                }
                current = current.next;
            }
            if (current.data.length() < userLength) {
                System.out.println(current.data);
            }
        }
    }// end printStringsLessThanX

    public void findMaximum() {
        ArrayList<String> maximums = new ArrayList<>();
        String max = "";
        if (isEmpty()) {
            System.out.println("Operation failed, list is empty");
        }
        else if (isSingleton()) {
            System.out.println("Maximum: " + tail.data);
        }
        else {
            max = tail.data;
            current = tail.next;
            while (current != tail) {
                if (current.data.length() == max.length()) {
                    maximums.add(current.data);
                }
                else if (max.length() < current.data.length()) {
                    maximums.clear();
                    max = current.data;
                    maximums.add(current.data);
                }
                current = current.next;
            }
            if (max.equals(tail.data)) {
                maximums.add(max);
            }
            else{}
        }
        System.out.println("Maximum(s): " + maximums + "\n");
    }//end findMaximum

    public void findMinimum() {
        ArrayList<String> minimums = new ArrayList<>();
        String min = "";
        if (isEmpty()) {
            System.out.println("Operation failed, list is empty");
        }
        else if (isSingleton()) {
            System.out.println("Minimum: " + tail.data);
        }
        else {
            min = tail.data;
            current = tail.next;
            while (current != tail) {
                if (current.data.length() == min.length()) {
                    minimums.add(current.data);
                }
                else if (min.length() > current.data.length()) {
                    minimums.clear();
                    min = current.data;
                    minimums.add(current.data);
                }
                current = current.next;
            }
            if (min.equals(tail.data)) {
                minimums.add(min);
            }
            else {}
        }
        System.out.println("Minimum(s): " + minimums + "\n");
    }//end find minimum

    public void insertAtFront(String newData) { //without duplication
        if (isEmpty()) {
            tail = new ListNode(newData,null);
            tail.setNext(tail);
        }
        else {
            ListNode newest = new ListNode(newData,tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }//end insertAtFront

    public boolean isSorted() {
        boolean sorted = true;
        if(isEmpty() || isSingleton()) {
            sorted = true;
        }
        else {
            current = tail.next;
            while (current != tail) {
                if (current.data.compareTo(current.next.data) <= 0) {
                }
                else if (current.data.compareTo(current.next.data) > 0) {
                    sorted = false;
                }
                current = current.next;
            }
        }
        return sorted;
    }//end isSorted

    public boolean duplicateExists(String newData) {
        int numberOfDuplicates = 0;
        boolean itExists = true;
        if (isEmpty()) {
            itExists = false;
        }
        else if(isSingleton()) {
            if (!newData.equals(tail.data)) {
                itExists = false;
            }
        }
        else if (size > 1){
            current = tail.next;
            while (current != tail) {
                if (current.data.equals(newData)) {
                    numberOfDuplicates++;
                }
                else if (tail.data.equals(newData)){
                    numberOfDuplicates++;
                }
                current = current.next;
            }
            if(numberOfDuplicates > 0) {
                itExists = true;
            }
            else {
                itExists = false;
            }
        }
        return itExists;
    }//endDuplicateExists

    //-----------------------------------------------------------------------
    private class ListNode { //nested class node
        private String data;
        private ListNode next;

        private ListNode(String data, ListNode next) {
            this.data = data;
            this.next = next;
        }
        private ListNode getNext() {
            return next;
        }
        private void setNext(ListNode next) {
            this.next = next;
        }
    }
}
