package Han.BearsAndFish;
/**
 * Project: Bears and Fish
 * @author: Justin Fulner
 * Date: September, 2018
 * Inputs/outputs: All data is handled through user interaction, no external files.
 * Assumptions/Limitations:
 *
 * Description: This program will simulate a river ecosystem filled with bears and fish. It will feature an array filled
 *              with an unspecified number of both animals (decided by user). The program will move the animals around
 *              the array at random based on certain conditions: Bears eat fish if they land on the same element of the
 *              array as the fish. If an animal attempts to move to an element with another animal of the same
 *              species; both animals will remain where they are and a new animal of that type will be created in a,
 *              randomly selected, empty element.
 */
import java.util.*;


public class Driver {
    private Scanner scan;
    private Animal[] river;
    private int riverLength;
    private int bearCount;
    private int fishCount;
    private int iterationCounter;

    public Driver() {
        bearCount = 0;
        fishCount = 0;
        iterationCounter = 0;
        scan = new Scanner(System.in);
    }//end constructor

    public void introduction() {
        System.out.println("\nHello User," +
                "\nThis program will simulate a river ecosystem that contains bears and fish.\n");
        System.out.println();
    }//end method

    //Initializes river size, number of bears, and number of fish from user input
    public void initialize() {

        boolean reset = true;
        int userInput;
        int filledSlots;

        System.out.println("First, let's determine how many times you want to iterate.");
        iterationCounter = scan.nextInt();
        System.out.println();

         do {
             System.out.println("Please specify how many slots you want your river to have. (Min: 5, Max: 50)");
             userInput = scan.nextInt();
             if (userInput >= 5 && userInput <= 50) {
                 riverLength = userInput;

                 do {
                     System.out.println("Now, How many bears would you like? (cannot exceed river size)");
                     userInput = scan.nextInt();
                     if (userInput <= riverLength) {
                         bearCount = userInput;
                         filledSlots = bearCount;

                         do {
                             System.out.println("Now, how many fish would you like? (Available Slots: "
                                     + (riverLength - bearCount) + ")");
                             userInput = scan.nextInt();
                             if ((userInput + filledSlots) <= riverLength) {
                                 fishCount = userInput;
                                 reset = false;

                                 createRiver(fishCount, bearCount);
                             }
                             else{
                                 reset = true;
                             }
                         }while (reset);
                         reset = false;
                     }
                 }while (reset);
                 reset = false;
             }
         } while(reset);
    }//end method

    //creates river and populates with bears and fish
    public void createRiver(int fishNumber, int bearNumber) {
        river = new Animal[riverLength];
        int bearCounter = 0;
        int fishCounter = 0;

        for (int i = 0; i < river.length; i++) {
            if (bearCounter <= bearNumber -1) {
                bearCounter++;
                river[i] = new Bear();
            }
            else if (fishCounter <= fishNumber -1) {
                fishCounter++;
                river[i] = new Fish();
            }
        }
        shuffleRiver(river);
    }//end method

    //shuffles river animals for random positioning
    public void shuffleRiver(Animal[] river) {
        Random randGen = new Random();
        int randomPosition;
        Animal temp;
        for (int i = 0; i < river.length; i ++) {
            randomPosition = randGen.nextInt(river.length);
            temp = river[i];
            river[i] = river[randomPosition];
            river[randomPosition] = temp;
        }
        printRiver(river);
    }//end method

    //prints a representation of the ecosystem to the console
    public void printRiver(Animal[] river) {
        System.out.println();

        for (int i = 0; i < riverLength; i ++) {
            if (river[i] == null) {
                System.out.print("(" + i + ") ");
            }
            else if (river[i]instanceof Bear) {
                System.out.print(river[i].AnimalID() + " ");
            }
            else if (river[i]instanceof Fish) {
                System.out.print(river[i].AnimalID() + " ");
            }
        }
        System.out.println();
    }//end method

    //updates animal positions within the river as it sweeps
    //If a 0 is rolled, the animal doesn't move. If a 1 is rolled, the animal moves left.
    //If a 2 is rolled, the animal moves right.
    public void updatePosition() {
        Random randMove = new Random();
        int selection;
        Animal animalHolder;

        for (int index = 0; index < riverLength; index++) {
            selection = randMove.nextInt(3);
            animalHolder = river[index];
            river[index] = null;

            if (animalHolder == null) {
                System.out.print("");
            }
            else if (selection == 0) {
                river[index] = animalHolder;
                System.out.println(river[index].AnimalID() + " did not move.");
            }
            else if (animalHolder instanceof Bear) {
                if (selection == 1) {
                    bearGoesLeft(index, animalHolder);
                } else if (selection == 2) {
                    bearGoesRight(index, animalHolder);
                }
            }
            else if (animalHolder instanceof Fish) {
                if (selection == 1) {
                    fishGoesLeft(index, animalHolder);
                } else if (selection == 2) {
                    fishGoesRight(index, animalHolder);
                }
            }
        }
    }//end method

