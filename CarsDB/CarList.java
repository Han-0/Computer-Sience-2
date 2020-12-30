/**
 * Project: Car DB
 * @Author: Justin Fulner
 * Date: December, 2018
 **/

public class CarList{
    private Database driver;
    private CarListNode head,current;
    private int size;
    private int count;

    public CarList() {
        head = null;
        size = 0;
        count = 0;
    }//end constructor

    public boolean isEmpty() {
        return size == 0;
    }//end isEmpty

    public boolean isSingleton() {
        return head.next == null;
    }//end isSingleton

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() { return count; }

    public void insertAtFront(Car newCar) {
        if (isEmpty()) {
            head = new CarListNode(newCar,null);
            size++;
        }
        else {
            CarListNode temp = new CarListNode(newCar, null);
            temp.next = head;
            head = temp;
            size++;
        }
    }//end insertAtFront

    public void printList() {
        if (isEmpty()) { }
        else if (isSingleton()) {
            /*
            System.out.println(head.data.toString());
            System.out.println();
            */
            driver.write.println(head.data.toString());
            driver.write.println();
        }
        else {
            current = head;
            while (current.next != null) {
                //System.out.println(current.data.toString());
                driver.write.println(current.data.toString());
                driver.write.println();
                current = current.next;
            }
            /*
            System.out.println(current.data.toString());
            System.out.println();
            */
            driver.write.println(current.data.toString());
            driver.write.println();
        }
    }//end printList

    //prints out a car if its license contains a given substring
    public void printLicenseMatch(String sub,String upperSub) {
        if (isEmpty()) {}
        if(isSingleton()) {
            if(head.data.getLicense().contains(sub) || head.data.getLicense().contains(upperSub)) {
                //System.out.println(head.data.toString());
                driver.write.println(head.data.toString());
                driver.write.println();
                count++;
            }
        }
        else {
            current = head;
            while (current.next != null) {
                if (current.data.getLicense().contains(sub) || current.data.getLicense().contains(upperSub)) {
                   //System.out.println(current.data.toString());
                    driver.write.println(current.data.toString());
                    driver.write.println();
                    count++;
                }
                current = current.next;
            }
            if (current.data.getLicense().contains(sub) || current.data.getLicense().contains(upperSub)) {
                //System.out.println(current.data.toString());
                driver.write.println(current.data.toString());
                driver.write.println();
                count++;
            }
        }
    }//end printLicenseMatch

    //attempts to find a match to a given substring
    public boolean findLicenseMatch(String sub, String upperSub){
        if (head == null)
            return false;
        else
            return findLicenseMatch(head,sub,upperSub);
    }

    private boolean findLicenseMatch(CarListNode pointer, String sub, String upperSub) {
        if (pointer == null)
            return false;
        if (pointer.data.getLicense().contains(sub)|| pointer.data.getLicense().contains(upperSub))
            return true;
        return findLicenseMatch(pointer.next,sub, upperSub);
    }//end findLicenseMatch

    //attempts to find a given combination of make and color
    public boolean findMakeAndColor(String item1,String item2) {
        if(head == null)
            return false;
        else
            return findMakeAndColor(head,item1,item2);
    }
    private boolean findMakeAndColor(CarListNode ptr,String item1,String item2) {
        if (ptr == null)
            return false;
        if (ptr.data.getMake().toUpperCase().equals(item1.toUpperCase())
                && ptr.data.getColor().toUpperCase().equals(item2.toUpperCase()))
            return true;
        else
            return findMakeAndColor(ptr.next,item1,item2);
    }//end findMakeAndColor

    public void printMakeAndColor(String item1, String item2) {
        if (isEmpty()) {}
        if(isSingleton()) {
            if(head.data.getMake().toUpperCase().equals(item1.toUpperCase())
                    && head.data.getColor().toUpperCase().equals(item2.toUpperCase())) {
                //System.out.println(head.data.toString());
                driver.write.println(head.data.toString());
                driver.write.println();
                count++;
            }
        }
        else {
            current = head;
            while (current.next != null) {
                if (current.data.getMake().toUpperCase().equals(item1.toUpperCase())
                        && current.data.getColor().toUpperCase().equals(item2.toUpperCase())) {
                    //System.out.println(current.data.toString());
                    driver.write.println(current.data.toString());
                    driver.write.println();
                    count++;
                }
                current = current.next;
            }
            if (current.data.getMake().toUpperCase().equals(item1.toUpperCase())
                    && current.data.getColor().toUpperCase().equals(item2.toUpperCase())) {
                //System.out.println(current.data.toString());
                driver.write.println(current.data.toString());
                driver.write.println();
                count++;
            }
        }
    }//end method

    public boolean findRange(int year1, int year2) {
        if (head == null)
            return false;
        else
            return findRange(head,year1,year2);
    }
    private boolean findRange(CarListNode ptr,int year1,int year2) {
        if (ptr == null)
            return false;
        if (ptr.data.getYearInt() >= year1 && ptr.data.getYearInt() <= year2)
            return true;
        else
            return findRange(ptr.next,year1,year2);
    }//end method

