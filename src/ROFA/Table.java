package ROFA;


public class Table extends FurnitureAbs {
    private final String WOODENBASE = "Wooden Base";
    private final float WOODENBASEPRICE = 45;
    private final float CHROMEBASEPRICE = 35;
    
    public float diameter;
    public String base;
    
    public Table(){
        
    }
    
    public Table(int idNumber, String woodType, int qty, float diameter, String base){
        this.idNumber = idNumber;
        this.woodType = woodType;
        this.qty = qty;
        this.diameter = diameter;
        this.base = base;
        
        this.init();
    }
    
    public Table(int idNumber, String woodType, float price, int qty, float diameter, String base){
        this.idNumber = idNumber;
        this.woodType = woodType;
        this.price = price;
        this.qty = qty;
        this.diameter = diameter;
        this.base = base;
        
        this.init();
    }
    
    private void init(){
        this.setImage();
        this.setPrice();
    }
    
    @Override
    public final void setImage(){
        if(woodType.equals(OAKTYPE)){
            image = (base.equals(WOODENBASE)) ? _imageHolder.oakTable_Wooden : _imageHolder.oakTable_Chrome;
        }
        else{
            image = (base.equals(WOODENBASE)) ? _imageHolder.walnutTable_Wooden : _imageHolder.walnutTable_Chrome;
        }
    }
    
    @Override
    public final void setPrice(){
        float nOfUnits = diameter * diameter;
        if(woodType.equals(OAKTYPE)){
            price = (nOfUnits * OAKPRICE);
            price *= base.equals(WOODENBASE) ? WOODENBASEPRICE : CHROMEBASEPRICE;
        }
        else{
            price = (nOfUnits * WALNUTPRICE);
            price *= base.equals(WOODENBASE) ? WOODENBASEPRICE : CHROMEBASEPRICE;
        }

    }
    
    
    @Override
    public String toString(){
        return (
                "Id Number: " + idNumber
                + ", Item: Table"
                + ", Price: " + price
                + ", Total Price: " + this.getCharge()
        );
    }
}
