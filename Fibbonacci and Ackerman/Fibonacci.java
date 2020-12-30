/**
 * Project: Fibonacci and Ackermann
 * @author: Justin Fulner
 * Date: November 2018
 */

public class Fibonacci {
    private int[] fibTable;
    public long callCount;
    public int  callCountWithTable,
                tableAccesses;

    public Fibonacci() {
         fibTable = new int[31];
         fibTable[1] = 1;
         fibTable[2] = 1;
    }

    public int fibWithoutTable(int n) {
        callCount++;
        if (n < 3)
            return 1;
        return fibWithoutTable(n - 1) + fibWithoutTable(n - 2);
    }

    //clears the fibTable
    public void clear() {
        for (int i = 3; i < fibTable.length; i++) {
            fibTable[i] = 0;
        }
    }

    public int fibWithTable(int n) {
        tableAccesses++;
        callCountWithTable++;
        if (n == 1) {
            tableAccesses++;
            return fibTable[1];
        }
        if (n == 2){
            tableAccesses++;
            return fibTable[2];
        }
        if (fibTable[n] == 0) {
            tableAccesses ++;
            return fibTable[n] = fibWithTable(n-1) + fibWithTable(n-2);
        }
        tableAccesses++;
        return fibTable[n];
    }
}
