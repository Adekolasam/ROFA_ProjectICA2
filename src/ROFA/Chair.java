package ROFA;

//import ROFA.Repo.IChair;
//import ROFA.Repo.*;

//implements IChair
public class Chair extends FurnitureAbs  {
    
    final private float CHAIRUNITS = 1625;
    final private float ARMRESTSUNITS = 250;
    
    protected boolean armRests;
    
    public Chair(){
        
    }
    public Chair(int idNumber, String woodType, int qty, boolean armRests){
        this.idNumber = idNumber;
        this.woodType = woodType;
        this.qty = qty;
        this.armRests = armRests;
        
        this.init();
    }
    
    public Chair(int idNumber, String woodType, float price, int qty, boolean armRests){
        this.idNumber = idNumber;
        this.woodType = woodType;
        this.price = price;
        this.qty = qty;
        this.armRests = armRests;
        
        this.init();
    }
    
    private void init(){
        this.setImage();
        this.setPrice();
    }
    
    @Override
    public final void setImage(){
        if(woodType.equals(OAKTYPE)){
            image = (!armRests) ? _imageHolder.oakChair : _imageHolder.oakChairWithArmrests;
        }
        else{
            image = (!armRests) ? _imageHolder.walnutChair : _imageHolder.walnutChairWithArmrests;
        }
    }
    
    @Override
    public final void setPrice(){
        if(woodType.equals(OAKTYPE)){
            price = OAKPRICE * CHAIRUNITS ;
            price += (armRests) ? (OAKPRICE * ARMRESTSUNITS) : 0;
        }
        else{
            price = WALNUTPRICE * CHAIRUNITS ;
            price += (armRests) ? (WALNUTPRICE * ARMRESTSUNITS) : 0;
        }
    }
    
    
    @Override
    public String toString(){
        return (
                "Id Number: " + idNumber
                + ", Item: Chair"
                + ", Price: " + price
                + ", Total Price: " + this.getCharge()
        );
    }
    
}
