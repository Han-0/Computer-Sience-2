/**
 * Project: Linked Lists
 * @author: Justin Fulner
 * Date: September, 2018
 * Inputs/outputs: All data is handled through user interaction
 * Assumptions/limitations: Program assumes a "perfect user" (errors are not handled)
 * References and Resources:
 *      1. Data Structures and Algorithms in java,
 *         by Goodrich, Tamassia, and GoldWasser, chapter 3
 *      2. Course notes
 *      3. Dinesh Varyani; YouTube series on Data structures and Algorithms in Java
 *
 * Description: This program utilizes 3 types of linked lists and contains various functions that have to do with
 *              storage and output of the data types within. Linked lists used are: Singly-linked, doubly-linked, and
 *              circular.
 */

import java.util.Scanner;

public class linkedListDriver {
    private Scanner stringScanner;
    private Scanner scan;
    private boolean go_again;

    public linkedListDriver() {
        stringScanner = new Scanner(System.in);
        scan = new Scanner(System.in);
        go_again = true;
    }

    public void topLevelMenu() {
        int userSelection;
        System.out.println("Pick a list type:\n" +
                           "\t1. singly-linked, no tail reference, non-circular, Integers\n" +
                           "\t2. doubly-linked, tail reference, non-circular, Doubles\n" +
                           "\t3. singly-linked, tail reference, circular, Strings\n" +
                           "\t4. exit the program\n");
        do {
            userSelection = scan.nextInt();

            if (userSelection == 1) {
                singlyLinkedMenuOperations();
            }
            else if (userSelection == 2) {
                doublyLinkedOperations();
            }
            else if (userSelection == 3) {
                circularOperations();
            }
            else if (userSelection == 4) {
                System.out.println("Goodbye.");
                go_again = false;
            }
        }while(go_again);
    }

    public void singlyLinkedMenu() {
        System.out.println("Type 1 operations:\n" +
                           "\t1. build a list\n" +
                           "\t2. clear the list\n" +
                           "\t3. check if the list is sorted\n" +
                           "\t4. insert at head\n" +
                           "\t5. insert at tail\n" +
                           "\t6. insert in order\n" +
                           "\t7. delete by value\n" +
                           "\t8. return to top-level menu");
    }//end singlyLinkedMenu

    public void singlyLinkedMenuOperations() {
        SinglyLinkedList SLL = new SinglyLinkedList();
        int newValue;
        SLL.printList();
        singlyLinkedMenu();

        do {
            System.out.println("Choose an operation");
            int operation = scan.nextInt();

            if(operation == 1) {
                boolean yes = true;
                do {
                    System.out.println("Enter Y to start/continue building\n" +
                            "Enter N to stop");
                    String polar = stringScanner.nextLine();
                    if (polar.toUpperCase().charAt(0) == 'Y') {
                        System.out.println("Enter a value for storage");
                        newValue = scan.nextInt();
                        SLL.insertAtTail(newValue);
                    }
                    else if (polar.toUpperCase().charAt(0) == 'N') {
                        yes = false;
                    }
                }while(yes);
                SLL.printList();
                System.out.println();
                singlyLinkedMenu();
            }
            else if (operation == 2) {
                SLL.clearList();
                SLL.printList();
                System.out.println();
                singlyLinkedMenu();
            }
            else if (operation == 3) {
                if(SLL.isSorted()) {
                    System.out.println("List is in sorted order");
                }
                else if (!SLL.isSorted()) {
                    System.out.println("List is not in sorted order");
                }
                SLL.printList();
                System.out.println();
                singlyLinkedMenu();
            }
            else if (operation == 4) {
                System.out.println("Enter a value for storage");
                newValue = scan.nextInt();
                SLL.insertAtHead(newValue);
                SLL.printList();
                System.out.println();
                singlyLinkedMenu();
            }
            else if (operation == 5) {
                System.out.println("Enter a value for storage");
                newValue = scan.nextInt();
                SLL.insertAtTail(newValue);
                SLL.printList();
                System.out.println();
                singlyLinkedMenu();
            }
            else if (operation == 6) {
                System.out.println("Enter a value for storage");
                newValue = scan.nextInt();
                SLL.insertInOrder(newValue);
                SLL.printList();
                System.out.println();
                singlyLinkedMenu();
            }
            else if (operation == 7) {
                System.out.println("Enter a value to delete");
                int deleteThisValue = scan.nextInt();
                SLL.deleteByValue(deleteThisValue);
                SLL.printList();
                System.out.println();
                singlyLinkedMenu();
            }
            else if (operation == 8) {
                topLevelMenu();
                go_again = false;
            }
        }while (go_again);
    }//end singlyLinked operations

    public void doublyLinkedMenu() {
        System.out.println("Type 2 operations:\n" +
                "\t1. build a list\n" +
                "\t2. clear the list\n" +
                "\t3. check if the list is sorted\n" +
                "\t4. insert at head\n" +
                "\t5. insert at tail\n" +
                "\t6. insert by position\n" +
                "\t7. insert in order\n" +
                "\t8. delete head node\n" +
                "\t9. delete tail node\n" +
                "\t10. print in reverse\n" +
                "\t11. return to top-level menu");
    }//end doublyLinkedMenu

