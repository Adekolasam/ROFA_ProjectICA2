
package ROFA;

import java.util.HashMap;

/**
 *
 * 
 */
public interface IFurnitureManager {
    //api to add chair
    public Chair addNewChair(int idNumber, String woodType, int qty, boolean armRests);
    //api to add table
    public Table addNewTable(int idNumber, String woodType, int qty, float diameter, String base);
    //api to add desk
    public Desk addNewDesk(int idNumber, String woodType, int qty, float width, float depth, int noOfDrawers);
    
    //api number of items added
    public int getSizeOfOrder();
    
    //api to check if more items can be added to basket
    public boolean checkOrderCapacity();
    
    //api to check if an item Id number is already added
    public boolean checkIdNumberExists(int id);
    
    //api to get next available grid
    public int getAvailableGrid();
    
    //api to check if an has already been added
    //public boolean checkGridContainsItem(int idNumber);
    
    //api to get grid position of an item on UI
    public int getOrderGridPosition(int id);
    
    //api to get total price of all furnitures added
    public float getTotalOrderPrice();
    
    //api to clear all furniture records already added
    public void clearAllOrder();
    
    //api to get Idnumber of all furnitures and their grid position on the UI
    public HashMap<Integer, Integer> getAllOrderGridPos();
    
    //api to show summary of all furniture on console
    public void getSummaryOnConsole();
    
    //api to print order to file
    public boolean placeOrder(String PAN, String expirydate, String cardHolder, int cVV);
    
    //api to remove an item from basket
    public void removeGridItem(int idNumber);
    
    //api to displayitem onsoncole
    public void displayItemOnConsole(int idNumber);
}
