/**
 * Project: BST insert exercise
 * @Author: Gurka, Judith & Fulner, Justin
 * Date: November 2018
 * Inputs/Outputs: All data is handled via the console.
 * Assumptions/limitations: Program Assumes perfect user. (errors are not handled)
 *
 * Description: This is a rudimentary program that simulates inserting nodes into a Binary Search Tree data structure.
 *              It includes a nested node class and a main driver method. Data is handled via console. When the user
 *              has finished entering data, the nodes are output to the console.
 */

import java.util.Scanner;

public class BSTInsert {
    private BSTNode root;

    public BSTInsert() {
        root = null;
    }

    public void insertBST (int x) {
        // assume no duplicates
        if (root == null) {
            root = new BSTNode(null, x, null);
        }
        else {  // non-empty
            insertBST (root,x);
        }
    }

    private void insertBST (BSTNode ptr, int x) {
        if (x == ptr.data) {
            ptr.count++;
        }
        //left case
        if (x < ptr.data && ptr.leftChild == null) {
            ptr.leftChild = new BSTNode(null, x, null);
            return;
        }
        if (x < ptr.data && ptr.leftChild != null) {
            insertBST(ptr.leftChild, x);
            return;
        }
        //right case
        if (x > ptr.data && ptr.rightChild == null) {
            ptr.rightChild = new BSTNode(null, x, null);
            return;
        }
        if (x > ptr.data && ptr.rightChild != null) {
            insertBST(ptr.rightChild,x);
            return;
        }
    }
    public void printBST(){
        if (root == null){}
        else {
            printBST(root);
        }
    }
    private void printBST(BSTNode ptr) {
        if (ptr == null){}
        else {
            printBST(ptr.leftChild);
            System.out.println("data: [" + ptr.data + "] count: [" + ptr.count + "]");
            printBST(ptr.rightChild);
        }
    }

    public static void main(String[] args) {
        BSTInsert drive = new BSTInsert();
        Scanner scan = new Scanner(System.in);
        boolean loopAgain = true;
        int x;

        do {
            System.out.println("Please enter a number..." +
                    "\nEnter -1 to exit...");
            x = scan.nextInt();

            if (x != -1) {
                drive.insertBST(x);
                loopAgain = true;
            }
            else {
                loopAgain = false;
            }
        }while (loopAgain);
        System.out.println();
        drive.printBST();
    }
    //-----------------------------------------------------------------------
    private class BSTNode {
        private BSTNode rightChild,leftChild;
        private int data;
        private int count;

        private BSTNode(BSTNode rightChild, int data, BSTNode leftChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            count = 1;
        }
    }
}
