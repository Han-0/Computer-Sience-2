package Han.BearsAndFish;

public class Bear extends Animal {
    private int bearIDNum;
    private static int count = 0;

    public Bear() {
        count = count + 1;
        this.bearIDNum = count;
    }
    public int getBearIDNum() {
        return this.bearIDNum;
    }
    public String AnimalID() {
        return "B" + getBearIDNum();
    }
}