    public void doublyLinkedOperations() {
        DoublyLinkedList DLL = new DoublyLinkedList();
        double newData;
        DLL.printList();
        doublyLinkedMenu();

        do {
            System.out.println("Choose an operation");
            int operation = scan.nextInt();

            if (operation == 1) {
                boolean yes = true;
                do {
                    System.out.println("Enter Y to start/continue building\n" +
                            "Enter N to stop");
                    String polar = stringScanner.nextLine();
                    if (polar.toUpperCase().charAt(0) == 'Y') {
                        System.out.println("Enter a value for storage.");
                        newData = scan.nextDouble();
                        DLL.insertAtTail(newData);
                    }
                    else if (polar.toUpperCase().charAt(0) == 'N') {
                        yes = false;
                    }
                }while(yes);
                DLL.printList();
                System.out.println();
                doublyLinkedMenu();
            }
            else if (operation == 2) {
                DLL.clear();
                DLL.printList();
                System.out.println();
            }
            else if (operation == 3) {
                if(DLL.isSorted()) {
                    System.out.println("List is sorted");
                }
                else if(!DLL.isSorted()){
                    System.out.println("List is not sorted");
                }
                DLL.printList();
                System.out.println();
                doublyLinkedMenu();
            }
            else if (operation == 4) {
                System.out.println("Enter a value for storage");
                newData = scan.nextDouble();
                DLL.insertAtHead(newData);
                DLL.printList();
                System.out.println();
                doublyLinkedMenu();
            }
            else if (operation == 5) {
                System.out.println("Enter a value for storage");
                newData = scan.nextDouble();
                DLL.insertAtTail(newData);
                DLL.printList();
                System.out.println();
                doublyLinkedMenu();
            }
            else if (operation == 6) {
                System.out.println("Enter a position for insertion");
                int position = scan.nextInt();
                System.out.println("Enter a value for storage");
                newData = scan.nextDouble();
                DLL.insertByPosition(position,newData);
                DLL.printList();
                System.out.println();
                doublyLinkedMenu();
            }
            else if (operation == 7) {
                System.out.println("Enter a value for storage");
                newData = scan.nextDouble();
                DLL.insertInOrder(newData);
                DLL.printList();
                System.out.println();
                doublyLinkedMenu();
            }
            else if (operation == 8) {
                DLL.deleteHead();
                DLL.printList();
                System.out.println();
                doublyLinkedMenu();
            }
            else if (operation == 9) {
                DLL.deleteTail();
                DLL.printList();
                System.out.println();
                doublyLinkedMenu();
            }
            else if (operation == 10) {
                DLL.printListBackwards();
                DLL.printList();
                System.out.println();
                doublyLinkedMenu();
            }
            else if (operation == 11) {
                topLevelMenu();
                go_again = false;
            }
        }while(go_again);
    }

    public void circularMenu() {
        System.out.println("Type 3 operations:\n" +
                "\t1. build a list\n" +
                "\t2. clear the list\n" +
                "\t3. check if the list is sorted\n" +
                "\t4. insert at head\n" +
                "\t5. insert at tail\n" +
                "\t6. print all strings of size less than user input length\n" +
                "\t7. output minimum and maximum length strings\n" +
                "\t8. insert at front with no duplicates\n" +
                "\t9. return to top-level menu");
    }//end doublyLinkedMenu

    public void circularOperations() {
        CircularLinkedList CLL = new CircularLinkedList();
        Scanner stringScanner = new Scanner(System.in);
        String newString;
        CLL.printList();
        circularMenu();

        do {
            System.out.println("Choose an operation\n");
            int operation = scan.nextInt();

            if (operation == 1) {
                boolean yes = true;
                do {
                    System.out.println("Enter Y to start/continue building\n" +
                                       "Enter N to stop");
                    String polar = stringScanner.nextLine();
                    if (polar.toUpperCase().charAt(0) == 'Y') {
                        System.out.println("Enter a string");
                        newString = stringScanner.nextLine();
                            CLL.insertAtTail(newString);
                    }
                    else if (polar.toUpperCase().charAt(0) == 'N') {
                        yes = false;
                    }
                }while(yes);
                CLL.printList();
                System.out.println();
                circularMenu();
            }
            else if (operation == 2) {
                System.out.println("Clear the list");
                CLL.clear();
                CLL.printList();
                System.out.println();
                circularMenu();
            }
            else if (operation == 3) {
                if(CLL.isSorted()) {
                    System.out.println("List is sorted");
                }
                else if (!CLL.isSorted()) {
                    System.out.println("List is not sorted");
                }
                CLL.printList();
                System.out.println();
                circularMenu();
            }
            else if (operation == 4) {
                System.out.println("Enter a string");
                newString = stringScanner.nextLine();
                CLL.insertAtFront(newString);
                CLL.printList();
                System.out.println();
                circularMenu();
            }
            else if (operation == 5) {
                System.out.println("Enter a string");
                newString = stringScanner.nextLine();
                CLL.insertAtTail(newString);
                CLL.printList();
                System.out.println();
                circularMenu();
            }
            else if (operation == 6) {
                System.out.println("Enter a string size");
                int size = scan.nextInt();
                CLL.printStringsLessThanX(size);
                System.out.println();
                CLL.printList();
                System.out.println();
                circularMenu();
            }
            else if (operation == 7) {
                CLL.findMaximum();
                CLL.findMinimum();
                CLL.printList();
                System.out.println();
                circularMenu();
            }
            else if (operation == 8) {
                System.out.println("Enter a string");
                newString = stringScanner.nextLine();
                if (!CLL.duplicateExists(newString)) {
                    CLL.insertAtFront(newString);
                }
                else if (CLL.duplicateExists(newString)) {
                    System.out.println();
                }
                CLL.printList();
                System.out.println();
                circularMenu();
            }
            else if (operation == 9) {
                topLevelMenu();
                go_again = false;
            }
        }while(go_again);
    }

    public static void main(String[] args) {
        linkedListDriver driver = new linkedListDriver();

        driver.topLevelMenu();
    }
}
