package Han.BearsAndFish;

public class Animal {
    private int animalIDNum;
    private static int count = 0;

    public Animal() {
        count = count +1;
        animalIDNum = 0;
    }
    public int getAnimalIDNum() {
        return animalIDNum;
    }
    public String AnimalID() {
        return "A" + getAnimalIDNum();
    }
}