    //if the bear rolls a left case
    //checks if the bear is at the front or not
    public void bearGoesLeft(int index,Animal container) {
        Animal fishHolder;
        if (index - 1 >= 0) {//not at the front of the river
            if (river[index - 1] == null) {
                river[index - 1] = container;
                System.out.println(river[index -1].AnimalID() + " moved left.");
            }
            else if (river[index - 1]instanceof Fish) {
                fishHolder = river[index -1];
                river[index - 1] = container;
                System.out.println(river[index -1].AnimalID() +
                        " ate " + fishHolder.AnimalID() + " and moved left.");
                fishCount--;
            }
            else if (river[index - 1]instanceof Bear) {
                river[index] = container;
                System.out.println(river[index].AnimalID()+
                        " mated with " + river[index -1].AnimalID() + " and stayed put.");
                if (bearCount < (riverLength - fishCount)) {
                    addNewBear(river);
                    bearCount++;
                }
                else if (bearCount == river.length) {
                    System.out.println("Mating failed to because river is full.");
                }
            }
        }
        else {//front of the river
            if (river[riverLength - 1] == null) {
                river[riverLength - 1] = container;
                System.out.println(river[riverLength - 1].AnimalID() + " moved left.");
            }
            else if (river[riverLength - 1]instanceof Fish) {
                fishHolder = river[riverLength - 1];
                river[riverLength - 1] = container;
                System.out.println(river[riverLength - 1].AnimalID() +
                        " ate " + fishHolder.AnimalID() + " and moved left.");
                fishCount--;
            }
            else if (river[riverLength - 1]instanceof Bear) {
                river[index] = container;
                System.out.println(river[0].AnimalID() +
                        " mated with " + river[riverLength - 1].AnimalID() + " and stayed put.");
                if (bearCount < (riverLength - fishCount)) {
                    addNewBear(river);
                    bearCount++;
                }
                else if (bearCount == river.length) {
                    System.out.println("Mating failed because river is full.");
                }
            }
        }
    }//end method

    //if the bear rolls a right case
    //checks whether or not the bear is at the end
    public void bearGoesRight(int index, Animal container) {
        Animal fishHolder;
        if (index + 1 <= riverLength - 1) {//not at river's end
            if (river[index + 1] == null) {
                river[index + 1] = container;
                System.out.println(river[index + 1].AnimalID() + " moved right.");
            }
            else if (river[index + 1]instanceof Fish) {
                fishHolder = river[index + 1];
                river[index + 1] = container;
                System.out.println(river[index +1].AnimalID() +
                        " ate " + fishHolder.AnimalID() + " and moved right.");
                fishCount--;
            }
            else if (river[index + 1]instanceof Bear) {
                river[index] = container;
                System.out.println(river[index].AnimalID() +
                        " mated with " + river[index +1].AnimalID() + " and stayed put.");
                if (bearCount < (riverLength - fishCount)) {
                    addNewBear(river);
                    bearCount++;
                }
                else if (bearCount == river.length) {
                    System.out.println("Mating failed because river is full");
                }
            }
        }
        else {//at river's end
            if (river[0] == null) {
                river[0] = container;
                System.out.println(river[0].AnimalID() + " moved right.");
            }
            else if (river[0]instanceof Fish) {
                fishHolder = river[0];
                river[0] = container;
                System.out.println(river[0].AnimalID()  +
                        " ate " + fishHolder.AnimalID() + " and moved right.");
                fishCount--;
            }
            else if (river[0]instanceof Bear) {
                river[index] = container;
                System.out.println(river[riverLength - 1].AnimalID()  +
                        " mated with " + river[0].AnimalID()  + " and stayed put.");
                if (bearCount < (riverLength - fishCount)) {
                    addNewBear(river);
                    bearCount++;
                }
                else if (bearCount == riverLength) {
                    System.out.println("Mating failed because river is full.");
                }
            }
        }
    }//end method

    public void fishGoesLeft(int index, Animal container) {
        if (index - 1 >= 0) {// not at river's front
            if (river[index - 1] == null) {
                river[index - 1] = container;
                System.out.println(river[index - 1].AnimalID() + " moved left.");
            }
            else if(river[index - 1]instanceof Bear) {
                System.out.println(container.AnimalID() + " moved left and was " +
                        "eaten by " + river[index - 1].AnimalID());
                fishCount--;
            }
            else if (river[index - 1]instanceof Fish) {
                river[index] = container;
                System.out.println(river[index].AnimalID() + " mated with " + river[index-1].AnimalID() +
                        " and stayed put.");
                if (fishCount < (riverLength - bearCount)) {
                    addNewFish(river);
                    fishCount++;
                }
                else if (fishCount == (riverLength - bearCount)) {
                    System.out.println("Mating failed because river is full.");
                }
            }
        }
        else {//at the front of the river
            if (river[riverLength - 1] == null) {
                river[riverLength - 1] = container;
                System.out.println(river[riverLength - 1].AnimalID() + " moved left.");
            }
            else if (river[riverLength - 1]instanceof Bear) {
                System.out.println(container.AnimalID() + " moved left and was " +
                        "eaten by " + river[riverLength - 1].AnimalID());
                fishCount--;
            }
            else if(river[riverLength - 1]instanceof Fish) {
                river[index] = container;
                System.out.println("F" + river[0].getAnimalIDNum() + " mated with "
                        + "F" + river[riverLength - 1].getAnimalIDNum() + " and stayed put.");
                if (fishCount < (riverLength - bearCount)) {
                    addNewFish(river);
                    fishCount++;
                }
                else if (fishCount == (riverLength - bearCount)) {
                    System.out.println("Mating failed because river is full.");
                }
            }
        }
    }//end method

