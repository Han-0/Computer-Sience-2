/**
 * Project: Car DB
 * @Author: Justin Fulner
 * Date: December, 2018
 **/

public class DatabaseBST {
    private DBTreeNode root;
    private int size;
    private int count;

    public DatabaseBST() {
        root = null;
        size = 0;
        count++;
    }

    public void setCount(int count) {
        this.count = count;
        setCount(root,count);
    }

    private void setCount(DBTreeNode pointer, int count) {
        if (pointer == null) return;

        setCount(pointer.leftChild,count);
        pointer.dataList.setCount(count);
        setCount(pointer.rightChild,count);
    }

    public int getCount() { return count; }

    private boolean isEmpty() {
        return size == 0;
    }//end isEmpty

    //pair of methods to handle insertion into the BST
    //using the make of the first node in each CarList as a key
    public void insert(String make, Car car) {
        if (isEmpty()) {
            root = new DBTreeNode(null, null, new CarList());
            root.dataList.insertAtFront(car);
            size++;
        }
        else
            insert(root, make, car);
    }

    private DBTreeNode insert(DBTreeNode pointer,String make, Car car) {
        if (pointer == null) {
            pointer = new DBTreeNode(null, null, new CarList());
            pointer.dataList.insertAtFront(car);
            size++;
            return pointer;
        }
        else if (pointer.dataList.getKey().equals(make))
            pointer.dataList.insertAtFront(car);

        else {
            if (pointer.dataList.getKey().compareTo(make) > 0)
                pointer.leftChild = insert(pointer.leftChild, make, car);
            else
                pointer.rightChild = insert(pointer.rightChild, make, car);
        }
        return pointer;
    }//end insert

    //pair of methods to print the tree in order
    public void printTree() {
        printTree(root);
    }

    private void printTree(DBTreeNode pointer) {
        if (pointer == null)
            return;
        printTree(pointer.leftChild);
        pointer.dataList.printList();
        printTree(pointer.rightChild);
    }//end printTree

    //pair of methods to find if a given key already exists in the tree
    public void getItem(String item) {
        getItem(root, item);
    }

    private void getItem(DBTreeNode pointer, String item) {
        if (pointer == null)
            return;
        getItem(pointer.leftChild,item);
        pointer.dataList.printCarsWithX(item);
        count += pointer.dataList.getCount();
        getItem(pointer.rightChild,item);
    }//end getItem

    public boolean findItem(String item) {
        if (root == null)
            return false;
        else
            return findItem(root, item);
    }
    private boolean findItem(DBTreeNode pointer, String item) {
        if (pointer == null)
            return false;
        if (pointer.dataList.findItem(item))
            return true;
        else {
            return findItem(pointer.leftChild,item) || findItem(pointer.rightChild,item);
        }
    }//end findItem

    //fetches a cars that match a given substring
    public void getLicenseCombo(String sub,String upSub) {
        getLicenseCombo(root,sub,upSub);
    }
    private void getLicenseCombo(DBTreeNode pointer,String sub,String upSub) {
        if (pointer == null)
            return;
        getLicenseCombo(pointer.leftChild,sub,upSub);
        pointer.dataList.printLicenseMatch(sub,upSub);
        count += pointer.dataList.getCount();
        getLicenseCombo(pointer.rightChild,sub,upSub);
    }//end getLicenseCombo

    //pair of methods attempts to find a match to a given substring in the BST
    public boolean findLicenseCombo(String sub,String upSub) {
        if(root == null)
            return false;
        else
            return findLicenseCombo(root,sub,upSub);
    }
    private boolean findLicenseCombo(DBTreeNode pointer,String sub,String upSub) {
        if(pointer == null)
            return false;
        if (pointer.dataList.findLicenseMatch(sub,upSub))
            return true;
        else
            return findLicenseCombo(pointer.leftChild,sub,upSub) || findLicenseCombo(pointer.rightChild,sub,upSub);
    }//end findLicenseCombo

    public void getMakeAndColor(String item1,String item2) {
        getMakeAndColor(root,item1,item2);
    }
    private void getMakeAndColor(DBTreeNode ptr,String item1,String item2) {
        if(ptr == null)
            return;
        getMakeAndColor(ptr.leftChild,item1,item2);
        ptr.dataList.printMakeAndColor(item1,item2);
        count += ptr.dataList.getCount();
        getMakeAndColor(ptr.rightChild,item1,item2);
    }//end method

    public void getColorAndLicense(String color,String id,String upID) {
        getColorAndLicense(root,color,id,upID);
    }
    private void getColorAndLicense(DBTreeNode ptr,String color,String id,String upID) {
        if(ptr == null)
            return;
        getColorAndLicense(ptr.leftChild,color,id,upID);
        ptr.dataList.printColorAndLicense(color,id,upID);
        count += ptr.dataList.getCount();
        getColorAndLicense(ptr.rightChild,color,id,upID);
    }//end method

    public boolean findColorAndLicense(String color,String id,String upID) {
        if(root == null)
            return false;
        else
            return findColorAndLicense(root,color,id,upID);
    }
    private boolean findColorAndLicense(DBTreeNode ptr,String color,String id,String upID) {
        if(ptr == null)
            return false;
        if (ptr.dataList.findColorAndLicense(color,id,upID))
            return true;
        else
            return findColorAndLicense(ptr.leftChild,color,id,upID)
                    || findColorAndLicense(ptr.rightChild,color,id,upID);
    }//end method

    public boolean findMakeAndColor(String item1, String item2) {
        if (root == null)
            return false;
        else
            return findMakeAndColor(root,item1,item2);
    }
    private boolean findMakeAndColor(DBTreeNode pointer,String item1,String item2) {
        if(pointer == null)
            return false;
        if(pointer.dataList.findMakeAndColor(item1,item2))
            return true;
        else
            return findMakeAndColor(pointer.leftChild,item1,item2) || findMakeAndColor(pointer.rightChild,item1,item2);
    }//end method

    public boolean findRange(int year1,int year2) {
        if(root == null)
            return false;
        else
            return findRange(root,year1,year2);
    }
    private boolean findRange(DBTreeNode ptr,int year1,int year2) {
        if (ptr == null)
            return false;
        if(ptr.dataList.findRange(year1,year2))
            return true;
        else
            return findRange(ptr.leftChild,year1,year2) || findRange(ptr.rightChild,year1,year2);
    }//end method

    public void getRange(int year1,int year2) {
        getRange(root,year1,year2);
    }
    private void getRange(DBTreeNode pointer,int year1,int year2) {
        if (pointer == null)
            return;
        getRange(pointer.leftChild,year1,year2);
        pointer.dataList.printRange(year1,year2);
        count += pointer.dataList.getCount();
        getRange(pointer.rightChild,year1,year2);
    }
//-----------------------------------------------------------------------------
    private class DBTreeNode {

        DBTreeNode leftChild,rightChild;

        CarList dataList;

        private DBTreeNode(DBTreeNode left, DBTreeNode right, CarList data) {
            leftChild = left;
            rightChild = right;
            dataList = data;
        }
    }//end nested class
}//end class