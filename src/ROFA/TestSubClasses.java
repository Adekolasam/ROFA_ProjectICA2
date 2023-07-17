
package ROFA;

/**
 *
 *
 */
public class TestSubClasses {
    
    public static void main(String args[]){
        Chair chair1 = new Chair(1,"Oak", 2, false);
        Chair chair2 = new Chair(2,"Walnut", 2, true);
        
        System.out.println("Chair Object 1 -> getCharge: "+ chair1.getCharge());
        System.out.println("Chair Object 1 -> toString: "+ chair1.toString());
        
        System.out.println("Chair Object 2 -> getCharge: "+ chair2.getCharge());
        System.out.println("Chair Object 2 -> toString: "+ chair2.toString());
        System.out.println("---------------------------------------------------------");
        
        Table table1 = new Table(3,"Oak", 2, 50, "Wooden Base");
        Table table2 = new Table(4,"Walnut", 2, 60, "Chrome Base");
        
        System.out.println("Table Object 1 -> getCharge: "+ table1.getCharge());
        System.out.println("Table Object 1 -> toString: "+ table1.toString());
        
        System.out.println("Table Object 2 -> getCharge: "+ table2.getCharge());
        System.out.println("Table Object 2 -> toString: "+ table2.toString());
        
        System.out.println("---------------------------------------------------------");
        
        Desk desk1 = new Desk(5,"Oak", 2, 50,50,1);
        Desk desk2 = new Desk(6,"Walnut", 2, 50,50, 2);
        
        System.out.println("Desk Object 1 -> getCharge: "+ desk1.getCharge());
        System.out.println("Desk Object 1 -> toString: "+ desk1.toString());
        
        System.out.println("Desk Object 2 -> getCharge: "+ desk2.getCharge());
        System.out.println("Desk Object 2 -> toString: "+ desk2.toString());
        
    }
}
