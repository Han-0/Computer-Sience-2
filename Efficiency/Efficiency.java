import java.util.Random;
import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * @Authors: J. Gurka & Justin Fulner
 * Date: TBD
 *
 * Description: Compare ArrayList, array, and linked list for time efficiency in multiple operations.
 */
public class Efficiency {

    private ArrayList<Integer> list;
    private int[] array;
    private LinkedList LL;

    private Random rand;
    private DecimalFormat formatter;

    private long startTime, endTime;

    private final int SIZE = 1_000_000;
    private final int DATA_LIMIT = 5_000;
    private final int SIZE_MUILTIPLIER = 320;

    public Efficiency() {
        list = new ArrayList<>(SIZE);
        array = new int[SIZE];
        LL = new LinkedList();
        rand = new Random();
        formatter = new DecimalFormat();
    } // Efficiency constructor

    // tester method: call all tests
    public void tester() {

        System.out.println("Testing ArrayList vs. array vs. Linked list operation times.");
        System.out.println("data structure size: " + formatter.format(SIZE) + " elements");
        System.out.println("size multiplier: "  + SIZE_MUILTIPLIER);
        System.out.println("data range: " + "0 through " + (DATA_LIMIT - 1));

        System.out.println("\n fill test ...");
        fillTest();

        System.out.println("\n add test ...");
        addTest();

        System.out.println("\n search test ...");
        searchTest();

        System.out.println("\n double test ...");
        doubleTest();

        System.out.println("\n expansion test ...");
        expansionTest();
    } // tester

    // fillTest method: compare times to fill an ArrayList, array, and linked-list
    public void fillTest() {

        int i, j;

        //fill ArrayList
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i <= SIZE_MUILTIPLIER; i++) {
            for (j = 0; j < SIZE; j++) {
                list.add(rand.nextInt(DATA_LIMIT));
            }
            list.clear();
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    fill test, elapsed time, ArrayList = " + (endTime - startTime) + " milliseconds.");

        //fill array
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i < SIZE_MUILTIPLIER; i++) {
            for (j = 0; j < SIZE; j++) {
                array[j] = rand.nextInt(DATA_LIMIT);
            }
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    fill test, elapsed time, array = " + (endTime - startTime) + " milliseconds");

        //fill linked list
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i < SIZE_MUILTIPLIER; i++) {
            for (j = 0; j < SIZE; j++) {
                LL.insert(rand.nextInt(DATA_LIMIT));
            }
            LL.clear();
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    fill test, elapsed time, Linked list = " + (endTime - startTime) + " milliseconds");
    }// fillTest

    //addTest method: compare times to add up an ArrayList and an array
    public void addTest() {

        int total;
        int i, j;

        // (re)fill ArrayList
        startTime = (int) System.currentTimeMillis();
        for (i = 0; i < SIZE; i++) {
            list.add(rand.nextInt(DATA_LIMIT));
        }

        // (re)fill Linked list
        startTime = (int) System.currentTimeMillis();
        for (i = 0; i < SIZE; i++) {
            LL.insert(rand.nextInt(DATA_LIMIT));
        }

        // sum ArrayList
        total = 0;
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i < SIZE_MUILTIPLIER; i++) {
            for (j = 0; j < SIZE; j++) {
                total = total + list.get(j);
            }
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    add test, elapsed time, ArrayList = " + (endTime - startTime) + " milliseconds");

        // sum array
        total = 0;
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i < SIZE_MUILTIPLIER; i++) {
            for (j = 0; j < SIZE; j++) {
                total += array[j];
            }
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    add test, elapsed time, array = " + (endTime - startTime) + " milliseconds");

        // sum LinkedList
        total = 0;
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i < SIZE_MUILTIPLIER; i++) {
            LL.addData(total);
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    add test, elapsed time, Linked list = " + (endTime - startTime) + " milliseconds");
    } // addTest

    // searchTest method: compare times to search for a value in an ArrayList and an array
    public void searchTest() {
        int count, searchValue;
        int i, j;

        //search ArrayList
        count = 0;
        searchValue = rand.nextInt(DATA_LIMIT);
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i < SIZE_MUILTIPLIER; i++) {
            for (j = 0; j < SIZE; j++) {
                if (list.get(j) == searchValue) {
                    count++;
                }
            }
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    search test, elapsed time, ArrayList = " + (endTime - startTime) + " milliseconds");

        //search array
        count = 0;
        searchValue = rand.nextInt(DATA_LIMIT);
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i < SIZE_MUILTIPLIER; i++) {
            for (j = 0; j < SIZE; j++) {
                if (array[j] == searchValue) {
                    count++;
                }
            }
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    search test, elapsed time, array = " + (endTime - startTime) + " milliseconds");

        //search LinkedList
        count = 0;
        searchValue = rand.nextInt(DATA_LIMIT);
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i < SIZE_MUILTIPLIER; i++) {
            LL.search(searchValue, count);
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    search test, elapsed time, Linked list = " + (endTime - startTime) + " milliseconds");

    }// searchTest

    //doubleTest method: compare times to double all values in an ArrayList and an array
    public void doubleTest() {
        int i, j;
        int doubleValue;

        // double ArrayList
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i < SIZE_MUILTIPLIER; i ++) {
            for (j = 0; j < SIZE; j++) {
                doubleValue = list.get(j) + list.get(j);
                list.set(j, doubleValue);
            }
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    double test, elapsed time, ArrayList = " + (endTime - startTime) + " milliseconds");

        // double array
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i < SIZE_MUILTIPLIER; i++) {
            for (j = 0; j < SIZE; j++) {
                doubleValue = array[j] + array[j];
                array[j] = doubleValue;
            }
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    double test, elapsed time, array = " + (endTime - startTime) + " milliseconds");

        // double Linked List
        doubleValue = 0;
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i < SIZE_MUILTIPLIER; i++) {
            LL.doubleValues(doubleValue);
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    double test, elapsed time, Linked list = " + (endTime - startTime) + " milliseconds");
    }// doubleTest

    // expansionTest method: compare times to fill empty an empty ArrayList of SIZE and one that expands from
    // size 10
    public void expansionTest() {
        int i, j;
        ArrayList<Integer> expandingList = new ArrayList<>(10);

        list.clear();
        //fill ArrayList of size 1,000,000
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i <= SIZE_MUILTIPLIER; i++) {
            for (j = 0; j < SIZE; j++) {
                list.add(rand.nextInt(DATA_LIMIT));
            }
            list.clear();
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    fill 320,000,000 elements," +
                " elapsed time, ArrayList = " + (endTime - startTime) + " milliseconds.");

        //fill ArrayList starting at size 10
        startTime = (int) System.currentTimeMillis();
        for (i = 1; i <= SIZE_MUILTIPLIER; i++) {
            for (j = 0; j < SIZE; j++) {
                expandingList.add(rand.nextInt(DATA_LIMIT));
            }
            expandingList.clear();
        }
        endTime = (int) System.currentTimeMillis();
        System.out.println("    expand from 10" +
                ", elapsed time, ArrayList = " + (endTime - startTime) + " milliseconds.");

    }

    public static void main(String[] args) {
        Efficiency timeTest = new Efficiency();
        timeTest.tester();
    }
}
