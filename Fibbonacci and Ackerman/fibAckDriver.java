/**
 * Project: Fibonacci and Ackermann
 * @author: Justin Fulner
 * Date: November 2018
 * Input/Output: The program generates inputs automatically; Fibonacci is calculated in the range (1,30) inclusive
 *               Ackermann is calculated in the range (1,15) inclusive. The program generates two text files; one
 *               contains the results of the Fibonacci sequence, the other, contains results of the Ackermann Function.
 * Assumptions/Limitations: Both algorithms are limited to a set range of values. Neither algorithm calculates
 *                          negative numbers.
 *
 * Description: This program implements optimized and un-optimized versions of the Fibonacci sequence and the
 *              Ackermann Function. The purpose is to measure logical vs. computational complexity as well as the cost
 *              (O(n)) of each algorithm.
 */

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.text.DecimalFormat;

public class fibAckDriver {
    //private Scanner scan;
    private DecimalFormat formatter;
    private FileOutputStream fileO;
    private PrintWriter printW;

    public fibAckDriver() {
        //scan = new Scanner(System.in);
        formatter = new DecimalFormat();
        fileO = null;
        printW = null;
    }

    public static void main(String[] args) {
        fibAckDriver fibAck = new fibAckDriver();
        Fibonacci fib = new Fibonacci();
        Ackermann ack = new Ackermann();

        //Fibonacci
        try {
            fibAck.fileO = new FileOutputStream("Fib_results_Justin_Fulner.txt");
            fibAck.printW = new PrintWriter(fibAck.fileO,true);
            //System.out.println("Fibonacci Results\n");
            fibAck.printW.println("Justin Fulner");
            fibAck.printW.println("Fibonacci Results\n");
            fibAck.printW.println();
            for (int n = 1; n < 31; n++) {
/*                fib.callCount = 0;
                System.out.println("fib(" + n + ") = " + fibAck.formatter.format(fib.fibWithoutTable(n)));
                System.out.println("calls without table: " + fibAck.formatter.format(fib.callCount));
                fib.callCountWithTable = 0;
                fib.tableAccesses = 0;
                fib.fibWithTable(n);
                System.out.println("calls with table: " + fib.callCountWithTable);
                System.out.println("table look-ups: " + fib.tableAccesses + "\n");
*/
                fib.callCount = 0;
                fibAck.printW.println("fib(" + n + ") = " + fibAck.formatter.format(fib.fibWithoutTable(n)));
                fibAck.printW.println("calls without table: " + fibAck.formatter.format(fib.callCount));
                fib.callCountWithTable = 0;
                fib.tableAccesses = 0;
                fib.fibWithTable(n);
                fibAck.printW.println("calls with table: " + fib.callCountWithTable);
                fibAck.printW.println("table look-ups: " + fib.tableAccesses + "\n");
                fibAck.printW.println();
                fib.clear();
            }
            fibAck.printW.close();
            fibAck.fileO.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
/*
        //Ackermann
        //interactive testing
        int x;
        do {
            System.out.println("Enter an x value");
            x = scan.nextInt();
            System.out.println("enter a y value");
            int y = scan.nextInt();
            try {
                System.out.println("ack (" + ") = " + ack.ackWithoutTable(x, y));
                System.out.println("Calls without table: " + ack.callCount);
                ack.callCount = 0;
            }
            catch(StackOverflowError e) {
                System.out.println("Error: Ack(" + x + ","+ y + ") cannot be computed");
                System.out.println();
            }
        }while(x != -1);
*/
        try {
            fibAck.fileO = new FileOutputStream("Ack_results_Justin_Fulner.txt");
            fibAck.printW = new PrintWriter(fibAck.fileO, true);
            //System.out.println("Ackermann Results\n");
            fibAck.printW.println("Justin Fulner");
            fibAck.printW.println("Ackermann Results\n");
            fibAck.printW.println();
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 16; y++) {
                    try {
/*
                        ack.maxY = 0;
                        ack.callCount = 0;
                        System.out.println("ack (" + x + "," + y + ") = "
                                + fibAck.formatter.format(ack.ackWithoutTable(x, y)));
                        System.out.println("calls without table: " + fibAck.formatter.format(ack.callCount));
                        System.out.println("maximum value Y reached: " + fibAck.formatter.format(ack.maxY));
                        ack.tableAccesses = 0;
                        ack.countYOutOfBounds = 0;
                        ack.callCount = 0;
                        ack.ackWithTable(x, y);
                        System.out.println("calls with table: " + fibAck.formatter.format(ack.callCount));
                        System.out.println("table look-ups: " + fibAck.formatter.format(ack.tableAccesses));
                        System.out.println("times Y went out of bounds:   "
                                + fibAck.formatter.format(ack.countYOutOfBounds) + "\n");
*/
                        ack.maxY = 0;
                        ack.callCount = 0;
                        fibAck.printW.println("ack (" + x + "," + y + ") = "
                                + fibAck.formatter.format(ack.ackWithoutTable(x, y)));
                        fibAck.printW.println("calls without table: " + fibAck.formatter.format(ack.callCount));
                        fibAck.printW.println("maximum value Y reached: " + fibAck.formatter.format(ack.maxY));
                        ack.tableAccesses = 0;
                        ack.countYOutOfBounds = 0;
                        ack.callCount = 0;
                        fibAck.printW.println("ack (" + x + "," + y + ") = "
                                +  fibAck.formatter.format(ack.ackWithTable(x, y)));
                        fibAck.printW.println("calls with table: " + fibAck.formatter.format(ack.callCount));
                        fibAck.printW.println("table look-ups: " + fibAck.formatter.format(ack.tableAccesses));
                        fibAck.printW.println("times Y went out of bounds:   "
                                + fibAck.formatter.format(ack.countYOutOfBounds) + "\n");
                        fibAck.printW.println();

                    } catch (StackOverflowError e) {
                        /*
                        System.out.println("Error: Ack(" + x + "," + y + ") cannot be computed." +
                                "\nY values " + (y + 1) + " through 15, also cannot be computed.\n");
                        */
                        fibAck.printW.println("Error: Ack(" + x + "," + y + ") cannot be computed." +
                                "\nY values " + (y + 1) + " through 15, also cannot be computed.\n");
                        fibAck.printW.println();
                        y = 16;
                    }
                    ack.clear();
                }
            }
            fibAck.printW.close();
            fibAck.fileO.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
