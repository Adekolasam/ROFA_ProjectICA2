
package ROFA;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JOptionPane;
//import java.util.LinkedList;


public class FurnitureManager implements IFurnitureManager {
    final private FurnitureImages _imageHolder;
    
    final private String OAKTYPE = "Oak";
    final private float OAKPRICE = 4;
    //final private String WALNUTTYPE = "Walnut";
    final private float WALNUTPRICE = 3;
    final private float CHAIRUNITS = 1625;
    final private float ARMRESTSUNITS = 250;
    final private float WOODENBASEPRICE = 45;
    final private float CHROMEBASEPRICE = 35;
    final private float DESKHEIGHT = 80;
    final private int CAPACITY = 9;
    
    private float totalPrice = 0;
    
    //grid being position on the screen
    private final HashMap<Integer, Integer> grid = new HashMap<>(6);
    
    private final HashMap<Integer, Chair> chairs = new HashMap<>();
    private final HashMap<Integer, Table> tables = new HashMap<>();
    private final HashMap<Integer, Desk> desks = new HashMap<>();
    LinkedList<FurnitureAbs> furnitures = new LinkedList();

    public FurnitureManager() {
        this._imageHolder = new FurnitureImages();
    }
    
    //api to add chair
    @Override
    public Chair addNewChair(int idNumber, String woodType, int qty, boolean armRests){
        if(!checkIdNumberExists(idNumber) && checkOrderCapacity()){
            Chair chair = new Chair(idNumber, woodType, qty, armRests);
            chairs.put(chair.idNumber ,chair);
            setOtherProperties(chair.idNumber, chair.getCharge());
            return chair; //chairs.get(chair.idNumber);
        }
        else return null;
    }
    
    //api to add table
    @Override
    public Table addNewTable(int idNumber, String woodType, int qty, float diameter, String base){
        if(!checkIdNumberExists(idNumber) && checkOrderCapacity()){
            Table table = new Table(idNumber, woodType, qty, diameter, base);
            tables.put(table.idNumber ,table);
            setOtherProperties(table.idNumber, table.getCharge());
            return table; //tables.get(table.idNumber);
        }
        else return null;
    }
    
    //api to add desk
    @Override
    public Desk addNewDesk(int idNumber, String woodType, int qty, float width, float depth, int noOfDrawers){
        if(!checkIdNumberExists(idNumber) && checkOrderCapacity()){
            Desk desk = new Desk(idNumber, woodType, qty, width, depth, noOfDrawers);
            desks.put(desk.idNumber ,desk);
            setOtherProperties(desk.idNumber, desk.getCharge());
            return desk; //desks.get(desk.idNumber);
        }
        else return null;
    }
    
    //method to add furniture Id to grid and total
    private void setOtherProperties(int id, float price){
        grid.put(id, getAvailableGrid());
        this.totalPrice += price;
    }
    
    //api number of items added
    @Override
    public int getSizeOfOrder(){
        return grid.size();
    }
    
    //api to check if more items can be added to basket
    @Override
    public boolean checkOrderCapacity(){
        return (this.getSizeOfOrder() < CAPACITY);
    }
    
    //api to check if an item Id number is already added
    @Override
    public boolean checkIdNumberExists(int id){
        return grid.containsKey(id);
    }
    
    //api to get next available grid
    @Override
    public int getAvailableGrid(){
        for(int i = 1; i <= CAPACITY; i++){
            if(!grid.containsValue(i)) return i;
        }
        return 0;
    }
    
    //api to get grid position of an item on UI
    @Override
    public int getOrderGridPosition(int id){
        return grid.get(id);
    }
    
    //api to get total price of all furnitures added
    @Override
    public float getTotalOrderPrice(){
        return this.totalPrice;
    }
    
    //api to clear all furniture records already added
    @Override
    public void clearAllOrder(){
        this.totalPrice = 0;
        this.chairs.clear();
        this.tables.clear();
        this.desks.clear();
        this.grid.clear();
        this.furnitures.clear();
    }
    
    //api to get Idnumber of all furnitures and their grid position on the UI
    @Override
    public HashMap<Integer, Integer> getAllOrderGridPos(){
        return grid;
    }
    
    //api to show summary of all furniture on console
    @Override
    public void getSummaryOnConsole(){
        getAllFurnitures();
        sortFurnituresByPrice();
        printFurnituresToConsole();
    }
    
    @Override
    public boolean placeOrder(String PAN, String expirydate, String cardHolder, int cVV ){
        try {
            FileWriter myWriter = new FileWriter("placeorderfile.txt");
            myWriter.write("***CARD DETAILS***"+"\n");
            myWriter.write("Card PAN: "+PAN+"\n");
            myWriter.write("Card Expiry Date: "+expirydate+"\n");
            myWriter.write("Card Holder: "+cardHolder+"\n");
            myWriter.write("Card CVV: "+cVV+"\n\n\n");
            
            myWriter.write("***ORDER DETAILS***"+"\n");
            for(FurnitureAbs item: furnitures){
                myWriter.write(item.toString()+"\n");
            }
            myWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private void getAllFurnitures(){
        furnitures.clear();
        grid.forEach((key, value) -> {
            if(chairs.get(key) != null){
                furnitures.add(chairs.get(key));
            }
            else if(tables.get(key) != null){
                furnitures.add(tables.get(key));
            }
            else if(desks.get(key) != null){
                furnitures.add(desks.get(key));
            }
        });
    }
    
    //sort items by price
    private void sortFurnituresByPrice(){
        if(furnitures.size() > 1){
            for(int i = 0; i < furnitures.size(); i++){
                int j = i + 1;
                if((j < furnitures.size()) && (furnitures.get(i).price > furnitures.get(j).price)){
                    FurnitureAbs item = furnitures.get(i);
                    furnitures.set(i, furnitures.get(j));
                    furnitures.set(j, item);
                    i -= 1;
                }
            }
        }
    }
    
    //print all items details to console
    private void printFurnituresToConsole(){
        for(FurnitureAbs item: furnitures){
            System.out.println(item.toString());
        }
    }
    
    //api to remove an item from basket
    @Override
    public void removeGridItem(int idNumber){
        
        grid.remove(idNumber);
        float price = 0;
        
        if(chairs.containsKey(idNumber)){
            price = chairs.get(idNumber).price;
            chairs.remove(idNumber);
        }
        else if(tables.containsKey(idNumber)){
            price = tables.get(idNumber).price;
            tables.remove(idNumber);
        }
        else if(desks.containsKey(idNumber)){
            price = desks.get(idNumber).price;
            desks.remove(idNumber);
        }
        
        totalPrice -= price;
    }
    
    //api to displayitem onsoncole
    @Override
    public void displayItemOnConsole(int idNumber){
        
        if(chairs.containsKey(idNumber)){
            System.out.println(chairs.toString());
        }
        else if(tables.containsKey(idNumber)){
            System.out.println(tables.toString());
        }
        else if(desks.containsKey(idNumber)){
            System.out.println(desks.toString());
        }
    }
    
    
//    public <T> getItem(){
//        return 
//    }
    
}