    //if the fish rolls Right case
    //checks if the fish is at the river's end or not.
    public void fishGoesRight(int index, Animal container) {
        if (index + 1 <= riverLength - 1) {//if not at the river's end
            if (river[index + 1] == null) {
                river[index + 1] = container;
                System.out.println(river[index +1].AnimalID() + " moved right.");
            }
            else if (river[index + 1]instanceof Bear) {
                System.out.println(container.AnimalID() + " moved right and was " +
                        "eaten by " + river[index + 1].AnimalID());
                fishCount--;
            }
            else if(river[index + 1]instanceof Fish) {
                river[index] = container;
                System.out.println(river[index].AnimalID() + " mated with " + river[index +1].AnimalID() +
                        " and stayed put.");
                if (fishCount < (riverLength - bearCount)) {
                    addNewFish(river);
                    fishCount++;
                }
                else if (fishCount >= (riverLength - bearCount)) {
                    System.out.println("Mating failed because river is full.");
                }
            }
        }
        else {//if at the river's end
            if (river[0] == null) {
                river[0] = container;
                System.out.println(river[0].AnimalID() + " moved right.");
            }
            else if (river[0]instanceof Bear) {
                System.out.println(container.AnimalID() + " moved right and was " +
                        "eaten by " + river[0].AnimalID());
                fishCount--;
            }
            else if (river[0]instanceof Fish) {
                river[index] = container;
                System.out.println(river[riverLength - 1].AnimalID() + " mated with " + river[0].AnimalID() +
                        " and stayed put.");
                if (fishCount < (riverLength - bearCount)) {
                    addNewFish(river);
                    fishCount++;
                }
                else if (fishCount == (riverLength - bearCount)) {
                    System.out.println("Mating failed because river is full.");
                }
            }
        }
    }//end method

    //performs one cycle of simulation
    public void updateRiver() {
            int count = 0;
            boolean keep_going = true;
            Scanner yes_no = new Scanner(System.in);
            String polar;

            do {
                System.out.println();
                System.out.println("Would you like to keep going? Y/N");
                polar = yes_no.nextLine();
                System.out.println();

                if(polar.toUpperCase().charAt(0) == 'Y' && (count != iterationCounter) && (bearCount != riverLength)) {
                    System.out.println("Iteration# " + (count + 1) + "(shown below)\n");
                    count++;
                    updatePosition();
                    System.out.println();
                    System.out.println("Remaining population: Bears: " + bearCount + ", Fish: " + fishCount);
                    printRiver(river);
                }
                else if (polar.toUpperCase().charAt(0) == 'N') {
                    keep_going = false;
                }
                else if (bearCount == riverLength) {
                    System.out.println("River has filled with bears." +
                            "\nEcosystem unsustainable." +
                            "\nSimulation ending.");
                    keep_going = false;
                }
                else if (count == iterationCounter){
                    System.out.println("Specified number of iterations reached." +
                            "\nProgram Ending.");
                    keep_going = false;
                }
            }while(keep_going);
    }//end method

    //adds animal at a null element
    public void addNewBear(Animal[] river) {
        Random randgen = new Random();
        boolean loop_again = true;
        int randomHolder;
        do {
            randomHolder = randgen.nextInt(riverLength);
            if(river[randomHolder] == null) {
                river[randomHolder] = new Bear();
                System.out.println(river[randomHolder].AnimalID() + " added at " + randomHolder);
                loop_again = false;
            }
            else if (river[randomHolder] != null) {
                loop_again = true;
            }
        }while (loop_again);
    }//end method

    public void addNewFish(Animal[] river) {
        Random randgen = new Random();
        boolean loop_again = true;
        int randomHolder;
        do {
            randomHolder = randgen.nextInt(riverLength);
            if(river[randomHolder] == null) {
                river[randomHolder] = new Fish();
                System.out.println(river[randomHolder].AnimalID() + " added at " + randomHolder);
                loop_again = false;
            }
            else if (river[randomHolder] != null) {
                loop_again = true;
            }
        }while (loop_again);
    }//end method

    //closing message
    public void closing() {
        System.out.println("\nGoodBye.");
    }//end method

    public static void main(String[] args) {
        Driver drive = new Driver();

        drive.introduction();
        drive.initialize();
        drive.updateRiver();
        drive.closing();
    }//end method
}//end class
