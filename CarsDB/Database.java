/**
 * Project: Car DB
 * @Author: Justin Fulner
 * Date: December, 2018
 * Inputs/Outputs: Data is read from a text file, user interaction is handled via
 *                 the console, and operations are output to another text file.
 *
 * Associated classes: DatabaseBST, CarList, Car.
 *
 * Assumptions/Limitations: Input data is assumed to be in a specific syntax.
 *
 * Description: This program takes a list of automobiles; each consisting of make, model, year, color, license, and
 *              and builds a binary search tree Database out of it. From this database, a user is able to perform
 *              various search operations based on the details of the vehicles in the input file.
 */

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Database {
    private DatabaseBST carDB;
    private FileOutputStream out;
    public static PrintWriter write;
    private int carCount;

    public Database() {
        carDB = new DatabaseBST();
        carCount = 0;
        try {
            out = new FileOutputStream("Fulner_results.txt");
            write = new PrintWriter(out,true);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }//end constructor

    //method reads data from an external text file and inserts into a database
    public void readFromFile(String fileName) {

        try {
            FileInputStream file = new FileInputStream(fileName + ".txt");
            Scanner reader = new Scanner(file);
            String line;

            while(reader.hasNext()) {
                line = reader.nextLine();
                Car newCar = addCar(line);
                carDB.insert(newCar.getMake(),newCar);
                carCount++;
            }
            write.println("Car DB");
            write.println("Justin Fulner");
            write.println("Number of cars in the database: " + carCount);
            write.println("------------------------------------------------------------------------");

            carDB.printTree();
            write.println("------------------------------------------------------------------------");

            System.out.println("The database has been built successfully.");
            System.out.println();

            file.close();
            reader.close();

        }catch(IOException e) {
            System.out.println("Error: File not found\n" +
                    "Either the file name you entered is incorrect,\n" +
                    "or the file is not in the same directory as this program!");
        }
    }//end readFromFile

    //drives user interaction
    public void userInteraction() {
        Scanner scan = new Scanner(System.in);
        Scanner queryScanner = new Scanner(System.in);
        String fileName;
        String item;
        int selection;
        boolean validChoice = true;

        printGreetingMessage();
        System.out.println("Before we get started,\nplease enter the name of the file you wish to work from.");
        fileName = scan.nextLine();
        readFromFile(fileName);
        try {
            try {
                do {
                    printUserMenu();
                    selection = scan.nextInt();
                    carDB.setCount(0);

                    if (selection == 1) {
                        System.out.println("Please enter the make you would like to search for.");
                        item = queryScanner.nextLine();
                        write.println("Query results for " + item + ".");
                        if (carDB.findItem(item)) {
                            write.println("Showing all cars manufactured by " + item + ".");
                            write.println();
                            carDB.getItem(item);
                            write.println("Number of cars found: " + carDB.getCount());
                            write.println();
                            write.println("------------------------------------------------------------------------");

                            /*System.out.println("Showing all cars manufactured by " + item + ".");
                            System.out.println();
                            carDB.getItem(item);
                            System.out.println("Number of cars found: " + carDB.getCount());
                            System.out.println();*/
                        } else {
                            /*System.out.println("No cars matched the query.");
                            System.out.println();*/

                            write.println("No cars matched the query.");
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        }
                    } else if (selection == 2) {
                        System.out.println("Please enter the model you would like to search for.");
                        item = queryScanner.nextLine();
                        write.println("Query results for " + item + ".");
                        if (carDB.findItem(item)) {
                            /*
                            System.out.println("Showing all " + item + "s");
                            System.out.println();
                            carDB.getItem(item);
                            System.out.println("Number of cars found: " + carDB.getCount());
                            System.out.println();
                            */

                            write.println("Showing all " + item + "s");
                            write.println();
                            carDB.getItem(item);
                            write.println("Number of cars found: " + carDB.getCount());
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        } else {
                            /*
                            System.out.println("No cars matched the query.");
                            System.out.println();
                            */

                            write.println("No cars matched the query.");
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        }
                    } else if (selection == 3) {
                        System.out.println("Please enter the color you would like to search for.");
                        item = queryScanner.nextLine();
                        write.println("Query results for " + item + ".");
                        if (carDB.findItem(item)) {
                            /*
                            System.out.println("Showing all cars that are " + item + ".");
                            System.out.println();
                            carDB.getItem(item);
                            System.out.println("Number of cars found: " + carDB.getCount());
                            System.out.println();
                            */

                            write.println("Showing all cars that are " + item + ".");
                            write.println();
                            carDB.getItem(item);
                            write.println("Number of cars found: " + carDB.getCount());
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        } else {
                            /*
                            System.out.println("No cars matched the query.");
                            System.out.println();
                            */
                            write.println("No cars matched the query.");
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        }
                    } else if (selection == 4) {
                        System.out.println("Please enter the year you would like to search for.");
                        item = queryScanner.nextLine();
                        write.println("Query results for " + item + ".");
                        if (carDB.findItem(item)) {
                            /*
                            System.out.println("Showing all cars with a model year of " + item + ".");
                            System.out.println();
                            carDB.getItem(item);
                            System.out.println("Number of cars found: " + carDB.getCount());
                            System.out.println();
                            */

                            write.println("Showing all cars with a model year of " + item + ".");
                            write.println();
                            carDB.getItem(item);
                            write.println("Number of cars found: " + carDB.getCount());
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        } else {
                            /*
                            System.out.println("No cars matched the query.");
                            System.out.println();
                            */

                            write.println("No cars matched the query.");
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        }
                    } else if (selection == 5) {
                        System.out.println("Please enter the license you would like to search for.");
                        item = queryScanner.nextLine();
                        write.println("Query results for " + item + ".");
                        if (carDB.findItem(item)) {
                            /*
                            System.out.println("Showing car that matches the license " + item + ".");
                            System.out.println();
                            carDB.getItem(item);
                            System.out.println("Number of cars found: " + carDB.getCount());
                            System.out.println();
                            */

                            write.println("Showing car that matches the license " + item + ".");
                            write.println();
                            carDB.getItem(item);
                            write.println("Number of cars found: " + carDB.getCount());
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        } else {
                            /*
                            System.out.println("Car not found.");
                            System.out.println();
                            */

                            write.println("Car not found.");
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        }
                    } else if (selection == 6) {
                        System.out.println("Please enter the make you would like to search for.");
                        item = queryScanner.nextLine();
                        System.out.println("Please enter the color you would like to search for.");
                        String item2 = queryScanner.nextLine();
                        write.println("Query results for " + item + " and " + item2 + ".");
                        if (carDB.findMakeAndColor(item, item2)) {
                            /*
                            System.out.println("Showing all cars manufactured by " + item + " that are " + item2 + ".");
                            System.out.println();
                            carDB.getMakeAndColor(item, item2);
                            System.out.println("Number of cars found: " + carDB.getCount());
                            System.out.println();
                            */

                            write.println("Showing all cars manufactured by " + item + " that are " + item2 + ".");
                            write.println();
                            carDB.getMakeAndColor(item, item2);
                            write.println("Number of cars found: " + carDB.getCount());
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        } else {
                            /*
                            System.out.println("No cars matched the query.");
                            System.out.println();
                            */

                            write.println("No cars matched the query.");
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        }
                    } else if (selection == 7) {
                        System.out.println("Please enter the part of the license you would like to search for.");
                        item = queryScanner.nextLine();
                        write.println("Query results for " + item + ".");
                        if (carDB.findLicenseCombo(item, item.toUpperCase())) {
                            /*
                            System.out.println("Showing all cars that match " + item + ".");
                            System.out.println();
                            carDB.getLicenseCombo(item, item.toUpperCase());
                            System.out.println("Number of cars found: " + carDB.getCount());
                            System.out.println();
                            */

                            write.println("Showing all cars that match " + item + ".");
                            write.println();
                            carDB.getLicenseCombo(item, item.toUpperCase());
                            write.println("Number of cars found: " + carDB.getCount());
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        } else {
                            /*
                            System.out.println("No cars matched the query.");
                            System.out.println();
                            */

                            write.println("No cars matched the query.");
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        }
                    } else if (selection == 8) {
                        System.out.println("Please enter the color you would like to search for.");
                        item = queryScanner.nextLine();
                        System.out.println("Please enter the part of the license you would like to search for.");
                        String item2 = queryScanner.nextLine();
                        write.println("Query results for " + item + " and " + item2 + ".");
                        if (carDB.findColorAndLicense(item, item2, item2.toUpperCase())) {
                            /*
                            System.out.println("Showing all cars manufactured by " + item + " that are " + item2 + ".");
                            System.out.println();
                            carDB.getColorAndLicense(item, item2, item2.toUpperCase());
                            System.out.println("Number of cars found: " + carDB.getCount());
                            System.out.println();
                            */

                            write.println("Showing all cars that are " + item + " that match " + item2 + ".");
                            write.println();
                            carDB.getColorAndLicense(item, item2, item2.toUpperCase());
                            write.println("Number of cars found: " + carDB.getCount());
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        } else {
                            /*
                            System.out.println("No cars matched the query.");
                            System.out.println();
                            */

                            write.println("No cars matched the query.");
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        }
                    } else if (selection == 9) {
                        System.out.println("Please enter the start year.");
                        Scanner sc = new Scanner(System.in);
                        int year = sc.nextInt();
                        System.out.println("Please enter the end year.");
                        int year2 = sc.nextInt();
                        write.println("Query results for " + year + " and " + year2 + ".");
                        if (carDB.findRange(year, year2)) {
                            /*
                            System.out.println("Showing all cars manufactured between " + year + " and " + year2 + ".");
                            System.out.println();
                            carDB.getRange(year, year2);
                            System.out.println("Number of cars found: " + carDB.getCount());
                            System.out.println();
                            */

                            write.println("Showing all cars manufactured between " + year + " and " + year2 + ".");
                            write.println();
                            carDB.getRange(year, year2);
                            write.println("Number of cars found: " + carDB.getCount());
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        } else {
                            /*
                            System.out.println("No cars matched the query.");
                            System.out.println();
                            */

                            write.println("No cars matched the query.");
                            write.println();
                            write.println("------------------------------------------------------------------------");
                        }
                    } else if (selection == 0) {
                        printExitMessage();
                        validChoice = false;
                    } else {
                        System.out.println("Please select a valid menu option.");
                        System.out.println();
                    }

                } while (validChoice);

                out.close();
                write.close();
            } catch (InputMismatchException e) {
                userInteraction();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }//end userInteraction

    public void printUserMenu() {
        System.out.println("Please select an operation:\n" +
                "\t1. Find cars of a specified make\n" +
                "\t2. Find cars of a specified model\n" +
                "\t3. Find cars of a specified color\n" +
                "\t4. Find cars of a specified year\n" +
                "\t5. Find a car with a specific license\n" +
                "\t6. Find cars with a specified make and color\n" +
                "\t7. Find cars with licenses containing <...>\n" +
                "\t8. Find all cars with a specified color and license containing <...>\n" +
                "\t9. Find all cars in a specified date range\n" +
                "\t0. Exit\n" +
                "If you would like to start over with a new file, press any letter key.");
    }//end method

    public void printGreetingMessage() {
        System.out.println("Hello,\n" +
                "This program will allow you to feed in a list of cars consisting of: Make, Model, Year, Color, and " +
                "the License number. From this list, it will construct a database.");
        System.out.println();
    }//end printGreetingMessage

    public void printExitMessage() {
        System.out.println("Thank you for using this program, to see your query results,\n" +
                "please see the output file titled 'Fulner_Results'.");
    }//end printExitMessage

    //Method splits strings into keys which have commas as delimiters
    public Car addCar(String s) {
        String[] arr = new String[5];
        int index = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ',') {
                i++;
                index++;
            }

            if (arr[index] == null) {
                if (s.charAt(i) == ' ') {}
                else
                    arr[index] = "" + s.charAt(i);
            }
            else {
                if(s.charAt(i) == ' ') {}
                else
                    arr[index] += s.charAt(i);
            }
        }
        return new Car(arr[0],arr[1],arr[2],arr[3],arr[4]);
    }//end addCar

    //method removes spaces ' ' and dashes '-' from license numbers
    public String parse(String s) {
        String parsedString = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' || s.charAt(i) == '-') {}
            else
                parsedString += s.charAt(i);
        }
        return parsedString;
    }//end parse

    public static void main(String[] args) {
        Database drive = new Database();
        drive.userInteraction();
    }
}