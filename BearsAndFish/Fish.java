package Han.BearsAndFish;

public class Fish extends Animal {
    private int fishIDNum;
    private static int count = 0;

    public Fish () {
        count = count + 1;
        this.fishIDNum = count;
    }
    public int getFishIDNum() {
        return this.fishIDNum;
    }
    public String AnimalID() {
        return "F" + getFishIDNum();
    }
}