    public void printRange(int year1,int year2) {
        if(isEmpty()){}
        if (isSingleton()) {
            if (head.data.getYearInt() >= year1 && head.data.getYearInt() <= year2) {
                //System.out.println(head.data.toString());
                driver.write.println(head.data.toString());
                driver.write.println();
                count++;
            }
        }
        else {
            current = head;
            while (current.next != null) {
                if (current.data.getYearInt() >= year1 && current.data.getYearInt() <= year2) {
                    //System.out.println(current.data.toString());
                    driver.write.println(current.data.toString());
                    driver.write.println();
                    count++;
                }
                current = current.next;
            }
            if (current.data.getYearInt() >= year1 && current.data.getYearInt() <= year2) {
                //System.out.println(current.data.toString());
                driver.write.println(current.data.toString());
                driver.write.println();
                count++;
            }
        }
    }//end method

    public boolean findColorAndLicense(String color,String ID,String upID) {
        if(head == null)
            return false;
        else
            return findColorAndLicense(head,color,ID,upID);
    }
    private boolean findColorAndLicense(CarListNode ptr,String color,String id,String upID) {
        if (ptr == null)
            return false;
        if(ptr.data.getColor().toUpperCase().equals(color.toUpperCase())
                && (ptr.data.getLicense().contains(id) || ptr.data.getLicense().contains(upID)))
            return true;
        else
            return findColorAndLicense(ptr.next,color,id,upID);
    }//end method

    public void printColorAndLicense(String color,String id,String upID) {
        if (isEmpty()) {}
        if(isSingleton()) {
            if(head.data.getColor().toUpperCase().equals(color.toUpperCase())
                    && (head.data.getLicense().contains(id) || head.data.getLicense().contains(upID))) {
                //System.out.println(head.data.toString());
                driver.write.println(head.data.toString());
                driver.write.println();
                count++;
            }
        }
        else {
            current = head;
            while (current.next != null) {
                if (current.data.getColor().toUpperCase().equals(color.toUpperCase())
                        && (current.data.getLicense().contains(id) || current.data.getLicense().contains(upID))) {
                    //System.out.println(current.data.toString());
                    driver.write.println(current.data.toString());
                    driver.write.println();
                    count++;
                }
                current = current.next;
            }
            if (current.data.getColor().toUpperCase().equals(color.toUpperCase())
                    && (current.data.getLicense().contains(id) || current.data.getLicense().contains(upID))) {
                //System.out.println(current.data.toString());
                driver.write.println(current.data.toString());
                driver.write.println();
                count++;
            }
        }
    }//end method

    //method prints all cars that match a singular specified characteristic
    public void printCarsWithX(String item) {
        if (isEmpty()) {}
        if (isSingleton()) {
            if (head.data.getMake().toUpperCase().equals(item.toUpperCase())
                    || head.data.getColor().toUpperCase().equals(item.toUpperCase())
                    || head.data.getModel().toUpperCase().equals(item.toUpperCase())
                    || head.data.getYear().toUpperCase().equals(item.toUpperCase())
                    || head.data.getLicense().toUpperCase().equals(item.toUpperCase())) {
                //System.out.println(head.data.toString());
                driver.write.println(head.data.toString());
                driver.write.println();
                count++;
            }
        }
        else {
            current = head;
            while (current.next != null) {
                if (current.data.getMake().toUpperCase().equals(item.toUpperCase())
                        || current.data.getColor().toUpperCase().equals(item.toUpperCase())
                        || current.data.getModel().toUpperCase().equals(item.toUpperCase())
                        || current.data.getYear().toUpperCase().equals(item.toUpperCase())
                        || current.data.getLicense().toUpperCase().equals(item.toUpperCase())) {
                    //System.out.println(current.data.toString());
                    driver.write.println(current.data.toString());
                    driver.write.println();
                    count++;
                }
                current = current.next;
            }
            if (current.data.getMake().toUpperCase().equals(item.toUpperCase())
                    || current.data.getColor().toUpperCase().equals(item.toUpperCase())
                    || current.data.getModel().toUpperCase().equals(item.toUpperCase())
                    || current.data.getYear().toUpperCase().equals(item.toUpperCase())
                    || current.data.getLicense().toUpperCase().equals(item.toUpperCase())) {
                //System.out.println(current.data.toString());
                driver.write.println(current.data.toString());
                driver.write.println();
                count++;
            }
        }
    }//end printCarWithX

    public String getKey() {
        return head.data.getMake();
    }//end getKey

    //attempts to find a given string in the list
    public boolean findItem(String item) {
       return findItem(head,item);
    }
    private boolean findItem(CarListNode pointer, String item) {
        if (pointer == null)
            return false;
        if (pointer.data.getMake().toUpperCase().equals(item.toUpperCase()))
            return true;
        if (pointer.data.getModel().toUpperCase().equals(item.toUpperCase()))
            return true;
        if (pointer.data.getYear().toUpperCase().equals(item.toUpperCase()))
            return true;
        if (pointer.data.getColor().toUpperCase().equals(item.toUpperCase()))
            return true;
        if (pointer.data.getLicense().toUpperCase().equals(item.toUpperCase()))
            return true;
        return findItem(pointer.next,item);
    }//end findItem
//--------------------------------------------------------------------------------------------------------
    private class CarListNode {
        CarListNode next;
        Car data;

        private CarListNode(Car data, CarListNode next) {
            this.next = next;
            this.data = data;
        }
    }//end nested class
}//end class