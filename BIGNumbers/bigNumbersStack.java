/**
 *Project: Big_Numbers
 * @author: Justin Fulner
 * Date: November, 2018
 *
 * Description: This is the stack implementation used in the class BigNumbers, It contains operations for:
 *              push, pop, and returning the stack size.
 */

public class bigNumbersStack {
    private int[] stack;
    private int size; // keeps track of the current number of non-zero elements in the bigNumbersStack
    private int top;

    public bigNumbersStack() {
        stack = new int[10];
        size = 0;
        top = 0;
    }// end constructor

    public bigNumbersStack(int arraySize) {
        stack = new int[arraySize];
        size = 0;
        top = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }// end isEmpty

    // method returns the number of elements in the array the number of which is treated as the bigNumbersStack size
    public int getStackSize() {
        return size;
    }// end getStackSize

    public int pop() {
        int x;
        if (size == 0) {
            return 0;
        }
        else {
            x = stack[--top];
            size--;
            return x;
        }
    }//end pop

    public boolean push(int x) {
        if (top == stack.length)
            return false;
        else {
            stack[top] = x;
            top++;
            size++;
            return true;
        }
    }//end push

}//end class
