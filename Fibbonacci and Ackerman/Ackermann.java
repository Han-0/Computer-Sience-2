/**
 * Project: Fibonacci and Ackermann
 * @author: Justin Fulner
 * Date: November 2018
 */

public class Ackermann {
    private int[][] ackTable;
    public long callCount,
                tableAccesses,
                countYOutOfBounds,
                maxY;

    public Ackermann() {
        ackTable = new int[5][101];
    }

    public void clear() {
        for(int i = 0; i < ackTable.length; i++) {
            for (int j = 0; j < ackTable[i].length; j++){
                ackTable[i][j] = 0;
            }
        }
    }

    public int ackWithoutTable(int x, int y){
        callCount++;
        //System.out.println("ack (" + x + "," + y + ")");
        if (y > maxY)
            maxY = y;
        if (x == 0)
            return y + 1;
        if (y == 0)
            return ackWithoutTable(x - 1, 1);
        return ackWithoutTable(x - 1, ackWithoutTable(x, y - 1));
    }

    public int ackWithTable(int x, int y) {
        callCount++;
        if (y > maxY && y < ackTable[x].length) {
            tableAccesses++;
            maxY = y;
        }
        if (y > ackTable[x].length - 1) { // I don't see a better way to do this, if I call the other method,
                                          // then it just takes over with the operations and i get incorrect results
            countYOutOfBounds++;
            if (y > maxY)
                maxY = y;
            if (x == 0)
                return y + 1;
            if (y == 0)
                return ackWithTable(x - 1, 1);
            return  ackWithTable(x-1,ackWithTable(x,y-1));
        }
        else{
            tableAccesses++;
            if (ackTable[x][y] == 0) {
                if (x == 0) {
                    tableAccesses++;
                    return ackTable[x][y] = y + 1;
                }
                if (y == 0) {
                    tableAccesses++;
                    return ackTable[x][y] = ackWithTable(x - 1, 1);
                }
                tableAccesses++;
                return ackTable[x][y] = ackWithTable(x - 1, ackWithTable(x, y - 1));
            }
            tableAccesses++;
            return ackTable[x][y];
        }
    }
}
