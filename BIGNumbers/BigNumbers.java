/**
 * Project: BigNumbers
 * @Author: Justin Fulner
 * Date: November, 2018
 * Inputs/Outputs: Data is read from a text file and outputs to another text file.
 * Assumptions/Limitations: The program handles only non-negative integer values. Input File: correctly placed,
 *                          readable, not empty, and formatted correctly. Numbers have, at most, 25 digits.
 *                          Operations performed are limited to addition.
 *
 * Description: This program adds numbers together utilizing stacks to account for numbers that may be beyond
 *              the range of primitive data types.
 */
import java.io.*;
import java.util.ArrayList;

public class BigNumbers {
    private FileOutputStream fileIO;
    private PrintWriter writer;

    public BigNumbers() {
        try {
            fileIO = new FileOutputStream("Results.txt");
            writer = new PrintWriter(fileIO,true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //method reads data from external an external file
    //called by the main method
    public void readFromFile(String iFile) {
        String line;
        ArrayList<String> inputList = new ArrayList<>(); //list holds data taken from input file
        try {
            FileInputStream fileInput = new FileInputStream(iFile);
            DataInputStream dataStream = new DataInputStream(fileInput);
            BufferedReader reader = new BufferedReader(new InputStreamReader(dataStream));
            while ((line = reader.readLine()) != null) {
                inputList.add(line);
            }
            processData(inputList);
            fileIO.close();
            writer.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }//end readFromFile

    //method handles high level data processing
    //called by readFromFile
    public void processData(ArrayList<String> data) {
        String testAuthor;
        String testCase;
        String number1;
        String number2;
        String expectedAnswer;
        String answer;
        bigNumbersStack stack1;
        bigNumbersStack stack2;

        testAuthor = data.get(0);
        data.remove(0);

        try {
            writer.println("BIG NUMBERS");
            writer.println("Written by: Justin Fulner");
            writer.println("Test Plan by: " + testAuthor);
            writer.println();
        }catch(Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < data.size(); i++) {
            testCase = data.get(0);
            if (isZero(data.get(1)))
                number1 = "0";
            else
                number1 = data.get(1);
            stack1 = stackify(number1);
            number1 = addCommas(number1);

            if (isZero(data.get(2)))
                number2 = "0";
            else
                number2 = data.get(2);
            stack2 = stackify(number2);
            number2 = addCommas(number2);

            expectedAnswer = addCommas(data.get(3));
            answer = addNumbers(stack1,stack2);

            outputResults(testCase,number1,number2,expectedAnswer,answer);

            data.subList(0,4).clear();
        }
    }// end processData

    //method outputs data to a text file
    //called by process data
    public void outputResults(String test,String num1, String num2,String expectedAnswer,String answer){
        try {
            writer.println("Test case:         " + test);
            writer.println("First number:       " + num1);
            writer.println("Second number:     " + num2);
            writer.println("Expected answer:   " + expectedAnswer);
            writer.println("Calculated answer: " + answer);

            if (expectedAnswer.equals(answer))
                writer.println("Test passed");
            else
                writer.println("Test Failed");
            writer.println();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }//end outputResults

    //Method determines if a string consists of zeroes
    //called by processData
    public boolean isZero(String s) {
        int numberOfZeroes = 0;
        for (int i = s.length() -1; i >= 0; i--) {
            if (s.charAt(i) == '0')
                numberOfZeroes++;
        }
        if (numberOfZeroes == s.length())
            return true;
        else
            return false;
    }

    //method converts string characters to int primitives and adds them to a stack
    //called by processData
    public bigNumbersStack stackify(String s) {
        bigNumbersStack stack = new bigNumbersStack(30);
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i);
            int k = Character.getNumericValue(j);
            stack.push(k);
        }
        return stack;
    }//end stackify

    //method adds numbers together by utilizing stacks
    //called by processData
    public String addNumbers(bigNumbersStack stack1, bigNumbersStack stack2) {
        String answerString = "";
        int carryDigit = 0;
        int answer;
        int pushVal;
        bigNumbersStack answerStack = new bigNumbersStack(30);
        //stack 2 is greater
        if (stack2.getStackSize() > stack1.getStackSize()) {
            for (int i = stack2.getStackSize(); i > 0; i--) {
                answer = stack1.pop() + stack2.pop() + carryDigit;

                if (answer > 9) {
                    pushVal = answer % 10;
                    carryDigit = answer / 10;
                    answerStack.push(pushVal);

                    if (stack1.isEmpty() && stack2.isEmpty()) {
                        answerStack.push(carryDigit);
                    }
                } else {
                    carryDigit = 0;
                    answerStack.push(answer);
                }
            }
            while (!answerStack.isEmpty())
                answerString += answerStack.pop();

            return addCommas(answerString);
        }
        //stack 1 is greater
        if (stack1.getStackSize() > stack2.getStackSize()) {
            for (int i = stack1.getStackSize(); i > 0; i--) {
                answer = stack1.pop() + stack2.pop() + carryDigit;

                if (answer > 9) {
                    pushVal = answer % 10;
                    carryDigit = answer / 10;
                    answerStack.push(pushVal);

                    if (stack1.isEmpty() && stack2.isEmpty()) {
                        answerStack.push(carryDigit);
                    }
                } else {
                    carryDigit = 0;
                    answerStack.push(answer);
                }
            }
            while (!answerStack.isEmpty())
                answerString += answerStack.pop();

            return addCommas(answerString);
        }
        //equal size
        else{
            for (int i = stack1.getStackSize(); i > 0; i--) {
                answer = stack1.pop() + stack2.pop() + carryDigit;

                if (answer > 9) {
                    pushVal = answer % 10;
                    carryDigit = answer / 10;
                    answerStack.push(pushVal);

                    if (stack1.isEmpty() && stack2.isEmpty()) {
                        answerStack.push(carryDigit);
                    }
                } else {
                    carryDigit = 0;
                    answerStack.push(answer);
                }
            }
            while (!answerStack.isEmpty())
                answerString += answerStack.pop();

            return addCommas(answerString);
        }
    }//end addNumbers

    //this method adds commas to strings
    //However, output is reversed...
    //called by process data and addNumbers
    public String addCommas(String s) {
        String commaAnswer = "";
        int n = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            n++;
            commaAnswer += s.charAt(i);
            if (n % 3 == 0 && i > 0)
                commaAnswer += ",";
        }
        return reverseString(commaAnswer);
    }//end addCommas

    //this method reverses a string
    //used to correct the order created by addCommas
    //called by addCommas
    public String reverseString(String s) {
        String reversedString = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversedString += s.charAt(i);
        }
        return reversedString;
    }//end correctStrings

    public static void main(String[] args) {
        BigNumbers driver = new BigNumbers();
		String inputFile = args[0];

        driver.readFromFile(inputFile);

    }//end main
}//end class
